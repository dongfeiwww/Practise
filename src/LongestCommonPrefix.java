import java.util.*;


public class LongestCommonPrefix {
  static class Node{
    char c;
    Node parent;
    Map<Character, Node> children;
    String word;
    int depth;

    public Node(Node parent, char c){
        children = new HashMap<Character, Node>();
        this.parent = parent;
        if (parent == null) depth = 0;
        else depth = parent.depth+1;
        this.c = c;
    }

    public void addChild(char c){
        assert(children.get(c) == null);
        children.put(c, new Node(this, c));
    }

    public Node getChild(char c){
        return children.get(c);
    }
  };

  private String commonPrefix_with_trie(String[] words) {
    Node root = new Node(null, ' ');
    String longestPrefix = "";
    int maxLength = 0;
    for(int i = 0 ; i < words.length ; i++){
        Node ptr = root;
        String word = words[i];
        for (char c: word.toCharArray()){
            if (ptr.getChild(c) == null) {
              ptr.addChild(c);
            }

            if (ptr.children.size() > 1 && ptr.depth > maxLength) {
              maxLength = ptr.depth;
              longestPrefix = buildReversePath(ptr);
            }

            ptr = ptr.getChild(c);
        }
        ptr.word = word;
    }
    return longestPrefix;
  }

  private String buildReversePath(Node ptr) {
    String s = "";
    while (ptr != null) {
      s = ptr.c + s;
      ptr = ptr.parent;
    }
    return s;
  }

  String commonPrefix(String[] words) {
    if (words == null && words.length <=0) return null;
    String longestPrefix = "";
    HashSet<String> prefixes = new HashSet<String>();
    for (String word: words) {
      for (int i=1; i<word.length(); i++) {
        String prefix = word.substring(0, i);
        if (prefixes.contains(prefix) && prefix.length() > longestPrefix.length()) {
          longestPrefix = prefix;
        } else
          prefixes.add(prefix);
      }
    }
    return longestPrefix;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LongestCommonPrefix l = new LongestCommonPrefix();
    String[] words = new String[5];
    words[0] = "basic";
    words[1] = "bass";
    words[2] = "anchor";
    words[3] = "bandage";
    words[4] = "anchovy";

    System.out.println("first:" + l.commonPrefix(words));
    System.out.println("second:" + l.commonPrefix_with_trie(words));
  }

}
