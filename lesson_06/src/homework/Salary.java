package homework;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        int salary = 500;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many years you work in company?: ");
        double experience = scanner.nextInt();
        double salaryRevision3 = 0.1;
        double salaryRevision5 = 0.5;
        double salaryRevision10 = 1.0;
        double salaryRevision15 = 1.5;

        switch ((int) experience) {
            case 1, 2:
                System.out.println("Thank you for your job, but your time in company \ndoesn't include additional bonus");
                break;
            case 3, 4:
                System.out.println("Your additional bonus is - 10%.\nYour new salary is: " + (salary + salary * salaryRevision3) + " euro");
                break;
            case 5, 6, 7, 8, 9:
                System.out.println("Your additional bonus is - 50%.\nYour new salary is: " + (salary + salary * salaryRevision5) + " euro");
                break;
            case 10, 11, 12, 13, 14:
                System.out.println("Your additional bonus is - 100%.\nYour new salary is: " + (salary + salary * salaryRevision10) + " euro");
                break;
            case 15:
                System.out.println("Your additional bonus is - 150%.\nYour new salary is: " + (salary + salary * salaryRevision15) + " euro");
                break;
            default:
                System.out.println("Please contact to accounting department");
        }
    }
}
