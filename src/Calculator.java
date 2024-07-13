public class Calculator {

    public static double count(double n1, double n2, char operator) {

        double result = 0;

        switch (operator) {
            case '+':
                result = n1 + n2;
                break;

            case '-':
                result = n1 - n2;
                break;

            case '*':
                result = n1 * n2;
                break;

            case '/':
                result = n1 / n2;
                break;
        }

        return result;
    }

}
