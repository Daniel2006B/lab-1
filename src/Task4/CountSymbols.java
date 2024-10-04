package Task4;

import java.util.Scanner;

public class CountSymbols {

    public static void main(String[] args) {
        int index = 0;
        int indexForArray = 0;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        PairValues[] listPairOfValues = new PairValues[input.length()];
        while (!input.isEmpty()){
            int count = 0;
            char workingChar = input.charAt(0);
            index = input.indexOf(workingChar);

            while (index >= 0) {
                index = input.indexOf(workingChar, index);
                input = input.replaceFirst(Character.toString(workingChar), "");

                count++;
            }

            PairValues pair = new PairValues(workingChar, count - 1);
            listPairOfValues[indexForArray] = pair;
            indexForArray++;


        }
        scanner.close();
        int i = 0;
        while (listPairOfValues[i] != null) {
            System.out.println(listPairOfValues[i].toString());
            i++;
        }

    }
}
