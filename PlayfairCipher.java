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






    
    public String encrypt(String text) {
        List<String> pairs = prepareText(text);
        StringBuilder result = new StringBuilder();

        for (String pair : pairs) {
            char a = pair.charAt(0);
            char b = pair.charAt(1);

            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) {
                result.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                result.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            }
            else if (posA[1] == posB[1]) {
                result.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                result.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            }
            else {
                result.append(matrix[posA[0]][posB[1]]);
                result.append(matrix[posB[0]][posA[1]]);
            }
        }

        return result.toString();
    }






}