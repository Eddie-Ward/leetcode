package weekly;

import java.util.ArrayList;
import java.util.List;

class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length());
            encoded.append(":");
            encoded.append(str);
        }

        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int endIndex = 0;

        List<String> result = new ArrayList<>();

        while (endIndex != s.length()) {
            int colonIndex = s.indexOf(":", endIndex); // Find next occurence of ":"
            int wordLength = Integer.parseInt(s.substring(endIndex, colonIndex)); // Get word length from number before
                                                                                  // ":"
            endIndex = colonIndex + wordLength + 1; // Update end index based on word length, it will point to the next
                                                    // number, since substring is not inclusive of end index
            result.add(s.substring(colonIndex + 1, endIndex));
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
