class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        
        partitionHelper(s, 0, new LinkedList<>(), result);
        return result;
    }
    
    private void partitionHelper(String s, int idx, List<String> partition, List<List<String>> result) {
        if(idx==s.length()) {
            result.add(new LinkedList<>(partition));
            return;
        }
        
        for(int i=idx ; i<s.length() ; i++) {
            String str = s.substring(idx, i+1);
            
            if(isPalindrome(str)) {
                partition.add(str);
                partitionHelper(s, i+1, partition, result);
                partition.remove(partition.size()-1);
            }
        }
    }
    
    Map<String, Boolean> cache = new HashMap<>();
    private boolean isPalindrome(String str) {
        if(cache.containsKey(str))
            return cache.get(str);
        if(str.length()<=1)
            return true;
        if(str.length() == 2 && str.charAt(0)==str.charAt(1))
            return true;
        
        int len = str.length();
        boolean ans = str.charAt(0) == str.charAt(len-1) && isPalindrome(str.substring(1, len-1));
        cache.put(str, ans);
        return ans;
    }
}