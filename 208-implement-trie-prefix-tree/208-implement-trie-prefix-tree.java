class Node {
    private Node[] links;
    private boolean isEnd;
    
    Node() {
        links = new Node[26];
        isEnd = false;
    }
    
    public boolean contains(char ch) {
        return links[ch-'a']!=null;
    }
    
    public void put(char ch, Node node) {
        links[ch-'a'] = node;
    }
    
    public Node get(char ch) {
        return links[ch-'a'];
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void setEnd() {
        isEnd = true;
    }
}


class Trie {
    
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        
        for(int i=0 ; i<word.length() ; i++) {
            char ch = word.charAt(i);
            
            if(!temp.contains(ch))
                temp.put(ch, new Node());
            temp = temp.get(ch);
        }
        temp.setEnd();
    }
    
    private Node getLastNode(String word) {
        Node temp = root;
        
        for(int i=0 ; i<word.length() ; i++) {
            char ch = word.charAt(i);
            
            if(temp.contains(ch))
                temp = temp.get(ch);
            else
                return null;
        }
        return temp;
    }
    
    public boolean search(String word) {
        Node lastNode = getLastNode(word);
        return lastNode!=null && lastNode.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node lastNode = getLastNode(prefix);
        return lastNode!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */