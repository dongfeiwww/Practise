import java.util.ArrayList;
import java.util.List;

public class CSVReader {
  char sep;
  public CSVReader(char sep) {
    this.sep = sep;
  }

  String parseCSV(String input) {
    StringBuffer sb = new StringBuffer();
    List<String> words = generateWords(input);
    for (String word: words) {
      sb.append(transform(word));
      sb.append(sep);
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }

  public String transform(String word) {
    StringBuffer sb = new StringBuffer();
    for (int i=0; i<word.length()-1; i++) {
      if (word.charAt(i)=='"' && word.charAt(i+1) == '"') {
        sb.append('"');
        i++;
      } else {
        sb.append(word.charAt(i));
      }
    }
    if (word.charAt(word.length()-1) != '"')
      sb.append(word.charAt(word.length()-1));
    return sb.toString();
  }

  private List<String> generateWords(String input) {
    List<String> list = new ArrayList<String>();
    int start =0;
    int count = 0;
    for (int i=0; i<input.length(); i++) {
      char c = input.charAt(i);
      if (c == '"') {
        if (i+1 < input.length() && input.charAt(i+1) == '"') {
          i++;
          while (input.charAt(++i) != '"');
          i++;
          String word =input.substring(start+1, i+1);
          list.add(word);
          start = i+2;
        }
        else {
          count++;
          if (count == 2 && start+1<input.length()) {
            String word =input.substring(start+1, i);
            list.add(word);
            start = i +1;
            count = 0;
          }
        }
      }
      else if (c == ',' && count < 1 ) {
        if (start != i) {
          String word = input.substring(start, i);
          list.add(word);
        }
        start = i+1;
      }
    }
    if (start < input.length())
      list.add(input.substring(start));

    return list;
  }


  public static void main(String[] args) {
    CSVReader reader = new CSVReader('|');
    String input = "John,Smith,\"San Francisco, CA\",\"Alexandra \"\"Alex\"\"\"";
    String result = reader.parseCSV(input);
    System.out.println(reader.transform("Alexandra \"\"Alex\"\"\"aaa"));
    System.out.println(result);
    System.out.println(result.equals("John|Smith|San Francisco, CA|Alexandra \"Alex\""));
  }
}
