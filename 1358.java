class Solution {
    public boolean isSafe(HashMap<Character, Integer> hm) {
        return hm.containsKey('a') && hm.containsKey('b') &&
        hm.containsKey('c');
    }

    public int numberOfSubstrings(String s) {
        int start = 0, end = 0;
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;
        while(end < n) {
            char curr = s.charAt(end);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
            while(isSafe(hm)){
                // int val = hm.get(s.charAt(start));
                // if(hm.containsKey(s.charAt(start))){
                //     hm.put(s.charAt(start), val - 1);
                // } 
                // if(hm.get(s.charAt(start)) == 0){
                //     hm.remove(s.charAt(start));
                // }
                count += (n - end);
                char leftChar = s.charAt(start);
                hm.put(leftChar, hm.getOrDefault(leftChar, 0) - 1);
                if(hm.get(leftChar) == 0) {
                    hm.remove(leftChar);
                }
                start++;
            }        
            // if(isSafe(hm)) count++;
            end++;
        }
        return count;
    }
}