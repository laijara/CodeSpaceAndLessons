import java.util.Scanner;

class task2L1 {
    public static void main(String[] args) {
        System.out.print("Введите число - ");
        Scanner scanner = new Scanner(System.in);
        int inpp = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Результат работы функции - " + MathForm(inpp));
        scanner.nextLine();
        scanner.close();
    }

    private static int MathForm(int i) {
        return 3 * i + 4;
    }
}
