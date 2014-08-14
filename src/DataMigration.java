
public class DataMigration {

  String mysqlConnect;
  String mysqlTable;
  int batchSize;
  SynchronousMySqlReader reader;
  AsyncHttp asyncHttp;
  String url;
  public DataMigration(String connect, String table, String url, int batchSize) {
    batchSize= batchSize;
     reader = new SynchronousMySqlReader(connect, table);
     asyncHttp = new AsyncHttp();
     this.url = url;
    try {
      reader.connect();
    } catch (Exception e) {
      throw new Exception("connection failed to mysql at connect:" + connect + " table:" + table);
    }
  }

  void migrate() {
    String line;
    int count = 0;
    String[] buffer = new String[batchSize];
    while (line = reader.nextRow() != null) {
      buffer[count++] = line;
      if (count >= 100) {
        String postBody = contructBody(buffer, count);
        sendHttpRequest(postBody.toString(), url);
        // reset buffer
        for (int i=0; i<count; i++)
          buffer[i] = "";
        count = 0;
      }
    }

    // reminding data
    if (count > 0) {
      String postBody = contructBody(buffer, count);
      sendHttpRequest(postBody, url);
    }

    reader.close();
  }

  private String contructBody(String[] buffer, int count) {
    StringBuffer postBody = new StringBuffer();
    for (int i=0; i<count; i++) {
      postBody.append(buffer[i]);
      postBody.append("\n");
    }
    return postBody.toString();
  }

  private void sendHttpRequest(String postBody, String url) {
    AsyncHttp.RequestId requestId = asyncHttp.makeRequest(url, postBody);
    if (asyncHttp.didFail(requestId)) {
      throw new Exception("can not send request. RequestId:" + requestId + " url:" + url);
    }

    while (!asyncHttp.isDone()) {
      // sleep 1 second
      sleep(1000);
    }

    if (asyncHttp.getResponseCode(requestId)!=200) {
      sendHttpRequest(postBody);
    }
  }

  public static void main(String[] args) {
    DataMigration dm = new DataMigration("mysqlconnect", "migrationTable", "httpUrl", 100);
    dm.migrate();
  }

}
