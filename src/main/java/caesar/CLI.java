package caesar;

public class CLI {
    public CommandLineArgs parseArguments(String[] args) {
        if (args.length < 2) {
            System.out.println("Недостатньо аргументів");
            return null;
        }

        String command = args[0];
        String filePath = args[1];

        int key = 0;

        if (command.equalsIgnoreCase("encrypt") || command.equalsIgnoreCase("decrypt")) {
            if (args.length < 3) {
                System.out.println("Ключ обов'язковий для команд encrypt та decrypt");
                return null;
            }
            try {
                key = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Ключ має бути цілим числом");
                return null;
            }
        } else if (command.equalsIgnoreCase("bruteforce")) {
            key = 0;
        } else {
            System.out.println("Невідома команда: " + command);
            return null;
        }

        return new CommandLineArgs(command.toUpperCase(), filePath, key);
    }

    public static class CommandLineArgs {
        public String command;
        public String filePath;
        public int key;

        public CommandLineArgs(String command, String filePath, int key) {
            this.command = command;
            this.filePath = filePath;
            this.key = key;
        }
    }
}
