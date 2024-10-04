package Task6;

import java.util.Scanner;

public class CurrencyConverter {
    static private final Exception e = new Exception("Example: 100 UAH into USD");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            String[] input_array = input.split(" ");
            if (!input_array[2].equals("into"))
                throw e;

            double result = convertCurrency(input_array[1], input_array[3], Integer.parseInt(input_array[0]));
            System.out.println(result);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        scanner.close();
    }


    public static double convertCurrency(String currencyFrom, String currencyTo, double number) throws Exception {
        if (currencyTo.equals(currencyFrom)) {
            return number;
        }

        double result = -1;

        switch (currencyFrom) {
            case "UAH":
                if (currencyTo.equals("USD")) {
                    result = number / ConstCurrencies.USD_IN_UAH;
                } else if (currencyTo.equals("CAN")) {
                    result = number / ConstCurrencies.CAN_IN_UAH;
                } else if (currencyTo.equals("EUR")) {
                    result = number / ConstCurrencies.EUR_IN_UAH;
                }
                break;

            case "USD":
                if (currencyTo.equals("UAH")) {
                    result = number * ConstCurrencies.USD_IN_UAH;
                } else if (currencyTo.equals("CAN")) {
                    double USD_in_UAH = number * ConstCurrencies.USD_IN_UAH;
                    result = USD_in_UAH / ConstCurrencies.CAN_IN_UAH;
                } else if (currencyTo.equals("EUR")) {
                    double USD_in_UAH = number * ConstCurrencies.USD_IN_UAH;
                    result = USD_in_UAH / ConstCurrencies.EUR_IN_UAH;
                }
                break;

            case "CAN":
                if (currencyTo.equals("UAH")) {
                    result = number * ConstCurrencies.CAN_IN_UAH;
                } else if (currencyTo.equals("USD")) {
                    double CAN_in_UAH = number * ConstCurrencies.CAN_IN_UAH;
                    result = CAN_in_UAH / ConstCurrencies.USD_IN_UAH;
                } else if (currencyTo.equals("EUR")) {
                    double CAN_in_UAH = number * ConstCurrencies.CAN_IN_UAH;
                    result = CAN_in_UAH / ConstCurrencies.EUR_IN_UAH;
                }
                break;

            case "EUR":
                if (currencyTo.equals("UAH")) {
                    result = number * ConstCurrencies.EUR_IN_UAH;
                } else if (currencyTo.equals("USD")) {
                    double EUR_in_UAH = number * ConstCurrencies.EUR_IN_UAH;
                    result = EUR_in_UAH / ConstCurrencies.USD_IN_UAH;
                } else if (currencyTo.equals("CAN")) {
                    double EUR_in_UAH = number * ConstCurrencies.EUR_IN_UAH;
                    result = EUR_in_UAH / ConstCurrencies.CAN_IN_UAH;
                }
                break;

            default:
                result = -1;
                break;
        }

        if (result < 0) {
            throw e;
        } else {
            return result;
        }
    }


    public static class ConstCurrencies {
        public static final double EUR_IN_UAH = 45.61;
        public static final double USD_IN_UAH = 41.27;
        public static final double CAN_IN_UAH = 30.37;
    }


}
