import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Shell {
    private Environment environment;

    public Shell() {
        this.environment = new Environment();
    }

    // Execute the input command
    public void execute(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].trim();

        switch (command) {
            case "exit":
                exitCommand();
                break;
            case "cd":
                cdCommand(parts);
                break;
            case "pwd":
                pwdCommand();
                break;
            case "echo":
                echoCommand(parts);
                break;
            case "type":
                typeCommand(parts);
                break;
            case "ls":
                lsCommand();
                break;
            default:
                externalCommand(command, parts);
        }
    }

    private void exitCommand() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private void cdCommand(String[] parts) {
        if (parts.length < 2) {
            System.out.println("cd: missing argument");
            return;
        }

        String dir = parts[1];
        File file = new File(dir);

        if (file.exists() && file.isDirectory()) {
            System.setProperty("user.dir", file.getAbsolutePath());
        } else {
            System.out.println("cd: " + dir + ": No such directory");
        }
    }

    private void pwdCommand() {
        System.out.println(System.getProperty("user.dir"));
    }

    private void echoCommand(String[] parts) {
        if (parts.length > 1) {
            System.out.println(parts[1].trim());
        } else {
            System.out.println();
        }
    }

    private void typeCommand(String[] parts) {
        if (parts.length < 2) {
            System.out.println("No command specified for 'type'");
            return;
        }

        String typeSubstring = parts[1].trim();
        List<String> commands = Arrays.asList("echo", "exit", "cd", "pwd", "type", "ls");

        if (commands.contains(typeSubstring)) {
            System.out.println(typeSubstring + " is a shell builtin");
        } else {
            System.out.println(typeSubstring + ": not found");
        }
    }

    private void lsCommand() {
        File currentDirectory = new File(System.getProperty("user.dir"));

        // Get all files and directories in the current directory
        File[] filesAndDirs = currentDirectory.listFiles();

        if (filesAndDirs != null && filesAndDirs.length > 0) {
            for (File file : filesAndDirs) {
                // Print the file or directory name
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files or directories found in the current directory.");
        }
    }

    private void externalCommand(String command, String[] parts) {
        String[] cmdParts = new String[parts.length];
        cmdParts[0] = command;
        if (parts.length > 1) {
            System.arraycopy(parts, 1, cmdParts, 1, parts.length - 1);
        }

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(cmdParts);
            processBuilder.environment().putAll(environment.getEnv());  // Pass environment variables
            processBuilder.directory(new File(System.getProperty("user.dir")));
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(command + ": command not found");
        }
    }
}
