class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty())
            return 0;
        
        int idx = 0;
        int sign = 1;
        int result = 0;
        char firstCh = s.charAt(idx);
        if(firstCh == '-') {
            sign = -1; 
        } else if(firstCh == '+') {
            sign = 1; 
        } else if(Character.isDigit(firstCh)) {
            result = firstCh-'0';
        } else {
            return 0;
        }
        
        for(idx=1 ; idx<s.length() ; idx++) {
            char ch = s.charAt(idx);
            int digit = ch - '0';
            if(!Character.isDigit(ch))
                return sign*result;
            if((result>Integer.MAX_VALUE/10) || (result==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10))
                return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            result = result*10 + digit;
        }
        return sign*result;
    }
    
}