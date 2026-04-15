import java.util.Scanner;
class UnMain{
        public static void main(String[] args){
                StartProgram();
        }
        
        private static int StandartIq = 150;
        private static String pass = "bebra228";
        

        private static void StartProgram(){
                SharedFunctions.ClearConsole();
                MainMenu();
                SharedFunctions.PauseAndContinue();
        }

        private static void MainMenu(){
                int a;
                while (true) {
                        System.out.print(TextMessages.TextMass[0]);
                        a = SharedFunctions.SecureInput(TextMessages.TextMass[0]);
                        if (a == 0) {
                                return;
                        }
                        else if (a == 1){
                                SharedFunctions.ClearConsole();
                                Questions();
                        }
                        else if (a == 2){
                                SharedFunctions.ClearConsole();
                                AdministratorConsole();
                        }
                        else {
                                SharedFunctions.ErrorMessage();
                        }
                }
        }

        private static void AdministratorConsole(){
                while (true) {
                        System.out.print(TextMessages.TextMass[1]);
                        String tryPass = SharedFunctions.globalScanner.nextLine();
                        if (tryPass.equals(pass)) {
                                SharedFunctions.ClearConsole();
                                System.out.print(TextMessages.TextMass[2]);
                                StandartIq = SharedFunctions.SecureInput(TextMessages.TextMass[2]);
                                SharedFunctions.PauseAndContinue();
                                break;
                        }
                        else {
                                SharedFunctions.ErrorMessage();
                        }
                }
                
        }

        private static void Questions(){
                System.out.print(TextMessages.TextMass[3]);
                int inpp = SharedFunctions.SecureInput(TextMessages.TextMass[3]);
                if (!isDownSyndrome(inpp)) {
                        System.out.print(TextMessages.TextMass[4]);
                        SharedFunctions.PauseAndContinue();
                }
                else {
                        System.out.print(TextMessages.TextMass[5]);
                        SharedFunctions.PauseAndContinue();
                }
        }

        private static boolean isDownSyndrome(int iq){
                if (iq < StandartIq) {
                        return true;
                }
                else {
                        return false;
                }
        }
}


class TextMessages{
        public static String[] TextMass = 
        {
        """
        Main menu
        ==============================
        0. Exit
        1. Pass test
        2. Configuration administrator
        """,
        
        "Enter password.\nInput - ",
        
        """
        Authentication complete
        Enter new StandartIq.                
        """,

        "Enter your IQ.\n",

        "\nYou are okay!\n",

        "\nYou have a DOWN SYNDROME!\n",

        "ERROR!\n\n",

        "\n\nPress Enter to be continue....",

        "Input - "
        };
}



class SharedFunctions{
        public static Scanner globalScanner = new Scanner(System.in);

        public static void ClearConsole() {
        try {
                // Проверяем, какая операционная система
                String os = System.getProperty("os.name").toLowerCase();

                if (os.contains("win")) {
                // Для Windows: выполняем команду 'cls' напрямую в консоли
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                // Для Linux/macOS: используем ANSI-последовательность
                System.out.print("\033[H\033[2J");
                System.out.flush();
                }
        } catch (Exception e) {
                // Если системная очистка не сработала, просто печатаем много пустых строк
                for (int i = 0; i < 50; i++) System.out.println();
        }
        }

        public static void ErrorMessage(){
                SharedFunctions.ClearConsole();
                System.out.print(TextMessages.TextMass[6]);
        }

        public static void PauseAndContinue(){
                System.out.print(TextMessages.TextMass[7]);
                globalScanner.nextLine();
                SharedFunctions.ClearConsole();
        }

        public static int SecureInput(String TextMenu){
               while (true) {
                        System.out.print(TextMessages.TextMass[8]);
                        try {
                                return Integer.parseInt(SharedFunctions.globalScanner.nextLine());
                        }
                catch (Exception e) {
                                SharedFunctions.ErrorMessage();
                                System.out.print(TextMenu);
                        }
                }
        }
}