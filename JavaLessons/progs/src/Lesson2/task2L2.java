import java.util.Scanner;

class task2L2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число - ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите степень - ");
        int piw = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Число " + num + " в степени " + piw + ": " + piwFunc(num, piw) + "\n");
        scanner.nextLine();
        scanner.close();
    }

    private static int piwFunc(int inpp, int piw){
        int res = 1;
        for(int i = 1; i <= piw; i++){
            res = res * inpp;
        }
        return res;
    }
}
