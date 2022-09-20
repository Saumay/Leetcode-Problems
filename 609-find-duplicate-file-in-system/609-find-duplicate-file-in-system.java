class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> contentFileMap = new HashMap<>();
        
        for(String str : paths) {
            String[] splitted = str.split("\s");
            
            String path = splitted[0];
            for(int i=1 ; i<splitted.length ; i++) {
                int bracketIdx = splitted[i].indexOf("(");
                String fileName = splitted[i].substring(0, bracketIdx);
                String content = splitted[i].substring(bracketIdx+1, splitted[i].length()-1);
                
                contentFileMap.putIfAbsent(content, new ArrayList<>());
                contentFileMap.get(content).add(path + "/" + fileName);
            }
        }
        return contentFileMap.values().stream()
            .filter(pathList -> pathList.size() > 1)
            .collect(Collectors.toList());
    }
}