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

    private void generateMatrix() {
        boolean[] used = new boolean[26];
        used['J' - 'A'] = true;

        int row = 0, col = 0;

        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[row][col++] = c;
                used[c - 'A'] = true;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!used[c - 'A']) {
                matrix[row][col++] = c;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
    }


private int[] findPosition(char c) {
    if (c == 'J') c = 'I';

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (matrix[i][j] == c) {
                return new int[]{i, j};
            }
        }
    }
    return null;
}

private List<String> prepareText(String text) {
    text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
    List<String> pairs = new ArrayList<>();

    for (int i = 0; i < text.length(); i += 2) {
        char a = text.charAt(i);
        char b;

        if (i + 1 < text.length()) {
            b = text.charAt(i + 1);
            if (a == b) {
                b = 'X';
                i--;
            }
        } else {
            b = 'X';
        }

        pairs.add("" + a + b);
    }

    return pairs;
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