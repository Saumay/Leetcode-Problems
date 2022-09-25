class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = getAdjMap(equations, values);
        
        double[] result = new double[queries.size()];
        for(int i=0 ; i<queries.size() ; i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            
            if(graph.containsKey(src) && graph.containsKey(dest)) {
                Set<String> seen = new HashSet<>();
                seen.add(src);
                result[i] = dfs(graph, src, dest, seen);
            } else {
                result[i] = -1.0;
            }
        }
        return result;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String src, String dest, Set<String> seen) {
        if(src.equals(dest))
            return 1.0;
        
        Map<String, Double> nbrs = graph.get(src);
        for(Map.Entry<String, Double> nbrEntry : nbrs.entrySet()) {
            String nbr = nbrEntry.getKey();
            if(!seen.contains(nbr)) {
                seen.add(nbr);
                double res = dfs(graph, nbr, dest, seen);
                if(res != -1.0)
                    return nbrEntry.getValue()*res;
            }
        }
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> getAdjMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> adjMap = new HashMap<>();
        
        for(int i=0 ; i<equations.size() ; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            Double weight = values[i];
            
            adjMap.putIfAbsent(src, new HashMap<>());
            adjMap.putIfAbsent(dest, new HashMap<>());
            
            adjMap.get(src).put(dest, weight);
            adjMap.get(dest).put(src, 1.0/weight);
        }
        return adjMap;
    }
}