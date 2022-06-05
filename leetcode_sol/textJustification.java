/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result=new ArrayList<String>();
        int index=0;
        while(index<words.length){
            int begin=index;
            int size=0;
            while(index<words.length){
                int newSize=index==begin?words[index].length():size+1+words[index].length();
                if(newSize<=L) size=newSize;
                else break;
                index++;
            }
            int spaceCount=L-size;
            int everyCount=0;
            if(index-1-begin!=0&&index!=words.length){
                everyCount=spaceCount/(index-1-begin);
                spaceCount %=(index-1-begin);
            }
            String s="";
            for(int i=begin;i<index;i++){
                if(i==begin) s=words[i];
                else{
                    s +=" ";
                    for(int j=0;j<everyCount;j++) s +=" ";
                    if(spaceCount>0&&index!=words.length){
                        s +=" ";
                        spaceCount--;
                    }
                    s +=words[i];
                }
            }
            for(int i=0;i<spaceCount;i++) s +=" ";
            result.add(s);
        }
        return result;
    }
}
