import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class OperationUtils {
    public static String readLine(Scanner scanner) {
        return scanner.nextLine();
    }

    public static ArithmeticOperation getArithmeticOperation(String line) {
        String[] array = line.split(" ");
        double firstNumber = Double.parseDouble(array[0]);
        String operator = array [1];
        double secondNumber = Double.parseDouble(array[2]);
        return new ArithmeticOperation(firstNumber, secondNumber, operator);
    }

    public static void writeLineToFile(ArithmeticOperation arithmeticOoperation, String fileName) throws IOException {
        try (
                var writer = new BufferedWriter(new FileWriter(fileName, true))
        ) {
            writer.write(arithmeticOoperation.toString());
            writer.newLine();
        }
    }

    public static void printLineResult(ArithmeticOperation arithmeticOperation) {
        System.out.println(arithmeticOperation);
    }
}
