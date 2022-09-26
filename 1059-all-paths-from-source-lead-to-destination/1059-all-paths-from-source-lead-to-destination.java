class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int[] edge : edges) {
            if (adjList[edge[0]] == null) adjList[edge[0]] = new ArrayList<>();
            adjList[edge[0]].add(edge[1]);
        }
        return dfs(source, destination, adjList, new boolean[n], new boolean[n]);
    }

    private boolean dfs(int source, int dest, List<Integer>[] adjList, boolean[] visiting, boolean[] visited) {
        if (adjList[source] == null) return source == dest;

        if (visited[source]) return true;
        if (visiting[source]) return false;
        visiting[source] = true;
        for (int neighbour : adjList[source])
            if (!dfs(neighbour, dest, adjList, visiting, visited)) return false;
        visiting[source] = false;
        visited[source] = true;
        return true;
    }
}