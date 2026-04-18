import java.util.*; 

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
commit 2 private List<

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