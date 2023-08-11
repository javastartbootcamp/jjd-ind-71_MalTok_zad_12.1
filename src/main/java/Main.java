import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String fileName = "operations.txt";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useLocale(Locale.US);
            while (scanner.hasNextLine()) {
                String line = OperationUtils.readLine(scanner);
                ArithmeticOperation arithmeticOperation = OperationUtils.getArithmeticOperation(line);
                OperationUtils.printLineResult(arithmeticOperation);
                OperationUtils.writeLineToFile(arithmeticOperation, "result.txt");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.err.println("Błąd zapisu pliku");
        } catch (InvalidOperatorException e) {
            System.err.println("Nieprawidłoy operator");
        }
    }
}