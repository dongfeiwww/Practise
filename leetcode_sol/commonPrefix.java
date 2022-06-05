// Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = strs.length;
        if (size < 1)
            return "";
        
        String first = strs[0];
        int j;
        for (int i =0; i < first.length(); i++) {
            
            for (j = 1; j < size; j++) {
                if (i >= strs[j].length())
                    break;
                if (strs[j].charAt(i) != first.charAt(i))
                    break;
            }
            
            if (j != size) {
                return first.substring(0, i);
            }
        }
        return first;
    }
}
