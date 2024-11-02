import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class AgeCalculator {

    public static void main(String[] args) {
        System.out.println("===Age Calculator==");
        System.out.println("\nEnter birth date details:");
        System.out.print("Year (YYYY): ");
        int year = getValidatedInput(1900, LocalDate.now().getYear());

        System.out.print("Month (1-12): ");
        int month = getValidatedInput(1, 12);

        System.out.print("Day (1-31): ");
        int maxDays = LocalDate.of(year, month, 1).lengthOfMonth();
        int day = getValidatedInput(1, maxDays);

        LocalDate birthDate = LocalDate.of(year, month, day);
        if (birthDate.isAfter(LocalDate.now())) {
            System.out.println("Birth date cannot be in the future!");
            return;
        }

        CalculateAge(birthDate);
    }
    private static int getValidatedInput(int min, int max) {
        Scanner sc =new Scanner(System.in);

        while (true) {
            try {
                int value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Please enter a value between %d and %d: ", min, max);
                }
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
                sc.nextLine();
            }
        }}
        static void CalculateAge(LocalDate birthdate){
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthdate, currentDate);
            System.out.println("\nYour Age is :");
            if(age.getMonths()==0 && age.getDays()==0){
                System.out.println(+age.getYears() +" years ");
            }
           else{
               System.out.println(age.getYears() +" years "+age.getMonths() +" months "+ age.getDays()+" days");
            }
        }
}



