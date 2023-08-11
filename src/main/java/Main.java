import java.io.*;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        String fileName = "operations.txt";
        try (
                Scanner scanner = new Scanner(new File(fileName));
                var writer = new BufferedWriter(new FileWriter("result.txt", true))
        ) {
            scanner.useLocale(Locale.US);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArithmeticOperation arithmeticOperation = ArithmeticOperation.fromLine(line);
                String outputFormat = arithmeticOperation.toOutputFormat();
                System.out.println(outputFormat);
                writer.write(outputFormat);
                writer.newLine();

            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.err.println("Błąd zapisu pliku");
        } catch (InvalidOperatorException e) {
            System.err.println("Nieprawidłowy operator");
        }
    }
}