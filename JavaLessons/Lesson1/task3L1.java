import java.util.Scanner;

class task3L1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Вводите стороны: \n");
        double a = scanner.nextInt();
        scanner.nextLine();
        double b = scanner.nextInt();
        scanner.nextLine();
        double c = scanner.nextInt();
        scanner.nextLine();
        double d = scanner.nextInt();
        scanner.nextLine();

        SearchAndCheck(a, b, c);
        SearchAndCheck(a, b, d);
        SearchAndCheck(a, c, d);
        SearchAndCheck(b, c, d);

        System.out.print("\n");
        scanner.nextLine();
        scanner.close();
    }

    private static boolean isTriangle(double a, double b, double c){
        if((a < b + c) && (b < a + c) && (c < a + b)){
            return true;
        }
        else {
            return false;
        }
    }

    private static double SearchSquare(double a, double b, double c){
        double p = (a + b + c) / 2.0;
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return S;
    }

    private static void SearchAndCheck(double a, double b, double c){
        if(isTriangle(a, b, c)) {
            System.out.print("\nПлощадь треугольника со сторонами: " + a + "; " + b + "; " + c + "; равняется: " + SearchSquare(a, b, c) + "\n");
        }
        else {
            System.out.print("\nПлощадь треугольника со сторонами: " + a + "; " + b + "; " + c + "; - не существует!");
        }
    }
}
