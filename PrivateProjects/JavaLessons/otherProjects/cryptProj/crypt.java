import java.util.Scanner;

class crypt {
    public static void main(String[] args) {
        SharedFunctions.StartProgram();
    }
}

class SharedFunctions{
    private static Scanner globalScanner = new Scanner(System.in);

    public static void StartProgram(){
        Encrypt.StartEncrypt();
        SharedFunctions.EndProgram();
    }

    private static void EndProgram(){
        SharedFunctions.ConsolePause();
        SharedFunctions.globalScanner.close();
    }

    public static String UserInput(){
        System.out.print("Input - ");
        return SharedFunctions.globalScanner.nextLine();
    }

    public static void ConsolePause(){
        System.out.print("\n\nPress Enter to be continue...\n");
        SharedFunctions.globalScanner.nextLine();
    }

    public static void WarningMessage(String message){
        System.out.print("\n\n-------------------\n");
        System.out.print(message + "\n");
        System.out.print("-------------------");
    }
}

class Encrypt{
    private static String pass = "1488";

    public static void StartEncrypt(){
        String authorization;
        while (true) {
            System.out.print("\n\nCryptor authorization\n");
            System.out.print("======================\n");
            System.out.print("0. Exit\n");
            System.out.print("Enter password\n");
            authorization = SharedFunctions.UserInput();
            if(authorization.equals("0")){
                break;
            }
            else if (authorization.equals(pass)) {
                String chooseMenu;
                SharedFunctions.WarningMessage("Access is allowed");
                while (true) {
                    System.out.print("\n\nCryptor menu\n");
                    System.out.print("=============\n");
                    System.out.print("0. Exit\n");
                    System.out.print("1. Encrypt message\n");
                    System.out.print("2. Crypt message\n");
                    chooseMenu = SharedFunctions.UserInput();
                    if(chooseMenu.equals("0")){
                        break;
                    }
                    else if (chooseMenu.equals("1")) {
                        String encryptMessage;
                        System.out.print("\nEnter for encrypt\n");
                        encryptMessage = SharedFunctions.UserInput();
                        SharedFunctions.WarningMessage("Message: " + Encrypt.EnryptMessage(encryptMessage));
                    }
                    else if (chooseMenu.equals("2")) {
                        String decryptMessage;
                        System.out.print("\nEnter for decrypt\n");
                        decryptMessage = SharedFunctions.UserInput();
                        SharedFunctions.WarningMessage("Message: " + Encrypt.DecryptMessage(decryptMessage));
                    }
                    else {
                        SharedFunctions.WarningMessage("Error, try again");
                    }
                }
            }
            else {
                SharedFunctions.WarningMessage("Error, try again");
            }
        }
    }

    private static String EnryptMessage(String input){
        return input + "EncryptMessage";
    }

    private static String DecryptMessage(String input){
        return input + "DecryptMessage";
    }
}