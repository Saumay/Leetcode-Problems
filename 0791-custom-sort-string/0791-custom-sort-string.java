class Solution {
    
    // Solution 1: Sorting the string using custom comparator
    /*
    public String customSortString(String order, String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for(int i=0 ; i<order.length() ; i++) {
            charIndexMap.put(order.charAt(i), i);
        }
        
        Character[] charArr = convertToCharArray(s);
        Arrays.sort(charArr, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return charIndexMap.getOrDefault(c1, Integer.MAX_VALUE) - charIndexMap.getOrDefault(c2, Integer.MAX_VALUE);
            }
        });
        return convertToString(charArr);
    }
    
    private Character[] convertToCharArray(String s) {
        Character[] charArr = new Character[s.length()];
        
        for(int i=0 ; i<s.length() ; i++) {
            charArr[i] = s.charAt(i);
        }
        return charArr;
    }
    
    private String convertToString(Character[] charArray) {
        char[] arr = new char[charArray.length];
        
        for(int i=0 ; i<charArray.length ; i++) {
            arr[i] = charArray[i];
        }
        return new String(arr);
    }
    */
    
    
    // Solution 2: Counting approach. Store count in a frequency array. And restructure new string from that.
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(int i=0 ; i<s.length() ; i++) {
            freq[s.charAt(i)-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<order.length() ; i++) {
            char current = order.charAt(i);
            while(freq[current - 'a'] > 0) {
                sb.append(current);
                freq[current - 'a']--;
            }
        }
        
        for(int i=0 ; i<freq.length ; i++) {
            char current = (char)(i+'a');
            while(freq[i] > 0) {
                sb.append(current);
                freq[i]--;
            }
        }
        return sb.toString();
    }
    
}