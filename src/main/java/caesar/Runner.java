package caesar;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        CLI cli = new CLI();

        CLI.CommandLineArgs parsedArguments = cli.parseArguments(args);

        if (parsedArguments == null) {
            return;
        }

        CaesarCipher caesarCipher = new CaesarCipher();
        FileService fileService = new FileService();

        try {
            executeCommand(parsedArguments.command, parsedArguments.filePath, parsedArguments.key, caesarCipher, fileService);
        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }

    public static void executeCommand(String command, String filePath, int key, CaesarCipher cipher, FileService fileService) throws IOException {
        String content = fileService.readFile(filePath);
        String result;

        switch (command.toLowerCase()) {
            case "encrypt":
                result = cipher.encrypt(content, key);
                fileService.writeFile(filePath, result, "[ENCRYPTED]");
                System.out.println("Файл був зашифрований.");
                break;

            case "decrypt":
                result = cipher.decrypt(content, key);
                fileService.writeFile(filePath, result, "[DECRYPTED]");
                System.out.println("Файл був розшифрований.");
                break;

            case "bruteforce":
                result = cipher.bruteForce(content);
                fileService.writeFile(filePath, result, "[BRUTEFORCED]");
                System.out.println("BRUTEFORCE завершено.");
                break;

            default:
                System.out.println("Невідома команда: " + command);
                break;
        }
    }
}
