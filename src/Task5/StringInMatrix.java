package Task5;

public class StringInMatrix {
    public static void main(String[] args) {
        final String word = "apple";
        String[][] matrix = {
                {"apple", "pearson"},
                {"pear", "applepie"},
                {"wheat", "computerapple"}
        };

        int count = countSubstringInMatrix(matrix, word);
        String wordForm = (count == 1) ? "слово" : "слів";
        System.out.println("У цьому списку " + word + " є " + count + " " + wordForm + ".");
    }

    public static int countSubstringInMatrix(String[][] matrix, String substring) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].contains(substring)) {
                    ++counter;
                }
            }
        }
        return counter;
    }

}
