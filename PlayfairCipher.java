import java.util.*;

public class PlayfairCipher {

    private char[][] matrix = new char[5][5];
    private String key;

    public PlayfairCipher(String key) {
        this.key = prepareKey(key);
        generateMatrix();
    }

    // Përgatit key (heq duplikatet, J -> I)
    private String prepareKey(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder result = new StringBuilder();

        for (char c : key.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }






}