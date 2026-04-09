import java.util.Scanner;

class task1L1{
    public static void main(String[] args){
        System.out.print("Введите число - ");
        Scanner scanner = new Scanner(System.in);
        int inpp = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Результат работы функции - " + isPositiv(inpp));
        scanner.nextLine();
        scanner.close();

    }

    private static boolean isPositiv(double i) {
        if (i > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}