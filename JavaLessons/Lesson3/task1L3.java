import java.util.Scanner;

class task1L3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число - ");
        int inpp = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Количество рожденных кроликов за период " + inpp + ": " + Fib(inpp) + "\n");
        System.out.print("Количество вызовов функции: " + a + "\n");
        scanner.nextLine();
        scanner.close();
    }
    private static int a = 0;

    private static int Fib(int n){
        a++;
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return Fib(n - 1) + Fib(n - 2);
        }
    }
}