import java.util.Scanner;

class task2l4 {
    private final static Scanner globalScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arrNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int temp, j = 9;
        for (int i = 0; i < 5; i++) {
            temp = arrNum[i];
            arrNum[i] = arrNum[j];
            arrNum[j] = temp;
            j--;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(arrNum[i] + "   ");
        }

        System.out.print("\n");
        globalScanner.nextLine();
        globalScanner.close();
    }
}
