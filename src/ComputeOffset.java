import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ComputeOffset {
  String ip;
  int port;
  String echo;
  PrintWriter out;
  BufferedReader in;

  public ComputeOffset(String ip, int port, String echo) throws UnknownHostException, IOException {
    this.ip = ip;
    this.port = port;
    this.echo = echo;
    Socket echoSocket = new Socket(ip, port);
    out = new PrintWriter(echoSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
  }

  double getOffset() {
    try {
      double startTime = System.currentTimeMillis();
      out.println(echo);
      String result = in.readLine();
      String[] segs = result.split(" ");
      double serverTimestamp = Double.parseDouble(segs[1]) * 1000;
      double endTime = System.currentTimeMillis();
      double roundTripTime = endTime - startTime;
      double latency = roundTripTime/2;
      double offset = serverTimestamp - latency - startTime;
      return offset>0? offset: -offset;
    } catch (Exception e) {
      return 0.0;
    }
  }

  double getAverage(int times) {
    double total = 0;
    for (int i=0; i<times; i++) {
      total += getOffset();
    }
    return total/times;
  }

  public static void main(String[] args) throws UnknownHostException, IOException {
    // TODO Auto-generated method stub
    String ip = "172.16.0.91";
    int port = 23456;
    String echo = "PING";
    ComputeOffset c = new ComputeOffset(ip, port, echo);
    System.out.println(c.getOffset());
    System.out.println("10 times on average:" + c.getAverage(10));
  }
}
