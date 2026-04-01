import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> frq = new HashMap<>();

        // Count frequency of characters in magazine
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            frq.put(ch, frq.getOrDefault(ch, 0) + 1);
        }

        // Check ransomNote characters
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            if (frq.getOrDefault(ch, 0) == 0) {
                return false;
            }

            frq.put(ch, frq.get(ch) - 1);
        }

        return true;
    }
}