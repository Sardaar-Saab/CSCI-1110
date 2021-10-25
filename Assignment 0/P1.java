import java.util.Scanner;
public class P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noofpeople;
        double amount = 0;
        double total = 0;

        noofpeople = sc.nextInt();
        do {
            total += amount;
            amount = sc.nextDouble();
        } while (amount != 0 && amount > 0);

        System.out.print("Total: ");
        System.out.printf("%.2f", total);
        System.out.print(" CAD\n");
        System.out.print("Divided by ");
        System.out.print(noofpeople + ": ");
        System.out.printf("%.2f", total / noofpeople);
        System.out.print(" CAD");

    }
}