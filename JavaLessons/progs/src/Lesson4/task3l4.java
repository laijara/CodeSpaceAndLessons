import java.util.Scanner;

class task3l4 {
    private final static Scanner globalScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arrScore = { 5, 2, 1, 5, 3, 4, 5, 5, 3, 3, 3, 3, 4, 4, 5, 3, 2, 2, 2, 1 };
        int minScore, maxScore, countMaxScore = 0, countMinScore = 0, sumScore = 0, countHighScore = 0, countLowScore = 0;
        double centerScore;

        minScore = arrScore[0];
        maxScore = arrScore[0];
        for (int i = 0; i < arrScore.length; i++) {
            sumScore += arrScore[i];
            if (maxScore < arrScore[i]) {
                maxScore = arrScore[i];
                countMaxScore = 1;
            } else if (maxScore == arrScore[i]) {
                countMaxScore++;
            }
            if (minScore > arrScore[i]) {
                minScore = arrScore[i];
                countMinScore = 1;
            } else if (minScore == arrScore[i]) {
                countMinScore++;
            }
            
            if (arrScore[i] == 5) {
                countHighScore++;
            }
            if (arrScore[i] < 3) {
                countLowScore++;
            }
        }
        centerScore = (double)sumScore / arrScore.length;

        System.out.print("\n\nMax score is " + maxScore + " his count: " + countMaxScore + "\n");
        System.out.print("Min score is " + minScore + " his count: " + countMinScore + "\n");
        System.out.print("CenterScore in group: " + centerScore + "\n");
        System.out.print("High score count: " + countHighScore + "\n");
        System.out.print("Low score count: " + countLowScore + "\n");
        globalScanner.nextLine();
        globalScanner.close();
    }
}
