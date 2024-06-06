class Solution {
            
    public String validIPAddress(String queryIP) {
        boolean isIPv4 = checkIPv4(queryIP);
        boolean isIPv6 = checkIPv6(queryIP);
        
        if(isIPv4)
            return "IPv4";
        else if(isIPv6)
            return "IPv6";
        else
            return "Neither";
    }
    
    private boolean checkIPv4(String queryIP) {
        String[] splitted = queryIP.split("\\.", -1);
        if(splitted.length != 4)
            return false;
        for(String str : splitted) {
            int val = -1;
            if(str.startsWith("0") && !str.equals("0"))
                return false;
            try {
                val = Integer.parseInt(str);
            } catch(Exception e) {
                return false;
            }
            if(val<0 || val>255)
                return false;
        }
        return true;
    }
    
    private boolean checkIPv6(String queryIP) {
        String[] splitted = queryIP.split(":", -1);
        System.out.println(splitted.length);
        if(splitted.length != 8)
            return false;
        
        for(String str : splitted) {
            System.out.println(str);
            if(str.isEmpty() || str.length() > 4)
                return false;
            for(int i=0 ; i<str.length() ; i++) {
                char ch = str.charAt(i);
                if((ch>='0' && ch<='9') || (ch>='a' && ch<='f') || (ch>='A' && ch<='F'))
                    continue;
                else
                    return false;
            }
            System.out.println(str);
        }
        return true;
    }
}