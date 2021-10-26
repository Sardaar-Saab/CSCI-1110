import java.sql.SQLOutput;
import java.util.*;
public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfStudents = sc.nextInt();

        int testMarks[] = new int[3];
        int assignmentMarks[] = new int[5];
        int PracticumMarks[] = new int[4];
        int PoDMarks;
        int min = 0;
        int testTotal = 0;
        int assignmentTotal = 0;
        int PracticumTotal = 0;
        double testaverage;
        double assignmentaverage;
        double Practicumaverage;
        double PoDaverage;
        double grade = 0;


        for (int n = 0; n < noOfStudents; n++) {
            String banner = sc.next();

            for (int i = 0; i < testMarks.length; i++) {
                testMarks[i] = sc.nextInt();
                testTotal += testMarks[i];

            }


            testTotal = testTotal / 3;
            for (int i = 0; i < assignmentMarks.length; i++) {
                assignmentMarks[i] = sc.nextInt();


                if (min > assignmentMarks[i]) {
                    assignmentMarks[i] = min;
                }


                assignmentTotal += assignmentMarks[i];
            }

            assignmentTotal = (assignmentTotal - min) / 4;

            for (int i = 0; i < PracticumMarks.length; i++) {
                PracticumMarks[i] = sc.nextInt();
                PracticumTotal += PracticumMarks[i];
            }
            PracticumTotal = PracticumTotal / 4;
            PoDMarks = sc.nextInt();


            testaverage = (testTotal * 25) / 100;
            assignmentaverage = (assignmentTotal * 30) / 100;
            Practicumaverage = (PracticumTotal * 35) / 100;
            PoDaverage = (PoDMarks * 10) / 100;

            grade = (testaverage + assignmentaverage) + (Practicumaverage + PoDaverage);
            System.out.print(banner + " - ");


            String scoreToLetterGrade = scoreToLetterGrade(grade);

        }

    }
        private static String scoreToLetterGrade ( double grade){

            String Temp = "";

            if (grade >= 90 && grade <= 100) {
                System.out.println("A+");
            } else if (grade >= 85 && grade <= 89) {
                System.out.println("A");
            } else if (grade >= 80 && grade <= 84) {
                System.out.println("A-");
            } else if (grade >= 77 && grade <= 79) {
                System.out.println("B+");
            } else if (grade >= 73 && grade <= 76) {
                System.out.println("B");
            } else if (grade >= 70 && grade <= 72) {
                System.out.println("B-");
            } else if (grade >= 65 && grade <= 69) {
                System.out.println("C+");
            } else if (grade >= 60 && grade <= 64) {
                System.out.println("C");
            } else if (grade >= 55 && grade <= 59) {
                System.out.println("C-");
            } else if (grade >= 50 && grade <= 54) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }


            return Temp;

        }

    }
