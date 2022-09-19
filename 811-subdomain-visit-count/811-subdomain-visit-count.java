class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String str : cpdomains) {
            int spaceIdx = str.indexOf(" ");
            int count = Integer.parseInt(str.substring(0, spaceIdx));
            
            String domain = str.substring(spaceIdx+1);
            while(domain.length() > 0) {
                map.put(domain, map.getOrDefault(domain, 0)+count);
                
                if(domain.indexOf(".") <= 0)
                    break;
                domain = domain.substring(domain.indexOf(".")+1);
            }
        }
        return map.entrySet().stream()
            .map((e1) -> e1.getValue() + " " + e1.getKey())
            .collect(Collectors.toList());
    }
}