import java.util.Scanner;

class task4l4 {
    private final static Scanner globalScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arrNums = { 1, 2, 3, 4, 5 };
        int temp;
        for (int i = 0; i < arrNums.length; i++) {
            System.out.print(arrNums[i] + "   ");
        }
        System.out.print("\n");
        for (int i = arrNums.length - 1; i > 0; i--) {
            if (i == arrNums.length - 1) {
                temp = arrNums[0];
                arrNums[0] = arrNums[arrNums.length - 1];
                arrNums[1] = temp;
            }
            else {
                temp = arrNums[i];
                arrNums[i] = arrNums[i + 1];
                arrNums[i + 1] = temp;
            }
        }
        for (int i = 0; i < arrNums.length; i++) {
            System.out.print(arrNums[i] + "   ");
        }

        System.out.print("\n");
        globalScanner.nextLine();
        globalScanner.close();
    }
}
