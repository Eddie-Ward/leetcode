package daily;

/**
 * Brute Force Solution
 * 
 * A repeated substring must have a length that is a valid multiple of the
 * entire string's length.
 * Start at length / 2, and consider all valid multiples from there.
 */

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int length = s.length() / 2; length > 0; --length) {
            if (s.length() % length == 0) {
                String sub = s.substring(0, length);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length() / length; ++i) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
