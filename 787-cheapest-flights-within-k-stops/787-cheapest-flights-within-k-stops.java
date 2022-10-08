// class Solution {
    
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         List<int[]>[] adjList = getAdjList(n, flights);
        
//         int[] dist = new int[n];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[src] = 0;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2) -> {
//             // if(i1[2] != i1[2])
//             //     return i1[2]-i2[2];
//             return i1[1]-i2[1];
//         });
//         pq.add(new int[] {src,0,0});
                
//         while(!pq.isEmpty()) {
//             int[] cur = pq.poll();
//             int curId = cur[0];
//             int curWt = cur[1];
//             int curFlights = cur[2];
            
//             // if(curId==dst)
//             //     return curWt;
            
//             List<int[]> nbrs = adjList[curId];
//             for(int[] nbr : nbrs) {
//                 int nbrId = nbr[0];
//                 int nbrWt = nbr[1];
//                 int totalWt = curWt + nbrWt;
                
//                 if(curFlights<=k && totalWt < dist[nbrId]) {                
//                     dist[nbrId] = totalWt;
//                     pq.add(new int[] {nbrId, dist[nbrId], curFlights+1});
//                 }
//             }
//         }
//         return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
//     }
    
//     private List<int[]>[] getAdjList(int n, int[][] flights) {
//         List<int[]>[] adjList = new ArrayList[n];
        
//         for(int i=0 ; i<n ; i++) 
//             adjList[i] = new ArrayList<>();
        
//         for(int[] flight : flights)
//             adjList[flight[0]].add(new int[] {flight[1], flight[2]});
        
//         return adjList;
//     }
// }


class Pair
{
    int stops;
    int node;
    int dist;
    public Pair(int s,int node,int dis)
    {
        stops=s;
        this.node=node;
        dist=dis;
    }
}
class Pairs
{
    int stop;
    int distance;
    public Pairs(int s,int d)
    {
        stop=s;
        distance=d;
    }
}
class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        List<List<Pairs>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)  adj.add(new ArrayList<Pairs>());
        for(int i=0;i<flights.length;i++)
        {
            int[] curr=flights[i];
            List<Pairs> lst=adj.get(flights[i][0]);
            lst.add(new Pairs(flights[i][1],flights[i][2]));
        }
        Queue<Pair> que=new LinkedList<>();
        int[] dist=new int[n];
        Pair start=new Pair(0,src,0);
        que.add(start);
        Arrays.fill(dist,Integer.MAX_VALUE);
        while(!que.isEmpty())
        {
            Pair top=que.peek();
            que.remove();
            int stops=top.stops;
            int node=top.node;
            int distance=top.dist;
            for(Pairs curr : adj.get(node))
            {
                int destination=curr.stop;
                int amount=curr.distance;
                if(stops<=k && dist[destination]>distance+amount)
                {
                    dist[destination]=distance+amount;
                    que.add(new Pair(stops+1,destination,distance+amount));
                }
            }
        }
        int ans=dist[dst];
        return (ans==Integer.MAX_VALUE) ? -1 : ans;
    }
}