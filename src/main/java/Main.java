import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shell shell = new Shell();

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine().trim();  // Read user input

            if (input.isEmpty()) {
                continue;
            }

            // Process the command
            shell.execute(input);
        }
    }
}
