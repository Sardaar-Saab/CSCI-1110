import java.util.*;
public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Importing Scanner class
        String banner = sc.next();
        int testMarks ;             //Initializing variable to take input of test Scores
        int assignmentMarks;        //Initializing variable to take input of Assignment Scores
        int PracticumMarks;         //Initializing variable to take input of Practicum Scores
        int PoDMarks;               //Initializing variable to take input of PoD Scores
        int min=0;                  //Initializing variable to take the lowest marks of Assignment Scores
        int testTotal = 0;          //Initializing variable to calculate sum of test Scores
        int assignmentTotal = 0;    //Initializing variable to calculate sum of Assignment Scores
        double PracticumTotal = 0;  //Initializing variable to calculate sum of Practicum Scores
        double testaverage;         //Initializing variable to calculate average value test Scores
        double assignmentaverage;   //Initializing variable to calculate average value Assignment Scores
        double Practicumaverage ;   //Initializing variable to calculate average value Pacticum Scores
        double PoDaverage;          //Initializing variable to calculate average value PoD Scores
        double grade;

             for (int i = 0; i < 3; i++) { //Taking input for test scores
                 testMarks= sc.nextInt();
                 testTotal += testMarks;  //Summing up Scores of Tests
             }
            testTotal = testTotal/3;      //Calculating Average of sum of test Scores


             for (int i = 0; i < 5; i++) {  //Taking input for Assignment scores
                 assignmentMarks=sc.nextInt();
                if (min>assignmentMarks){   // Finding the Lowest score of Assignments
                    assignmentMarks=min;

                }
                assignmentTotal += assignmentMarks; //Summing up Scores of Tests
              }
              assignmentTotal = (assignmentTotal-min)/4; //Dropping the Lowest marks of the assignment and then Calculating Average of sum of Assignmnent Scores

             for (int i = 0; i < 4; i++) { //Taking input for Practicum scores
            PracticumMarks = sc.nextInt();
            PracticumTotal += PracticumMarks;     //Summing up Scores of Tests
        }
        PracticumTotal = PracticumTotal/4;
        PoDMarks = sc.nextInt();


        testaverage       =     (testTotal *25)/100;
        assignmentaverage =     (assignmentTotal*30)/100;
        Practicumaverage  =     (PracticumTotal*35)/100;
        PoDaverage        =     (PoDMarks*10)/100;

        grade = (testaverage+assignmentaverage)+(Practicumaverage+PoDaverage);

        System.out.print("Student: "+banner+" - ");


        String scoreToLetterGrade = scoreToLetterGrade(grade);


    }
    private static String scoreToLetterGrade(double grade){

        String Temp="";

        if(grade>=90 && grade<=100){
            System.out.println("A+");
        }
        else if(grade>=85 && grade<=89){
            System.out.println("A+");
        }
        else if (grade>=80 && grade<=84){
            System.out.println("A-");
        }
        else if (grade>=77 && grade<=79){
            System.out.println("B+");
        }
        else if (grade>=73 && grade<=76){
            System.out.println("B");
        }
        else if (grade>=70  && grade<=72 ){
            System.out.println("B-");
        }
        else if (grade>=65 && grade<=69){
            System.out.println("C+");
        }
        else if (grade>=60  && grade<=64){
            System.out.println("C");
        }
        else if (grade>=55 && grade<=59){
            System.out.println("C-");
        }
        else if (grade>=50 && grade<=54){
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }




        return Temp;

    }
}
