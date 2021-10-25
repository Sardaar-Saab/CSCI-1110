import java.util.Scanner;
public class P2 {

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);

        int    noofpeople;
        double amount=0;
        double total=0;
        double tip;
        double totalbeforetax=0;
        double totalaftertax=0;
        String province;
        noofpeople=sc.nextInt();

        do{
            total += amount  ;
            amount=sc.nextDouble();
        }while(amount!=0 && amount>0);

        tip=((sc.nextDouble()/100)*total);
        totalbeforetax= total+ tip;

        province =sc.next();

        if (province.equals("AB")  || province.equals("NT") || province.equals("NU") || province.equals("YT")){
            totalaftertax=totalbeforetax +totalbeforetax*0.05;
        }

        if (province.equals("SK")){
            totalaftertax=totalbeforetax +totalbeforetax*0.11;
        }

        if (province.equals("BC") || province.equals("MB")){
            totalaftertax=totalbeforetax +totalbeforetax*0.12;
        }

        if( province.equals("ON")){
            totalaftertax= totalbeforetax +(totalbeforetax*0.13);
        }

        if (province.equals("QC")){
            totalaftertax=totalbeforetax +totalbeforetax*0.1498;
        }

        if (province.equals("NS") || province.equals("NL") || province.equals("PEI") || province.equals("NB")){
            totalaftertax=totalbeforetax +totalbeforetax*0.15;
        }


        System.out.print("Total before tax: ");
        System.out.printf("%.2f",total);
        System.out.print(" CAD\n");
        System.out.print("Tip: ");
        System.out.printf("%.2f",tip);
        System.out.println(" CAD");
        System.out.print("Total after tax: ");
        System.out.printf("%.2f",totalaftertax);
        System.out.println(" CAD");
        System.out.print("Divided by ");
        System.out.print(noofpeople+": ");
        System.out.printf("%.2f",totalaftertax/noofpeople);
        System.out.print(" CAD");


    }
}
