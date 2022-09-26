class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjMap = getAdjMap(tickets);
        Map<String, boolean[]> visitedMap = getVisitedMap(adjMap);
    
        List<String> path = new LinkedList<>();
        path.add("JFK");
        backtrack("JFK", adjMap, visitedMap, path, tickets.size());
        return path;
    }
    
    private boolean backtrack(String src, Map<String, List<String>> adjMap, Map<String, boolean[]> visitedMap, List<String> path, int edges) {
        if(path.size() == edges+1)
            return true;
        
        if(adjMap.containsKey(src)) {
            for(int i=0 ; i<adjMap.get(src).size() ; i++) {
                String nbr = adjMap.get(src).get(i);
                
                if(!visitedMap.get(src)[i]) {
                    visitedMap.get(src)[i] = true;
                    path.add(nbr);
                    
                    if(backtrack(nbr, adjMap, visitedMap, path, edges))
                        return true;
                    
                    path.remove(path.size()-1);
                    visitedMap.get(src)[i] = false;
                }
            }
        }
        return false;
    }
    
    private Map<String, List<String>> getAdjMap(List<List<String>> tickets) {
        Map<String, List<String>> adjMap = new HashMap<>();
        
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            adjMap.putIfAbsent(src, new ArrayList<>());
            adjMap.get(src).add(dest);
        }
        return adjMap;
    }
    
    private Map<String, boolean[]> getVisitedMap(Map<String, List<String>> adjMap) {
        Map<String, boolean[]> visitedMap = new HashMap<>();
        
        for(String key : adjMap.keySet()) {
            Collections.sort(adjMap.get(key));
            visitedMap.put(key, new boolean[adjMap.get(key).size()]);
        }
        return visitedMap;
    }
}