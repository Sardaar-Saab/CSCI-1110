import java.util.Scanner;

public class Problem1 {
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

        String bannerNumber = kb.next();
        double testsScore = readAssessmentScores(NUM_TESTS,false,kb);
        double assignmentScore = readAssessmentScores(NUM_ASSIGNMENTS,true,kb);
        double practicumScore = readAssessmentScores(NUM_PRACTICUMS,false,kb);
        double podScore = readAssessmentScores(1,false,kb);

        double finalScore = testsScore * TESTS + assignmentScore * ASSIGNMENTS +
                practicumScore * PRACTICUMS + podScore * PODS;

        System.out.printf("Student: %s - %s", bannerNumber, scoreToLetterGrade(finalScore));


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

}
