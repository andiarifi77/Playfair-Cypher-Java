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

