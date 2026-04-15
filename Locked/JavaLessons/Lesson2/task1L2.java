import java.util.Scanner;

class task1L2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Напишите число для вычисление его факториала: ");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Факториал числа " + a + ": " + fact(a));
        scanner.nextLine();
        scanner.close();
    }

    private static int fact(int a){
        int res = 1;
        for(int i = 1; i <= a; i++){
            res = res * i;
        }
        return res;
    }
}
