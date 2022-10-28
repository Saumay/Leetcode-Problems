class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String charCountStr = getCharCountStr(str);
            
            map.putIfAbsent(charCountStr, new ArrayList<>());            
            map.get(charCountStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
    
    private String getCharCountStr(String str) {
        int[] arr = new int[26];        
        for(int i=0 ; i<str.length() ; i++) {
            arr[str.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] > 0) {
                sb.append(String.valueOf((char)('a' + i)));
                sb.append(String.valueOf(arr[i]));
            }
        }
        return sb.toString();
    }
}