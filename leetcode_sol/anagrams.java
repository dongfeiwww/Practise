/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/
import java.util.Comparator;
import java.util.*;
import java.util.Hashtable;
import java.util.LinkedList;

public class Solution {
    public  String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }   

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
     
        /* Group words by anagram */
        for (String s : strs) {
            String key = sortChars(s); 
            if (!hash.containsKey(key)) {
                hash.put(key, new LinkedList<String>());
            }   
            LinkedList<String> anagrams = hash.get(key);
            anagrams.push(s);
        } 
        for (String key : hash.keySet()) {
            LinkedList<String> list = hash.get(key);
            if (list.size() > 1) {
                for (String t : list) {
                    res.add(t);
                }   
            }
        }   
        return res;
    }
}
