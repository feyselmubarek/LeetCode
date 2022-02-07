class Solution {
    public char findTheDifference(String s, String t) {
        int letter = 0;
        for(int i = 0; i < s.length(); i++)
            letter ^= s.charAt(i);
        
        for(int i = 0; i < t.length(); i++)
            letter ^= t.charAt(i);
        
        return (char) letter;
    }
}