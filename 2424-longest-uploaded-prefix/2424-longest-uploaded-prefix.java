class LUPrefix {
    
    // 1) Using array + max variable
//     private boolean[] seen;
//     private int max;
    
//     public LUPrefix(int n) {
//         seen = new boolean[n+1];
//         seen[0] = true;
//     }
    
//     public void upload(int video) {
//         seen[video] = true;
        
//         for(int i=0 ; i<seen.length ; i++) {
//             if(seen[i])
//                 max = i;
//             else
//                 break;
//         }
//     }
    
//     public int longest() {
//         return max;
//     }
    
    
    // 2) Using Set + DisjointSet
//     private Set<Integer> seen;
//     private DisjointSet ds;
    
//     public LUPrefix(int n) {
//         seen = new HashSet<>();
//         seen.add(0);
        
//         ds = new DisjointSet(n+1);
//     }
    
//     public void upload(int video) {
//         seen.add(video);
        
//         if(seen.contains(video-1))
//             ds.union(video-1, video);
//         if(seen.contains(video+1))
//             ds.union(video, video+1);
//     }
    
//     public int longest() {
//         return ds.find(0);
//     }
    
    
//     class DisjointSet {
//         int[] root;

//         public DisjointSet(int n) {
//             root = new int[n+1];

//             for(int i=0 ; i<n+1 ; i++) {
//                 root[i] = i;
//             }
//         }

//         public void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);

//             if(rootX != rootY) {
//                 if(rootX > rootY)
//                     root[rootY] = rootX;
//                 else
//                     root[rootX] = rootY;
//             }
//         }

//         public int find(int x) {
//             if(root[x]==x)
//                 return root[x];

//             root[x] = find(root[x]);
//             return root[x];
//         }
//     }
    
    
    // 3) 
    private TreeSet<Integer> set;
    private int n;
    
    public LUPrefix(int n) {
        this.set = new TreeSet<>();
        this.n = n;
        
        for(int i=1 ; i<=n ; i++)
            set.add(i);
    }
    
    public void upload(int video) {
        set.remove(video);
    }
    
    public int longest() {
        return set.isEmpty() ? n : set.first()-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */