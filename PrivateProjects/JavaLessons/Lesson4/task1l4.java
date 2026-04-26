import java.util.Scanner;

class task1l4 {
    private static final Scanner globalScanner = new Scanner(System.in);
    public static void main(String[] args) {
        final int DAYS = 7;
        double[] arrTemp = new double[DAYS];
        double maxTemp, minTemp;
        int count = DAYS;

        System.out.print("Input temperature on the week: \n");
        for (int i = 0; i < DAYS; i++) {
            System.out.print(count + " left...\n");
            arrTemp[i] = globalScanner.nextDouble();
            globalScanner.nextLine();
            count--;
        }

        maxTemp = arrTemp[0];
        minTemp = arrTemp[0];
        for (int i = 0; i < DAYS; i++) {
            if (maxTemp < arrTemp[i]) {
                maxTemp = arrTemp[i];
            }
            if (minTemp > arrTemp[i]) {
                minTemp = arrTemp[i];
            }
        }

        System.out.print("Temperature on the week: \n");
        for (int i = 0; i < DAYS; i++) {
            System.out.print("Day " + (i+1) + ":  " + arrTemp[i] + "\n");
        }
        System.out.print("\n\nMax temperature on the week: " + maxTemp + "\n");
        System.out.print("Min temperature on the week: " + minTemp + "\n");

        globalScanner.nextLine();
        globalScanner.close();
    }
}
