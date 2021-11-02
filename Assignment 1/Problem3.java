import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //Weights for each assessment
        final double TESTS = 0.25;
        final double PODS = 0.1;
        final double ASSIGNMENTS = 0.3;
        final double PRACTICUMS = 0.35;
        //Quantity of each assessment
        final int NUM_TESTS = 3;
        final int NUM_ASSIGNMENTS = 5;
        final int NUM_PRACTICUMS = 4;

        int numberOfStudents = kb.nextInt();
        double[][] studentMarks = new double[numberOfStudents][4];
        for (int i = 0; i < numberOfStudents; i++) {

            String student = kb.next();
            studentMarks[i][0] = readAssessmentScores(NUM_TESTS,false,kb);
            studentMarks[i][1] = readAssessmentScores(NUM_ASSIGNMENTS,true,kb);
            studentMarks[i][2] = readAssessmentScores(NUM_PRACTICUMS,false,kb);
            studentMarks[i][3] = readAssessmentScores(1,false,kb);

            double finalScore = studentMarks[i][0] * TESTS + studentMarks[i][1] * ASSIGNMENTS +
                    studentMarks[i][2] * PRACTICUMS + studentMarks[i][3] * PODS;

            System.out.println(student + " " + scoreToLetterGrade(finalScore));

        }

        printOutClassStatistics(studentMarks);

    }

    /**
     * Method used to convert a score into a letter grade according to Dalhousie's rules
     * https://www.dal.ca/campus_life/academic-support/grades-and-student-records/grade-scale-and-definitions.html
     * @param score the score we want to convert
     * @return the letter grade from F to A+
     */
    private static String scoreToLetterGrade(double score){
        if(score >= 90){
            return "A+";
        }
        if(score >= 85){
            return "A";
        }
        if(score >= 80){
            return "A-";
        }
        if(score >= 77){
            return "B+";
        }
        if(score >= 73){
            return "B";
        }
        if(score >= 70){
            return "B-";
        }
        if(score >= 65){
            return "C+";
        }
        if(score >= 60){
            return "C";
        }
        if(score >= 55){
            return "C-";
        }
        if(score >= 50){
            return "D";
        }
        return "F";
    }

    /**
     * Reads assessments scores from the user and returns the final score for each grade item.
     * The method can be used to drop the lowest score of an assessment if needed
     * @param numberOfEntries the number of assessments for a given grade item
     * @param dropLowest set to true to drop the score lowest assessment
     * @param kb the scanner variable used to read information from the user.
     * @return the average score of the grade item
     */
    private static double readAssessmentScores(int numberOfEntries, boolean dropLowest, Scanner kb){
        double result = kb.nextInt();
        double min = result;

        for (int i = 0; i < numberOfEntries-1; i++) {
            int entry  = kb.nextInt();
            if(min > entry){
                min = entry;
            }
            result += entry;
        }
        if(dropLowest){
            result -= min;
            result = result / (numberOfEntries-1);
            return result;
        }
        result = result / numberOfEntries;
        return result;
    }

    /**
     * Prints out the class average scores.
     * @param marks the Student's marks organized in this order: Tests, Assignments, Practicums and PoDS
     */
    private static void printOutClassStatistics(double[][] marks){
        double assignmentsAverage = 0;
        double testsAverage = 0;
        double practicumsAverage = 0;
        double podsAverage = 0;

        double[] tests = new double[marks.length];
        double[] assignments = new double[marks.length];
        double[] practicums = new double[marks.length];
        double[] pods = new double[marks.length];

        for (int i = 0; i < marks.length; i++) {

            tests[i] = marks[i][0];
            assignments[i] = marks[i][1];
            practicums[i] = marks[i][2];
            pods[i] = marks[i][3];

            testsAverage += marks[i][0];
            assignmentsAverage += marks[i][1];
            practicumsAverage += marks[i][2];
            podsAverage += marks[i][3];
        }

        System.out.println("Class Averages: ");
        System.out.printf("Tests: %.2f - Assignments: %.2f - Practicums: %.2f - PoDs: %.2f\n",
                testsAverage/marks.length, assignmentsAverage/marks.length, practicumsAverage/marks.length,
                podsAverage/marks.length);


        System.out.println("Class Medians: ");
        System.out.printf("Tests: %.2f - Assignments: %.2f - Practicums: %.2f - PoDs: %.2f\n",
                getMedian(tests), getMedian(assignments), getMedian(practicums), getMedian(pods));


    }

    /**
     * Calculates the median of a numbers in a an array. The method does not assume that the
     * array is already sorted.
     * @param numbers The 1D array containing the numbers
     * @return the median
     */
    public static double getMedian(double[] numbers){
        double[] sortedMarks = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedMarks);

        int middle = sortedMarks.length/2;

        if(sortedMarks.length % 2 != 0){
            return sortedMarks[middle];
        }

        return (sortedMarks[middle - 1] + sortedMarks[middle])/2;

    }


}
