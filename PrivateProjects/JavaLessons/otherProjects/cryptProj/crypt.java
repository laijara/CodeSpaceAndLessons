import java.util.Scanner;

class crypt {
    public static void main(String[] args) {
        SharedFunctions.startProgram();
    }
}

class SharedFunctions{
    private static Scanner globalScanner = new Scanner(System.in);

    public static void startProgram(){
        Encrypt.startEncrypt();
        SharedFunctions.endProgram();
    }

    private static void endProgram(){
        SharedFunctions.consolePause();
        SharedFunctions.globalScanner.close();
    }

    public static String userInput(){
        System.out.print("Input - ");
        return SharedFunctions.globalScanner.nextLine();
    }

    public static void consolePause(){
        System.out.print("\n\nPress Enter to be continue...\n");
        SharedFunctions.globalScanner.nextLine();
    }

    public static void warningMessage(String message){
        SharedFunctions.clearConsole();
        System.out.print("-------------------\n");
        System.out.print(message + "\n");
        System.out.print("-------------------");
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            SharedFunctions.warningMessage("Error, try again");
        }
    }
}

class Encrypt{
    private static String pass = "1488";

    public static void startEncrypt(){
        String authorization;
        SharedFunctions.clearConsole();
        while (true) {
            System.out.print("Cryptor authorization\n");
            System.out.print("======================\n");
            System.out.print("0. Exit\n");
            System.out.print("Enter password\n");
            authorization = SharedFunctions.userInput();
            if(authorization.equals("0")){
                SharedFunctions.clearConsole();
                break;
            }
            else if (authorization.equals(pass)) {
                String chooseMenu;
                SharedFunctions.warningMessage("Access is allowed");
                while (true) {
                    System.out.print("\n\nCryptor menu\n");
                    System.out.print("=============\n");
                    System.out.print("0. Exit\n");
                    System.out.print("1. Encrypt message\n");
                    System.out.print("2. Crypt message\n");
                    chooseMenu = SharedFunctions.userInput();
                    if(chooseMenu.equals("0")){
                        SharedFunctions.clearConsole();
                        break;
                    }
                    else if (chooseMenu.equals("1")) {
                        String encryptMessage;
                        SharedFunctions.clearConsole();
                        System.out.print("==================\n");
                        System.out.print("Enter for encrypt\n");
                        encryptMessage = SharedFunctions.userInput();
                        SharedFunctions.warningMessage("Message: " + Encrypt.enryptMessage(encryptMessage));
                    }
                    else if (chooseMenu.equals("2")) {
                        String decryptMessage;
                        SharedFunctions.clearConsole();
                        System.out.print("==================\n");
                        System.out.print("Enter for decrypt\n");
                        decryptMessage = SharedFunctions.userInput();
                        SharedFunctions.warningMessage("Message: " + Encrypt.decryptMessage(decryptMessage));
                    }
                    else {
                        SharedFunctions.warningMessage("Error, try again");
                    }
                }
            }
            else {
                SharedFunctions.warningMessage("Error, try again");
            }
        }
    }

    private static String enryptMessage(String input){
        return input + "EncryptMessage";
    }

    private static String decryptMessage(String input){
        return input + "DecryptMessage";
    }
}