//Approach - 1:  Trie
//Time Complexity : O(n*l) ; n words  with length l
//Space Complexity : O(n)


class Solution {
    
    //Declare the TrieNode
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    
    
    
     //Intialize root
    TrieNode root;
    //Global root O-->children[26] .... soon on
    

    String result;
    
    //Main function
    public String longestWord(String[] words) {
        
        //allocate memory to it; root ==> children and isEnd
        root = new TrieNode();
        
        result="";
        
        
        //Insert all the words into the TrieNode and mark true;
        for(String word: words){
            insert(word);
        }
        
        //Search for those words in TrieNode by using backTracking
        
        //root is first starting point of the node and StringBuilder is for path 
        backtracking(root, new StringBuilder());
        
        return result;
    }
    
    
    private void insert(String word){   
        
        //assign to current node
        TrieNode curr = root;
        
        //loop the word
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i); 
    
            if(curr.children[c-'a'] == null){ 
                
             // there is no trieNode, create a new triNode 
                curr.children[c-'a'] = new TrieNode();
            }
            
            //move my current to currents baby;
            curr = curr.children[c-'a']; 
        }
        curr.isEnd = true; // means words exits in Trie
    }
    
    
    private void backtracking(TrieNode root, StringBuilder curr){
        
        //base
        if(curr.length() > result.length()){
            result = curr.toString();
        }
        
        
        //logic
        //forloop base recursion 
        
        for(int i=0; i<26;i++){
            //children of root
            TrieNode child = root.children[i];            
            if(child != null && child.isEnd){
                
                int length = curr.length();

                //action
                curr.append((char)('a' + i)); // conver int to char
                
                //recurse
                backtracking(child, curr);
                
                //backtrack                
                curr.setLength(length);
                System.out.println(length);
                
            }
        }
       
    }
     
    
}
