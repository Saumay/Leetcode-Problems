class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSet ds = new DisjointSet(n);
        
        PriorityQueue<Edge> edgesPq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        
        // Add all edges in PQ
        for(int i=0 ; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                int[] src = points[i];
                int[] dest = points[j];
                
                Edge edge = new Edge(i, j, getDistance(src, dest));
                edgesPq.add(edge);
            }
        }
        
        // Get MST edges by polling edges from Priority Queue
        int cost = 0;
        int mstEdges = 0;
        while(mstEdges<n-1) {
            Edge minEdge = edgesPq.poll();
            
            if(!ds.connected(minEdge.src, minEdge.dest)) {
                ds.union(minEdge.src, minEdge.dest);
                cost += minEdge.weight;
                mstEdges++;
            }
        }
        return cost;
    }
    
    private int getDistance(int[] src, int[] dest) {
        return Math.abs(src[0]-dest[0]) + Math.abs(src[1]-dest[1]);
    }
}

class Edge {
    int src;
    int dest;
    int weight;
    
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class DisjointSet {
    
    private int[] root;
    private int[] rank;
    
    public DisjointSet(int n) {
        root = new int[n];
        rank = new int[n];
        
        for(int i=0 ; i<n ; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    private int find(int x) {
        if(x == root[x])
            return x;
        
        root[x] = find(root[x]);
        return root[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            if(root[rootX] < root[rootY]) 
                root[rootX] = rootY;
            else if(root[rootX] > root[rootY])
                root[rootY] = rootX;
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}