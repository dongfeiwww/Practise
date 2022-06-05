import java.util.*;
// https://github.com/allaboutjst/airbnb/blob/master/src/main/java/k_edit_distance/KEditDistance.java
public class KEditDistance {
	class Node{
		boolean isLeaf;
		Node[] children;
		public Node() {
			this.children = new Node[26];
		}
	}
	
	class TrieTree{
		Node root;
		public TrieTree() {
			root = new Node();
		}

		public void insert(String s) {
			if(s==null||s.length()==0) return;
			Node p = root;
			for(int i = 0 ; i < s.length() ; i++) {
				char c =s.charAt(i);
				if(p.children[c-'a']==null) {
					p.children[c-'a']=new Node();
				}
				if(i==s.length()-1) {
					p.children[c-'a'].isLeaf=true;
				}
				
				p = p.children[c-'a'];
			}
		}
	}
	
	public List<String> getKEditDistance(String[] words, String target, int k){
		List<String> res = new ArrayList<>();
		 if (words == null || words.length == 0 || target == null ||
                 target.length() == 0 || k < 0) {
             return res;
         }
		 
		 TrieTree tree = new TrieTree();
		 for(String word:words) {
			 tree.insert(word);
		 }
		
		 Node root = tree.root;
		 
		 int[] prev = new int[target.length()+1];
		 for(int i = 0 ; i < prev.length; i++) {
			 prev[i]=i;
		 }
		 search("", target,k,root,prev,res);
		 return res;
	}
	
	public void search(String curr,String target,int k, Node root,int[] prev, List<String> res) {
		if (root.isLeaf) {
			if (prev[target.length()]<=k) {
				res.add(curr);
			}
      else 
        return;
		}
		for(int i = 0 ; i < 26 ;i++) {
			if(root.children[i]==null) {
				continue;
			}
			int[] curDist = new int[target.length()+1];
			curDist[0]=curr.length()+1;
			for(int j=1; j <prev.length;j++) {
				if(target.charAt(j-1)==(char)i-'a'){
					curDist[j]=prev[j-1];
				}
				else {
					curDist[j]=Math.min(Math.min(prev[j-1],prev[j]), curDist[j-1]+1);
				}
			}
			search(curr+(char)(i+'a'),target,k,root.children[i],curDist,res);
		}
	}
}