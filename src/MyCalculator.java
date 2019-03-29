import java.util.Scanner;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;

public class MyCalculator {
    private static double  firstNumber     =    0;
    private static double  secondNumber    =    0;
    private static double  answer          =    0;
    private static String  operator        = "-1";
    private static boolean continueLoop    = true;
    private static Scanner scan            = new Scanner(System.in);
    private static DecimalFormat precision = new DecimalFormat("#0.00");

    //See link below for a discussing regarding ANSI Escape Codes (used for color prints)
    //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    //Note: ANSI Escape Codes will not work in Windows CMD.exe!!
    public static final String ANSI_CYAN  = "\u001B[36m"; //Used for output
    public static final String ANSI_RESET = "\u001B[00m"; //Used for output
    public static final String ANSI_RED   = "\u001B[31m"; //Use in test?
    public static final String ANSI_GREEN = "\u001B[32m"; //Use in test?

    private static void add(double d1, double d2){
        answer = d1 + d2;
    }
    private static void sub(double d1, double d2){
        answer = d1 - d2;
    }
    private static void mult(double d1, double d2){
        answer = d1 * d2;
    }
    private static void div(double d1, double d2){
        answer = d1 / d2;
    }

    private static void enterDouble(){
        System.out.print("Enter double: ");
        try {
            secondNumber = Double.parseDouble(scan.next());
        } catch (NumberFormatException e) {
            continueLoop = false;
        }
    }
    private static void enterOperator(){
        System.out.print("Enter operator (+, -, /, or *): ");
        operator = scan.next();
    }
    private static void printResult(){
        if(firstNumber != 0){
            System.out.println(ANSI_CYAN +
                    precision.format(firstNumber) + " " + operator + " " +
                    precision.format(secondNumber) + " = " +
                    precision.format(answer) + ANSI_RESET);
        } else {
            System.out.println(ANSI_CYAN + precision.format(secondNumber)+ ANSI_RESET);
        }
    }
    private static void printInstructions(){
        System.out.println(
                "\nStep 1: Enter a double."+
                        "\nStep 2: Enter an operator."+
                        "\nStep 3: Enter a double."+
                        "\nStep 4: Repeat steps 2 and 3."+
                        "\nTerminate software by entering anything else at step 2 or step 3.\n");
    }

    //Methods used during test
    public static double getFirstNumber(){
        return firstNumber;
    }
    public static double getSecondNumber(){
        return secondNumber;
    }
    public static double getAnswer(){
        return answer;
    }
    public static String getOperator(){
        return operator;
    }
    public void useAdd(double d1, double d2){
        add(d1, d2);
    }
    public void useSub(double d1, double d2){
        sub(d1, d2);
    }
    public void useMult(double d1, double d2){
        mult(d1, d2);
    }
    public void useDiv(double d1, double d2){
        div(d1, d2);
    }

    public static void calcMain(String[] args) {
        printInstructions();
        System.out.print("Enter double: ");
        try {
            firstNumber = Double.parseDouble(scan.next());
        } catch (NumberFormatException e) {
            continueLoop = false;
        }
        while (continueLoop) {
            enterOperator();
            if (( operator.equals("+") || operator.equals("-") ||
                    operator.equals("*") || operator.equals("/") )){
                enterDouble();
            } else {
                continueLoop = false;
            }
            if (continueLoop){
                if (operator.equals("+")){
                    add(firstNumber, secondNumber);
                    printResult();
                } else if (operator.equals("-")){
                    sub(firstNumber, secondNumber);
                    printResult();
                } else if (operator.equals("*")){
                    mult(firstNumber, secondNumber);
                    printResult();
                } else if (operator.equals("/")){
                    if (secondNumber != 0) {
                        div(firstNumber, secondNumber);
                        printResult();
                    } else {
                        System.out.println("Can not divide by zero!");
                    }
                }
                firstNumber = answer;
            } else {
                continueLoop = false;
            } //End of if-statement dependping on continueLoop
        } //End of while-loop dependping on continueLoop
        scan.close();
        System.out.println("\nSoftware terminated!");
    }

}
