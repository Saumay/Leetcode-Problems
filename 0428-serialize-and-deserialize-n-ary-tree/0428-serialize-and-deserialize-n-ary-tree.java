/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    
    
    // 1) Approach 1: Storing size of children array with parent in DFS order. Using Top Down Recursion
    public String serialize(Node root) {
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(Node root, StringBuilder sb) {
        sb.append(root.val + ",");
        sb.append(root.children.size() + ",");
        
        for(Node child : root.children) {
            serializeHelper(child, sb);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;
        
        String[] splitted = data.split(",");
        return deserializeHelper(splitted, new int[] {0});
    }
    
    private Node deserializeHelper(String[] data, int[] index) {
        Node node = new Node(Integer.parseInt(data[index[0]]), new ArrayList<>());
        index[0]++;
        int childrenCount = Integer.parseInt(data[index[0]]);
        index[0]++;
        
        for(int i=0 ; i<childrenCount ; i++) {
            node.children.add(deserializeHelper(data, index));
        }
        
        return node;
    }
    
    
    // 2) Approach 2: Adding sentinel in DFS order. Using Top Down Recursion
//     public String serialize(Node root) {
//         if(root == null)
//             return "";
        
//         StringBuilder sb = new StringBuilder();
//         serializeHelper(root, sb);
//         return sb.toString();
//     }
    
//     private void serializeHelper(Node root, StringBuilder sb) {
//         sb.append(root.val + ",");
        
//         for(Node child : root.children)
//             serializeHelper(child, sb);
        
//         sb.append("#,");
//     }
    
//         // Decodes your encoded data to tree.
//     public Node deserialize(String data) {
//         System.out.println(data);
        
//         if(data.isEmpty())
//             return null;
        
//         String[] splitted = data.split(",");
//         return deserializeHelper(splitted, new int[] {0});
//     }
    
//     private Node deserializeHelper(String[] splitted, int[] idx) {
//         Node root = new Node(Integer.parseInt(splitted[idx[0]]), new ArrayList<>());
        
//         idx[0]++;
            
//         while(idx[0]<splitted.length && !splitted[idx[0]].equals("#")) {
//             root.children.add(deserializeHelper(splitted, idx));
//         }
//         idx[0]++;
        
//         return root;
//     }
    
    
    // 3) Approach 3.1: Using Level Order Traversal and sentinel node after each level
//     public String serialize(Node root) {
//         if(root == null)
//             return "";
        
//         StringBuilder sb = new StringBuilder();
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
//         sb.append(root.val + ",");
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
            
//             for(int i=0 ; i<size ; i++) {
//                 Node node = queue.remove();
                
//                 sb.append("|,");
                
//                 for(Node child : node.children) {
//                     sb.append(child.val + ",");
//                     queue.add(child);
//                 }
//             }
//         }
//         System.out.println(sb.toString());
//         return sb.toString();
//     }
	
//     // Decodes your encoded data to tree.
//     public Node deserialize(String data) {
//         if(data.isEmpty())
//             return null;
        
//         String[] splitted = data.split(",");
//         Queue<Node> queue = new LinkedList<>();
//         Node root = new Node(Integer.parseInt(splitted[0]), new LinkedList<>());
//         queue.add(root);
        
//         Node node = null;
//         for(int i=1 ; i<splitted.length ; i++) {
//             if(splitted[i].equals("|")) {
//                 node = queue.remove();
//             } else {
//                 Node newNode = new Node(Integer.parseInt(splitted[i]), new LinkedList<>());
//                 node.children.add(newNode);
//                 queue.add(newNode);
//             }
//         }
//         return root;
//     }
    
    // 3) Approach 3.2: Using Level Order Traversal and sentinel node after each level. Store in char instead of separating by delimiter
//     public String serialize(Node root) {
//         if(root == null)
//             return "";
        
//         StringBuilder sb = new StringBuilder();
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
//         sb.append((char)(root.val + '0'));
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
            
//             for(int i=0 ; i<size ; i++) {
//                 Node node = queue.remove();
                
//                 sb.append("#");
                
//                 for(Node child : node.children) {
//                     sb.append((char)(child.val + '0'));
//                     queue.add(child);
//                 }
//             }
//         }
//         return sb.toString();
//     }
	
//     // Decodes your encoded data to tree.
//     public Node deserialize(String data) {
//         if(data.isEmpty())
//             return null;
        
//         Queue<Node> queue = new LinkedList<>();
//         Node root = new Node(data.charAt(0)-'0', new ArrayList<>());
//         queue.add(root);
        
//         Node temp = null;
//         for(int i=1 ; i<data.length() ; i++) {
//             if(data.charAt(i) == '#' && !queue.isEmpty()) {
//                 temp = queue.remove();
//             } else {
//                 Node newNode = new Node(data.charAt(i)-'0', new ArrayList<>());
//                 temp.children.add(newNode);
//                 queue.add(newNode);
//             }
//         }
//         return root;
//     }
 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));