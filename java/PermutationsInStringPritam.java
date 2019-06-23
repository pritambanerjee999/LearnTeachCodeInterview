public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}


/*
class Solution {
    private Set<String> set = new HashSet<>();
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1 == null || s2 == null )  {
            return false;
        }
        
        if(s1.length() == 0 && s2.length() == 0) {
            return false;
        }
        else if(s1.length() == 0 && s2.length() > 0) {
            return true;
        }
        else if(s2.length() == 0) {
            return false;
        }
        
        permute("", s1);
       
        for(String s: set) {
            if(s2.indexOf(s) > -1) {
                return true;
            }
        }
        
        return false;
    }
    
    
    private String permute(String prefix, String perm) {
        
        if(perm.length() == 0) {
           set.add(prefix);
        }
        else {
            for(int i = 0; i < perm.length(); i++) {
                String prefixRet = prefix + perm.charAt(i);
                String permRet = perm.substring(0, i) + perm.substring(i+1);
                permute(prefixRet, permRet);
            }
        }
        
        return prefix;
    }
}
*/
