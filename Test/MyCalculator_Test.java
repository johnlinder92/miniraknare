public class MyCalculator_Test {
    static MyCalculator calc = new MyCalculator();
    public static final String ANSI_RESET = "\u001B[00m"; //Used for output
    public static final String ANSI_RED   = "\u001B[31m"; //Use in test?
    public static final String ANSI_GREEN = "\u001B[32m"; //Use in test?

    //This test should be run with the expectation that the MyCalculator
    //was just instanciated - FirstNumber should be zero!
    private static boolean test_StartValueOfFirstNumber(){
        return calc.getFirstNumber() == 0;
    }
    //This test will use method 'add' in class MyCalculator
    //Calculated answer is obtained by calling the getAnswer-method
    private static boolean test_AddMethod(){
        double temp1 = 1.2, temp2 = 3.1, correctAnswer = temp1+temp2;
        calc.useAdd(temp1, temp2);
        return correctAnswer == calc.getAnswer();
    }

    public static void main(String[] args) {
        if(test_StartValueOfFirstNumber()){
            System.out.println("SV firstNumber: "+ANSI_GREEN+"PASS"+ANSI_RESET);
        } else {
            System.out.println("SV firstNumber: "+ANSI_RED+"FAIL"+ANSI_RESET);
        }
        if(test_AddMethod()){
            System.out.println("Add method: "+ANSI_GREEN+"PASS"+ANSI_RESET);
        } else {
            System.out.println("Add method: "+ANSI_RED+"FAIL"+ANSI_RESET);
        }

        //Available test-methods in class MyCalculator
        //calc.useAdd();
        //calc.useSub();
        //calc.useMult();
        //calc.useDiv();
        //calc.getFirstNumber();
        //calc.getSecondNumber();
        //calc.getAnswer();
        //calc.getOperator();
    }
}
