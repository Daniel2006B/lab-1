package Task1;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(convert(12));

    }

    public static String convert(int number) {
        String result = " ";
        do {
            if (number % 2 == 0) {
                result = result + '0';
            } else {
                result = result + '1';
            }
            number /= 2;
        } while (number != 0);

        return result;
    }
}





