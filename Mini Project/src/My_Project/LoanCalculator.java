package My_Project;// package name
import java.util.Scanner; //Scanner class for user input
import java.text.DecimalFormat; // DecimalFormat class for formatting output
public class LoanCalculator // Create a class named LoanCalculator
{
    public static void main(String[] args) // Main method
    {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("NAME:HEMABALA");
        System.out.println("Enrollment Number:EBEON0723817730");
        System.out.println("\nChoose a loan category:");// Create a scanner object for user input
        System.out.println("Welcome to the Loan Calculator!");System.out.println("Welcome to the Loan Calculator!"); // Print a welcome message
        DecimalFormat decimalFormat = new DecimalFormat("0.00");// Create a DecimalFormat object to format output
        while (true) // Start an infinite loop
        {
            System.out.println("\nChoose a loan category:");// Display loan category options
            System.out.println("1. Personal Loan");
            System.out.println("2. Home Loan");
            System.out.println("3. Car Loan");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: "); // Prompt the user to enter a choice
            int choice = scanner.nextInt();
            if (choice == 4) // Check if the user wants to exit
            {
                System.out.println("Thank you! Goodbye!");
                break;
            }
            System.out.print("Enter loan amount: ");// Prompt the user to enter the loan amount
            float loanAmount = scanner.nextFloat();
            float annualInterestRate = 0; // Initialize a variable for the annual interest rate
         switch (choice)// Handle different loan category choices 
            {
                case 1:
                	System.out.println("Maximum interest rate for Personal Loan is 10%.");// Display maximum allowed interest rate for Personal Loan
                    System.out.print("Enter annual interest rate for Personal Loan (%): ");// Prompt the user to enter the annual interest rate for Personal Loan
                    float personalLoanRate = scanner.nextFloat();
                    if (personalLoanRate > 10.0f)// Check if the entered rate exceeds the limit
                    {
                        System.out.println("Invalid interest rate for Personal Loan. Please enter a valid rate.");
                        continue;
                    }
                    annualInterestRate = personalLoanRate;// Set the annual interest rate
                    break;
                case 2:
                	System.out.println("Maximum interest rate for Home Loan is 15%."); // Display maximum allowed interest rate for Home Loan
                    System.out.print("Enter annual interest rate for Home Loan (%): "); // Prompt the user to enter the annual interest rate for Home Loan
                    float homeLoanRate = scanner.nextFloat();
                    if (homeLoanRate > 15.0f) // Check if the entered rate exceeds the limit
                    {
                        System.out.println("Invalid interest rate for Home Loan. Please enter a valid rate.");
                        continue;
                    }
                    annualInterestRate = homeLoanRate;// Set the annual interest rate
                    break;
                case 3:
                	System.out.println("Maximum interest rate for Car Loan is 7%.");// Display maximum allowed interest rate for Car Loan
                    System.out.print("Enter annual interest rate for Car Loan (%): "); // Prompt the user to enter the annual interest rate for Car Loan
                    float carLoanRate = scanner.nextFloat();
                    if (carLoanRate > 7.0f) 
                    {
                        System.out.println("Invalid interest rate for Car Loan. Please enter a valid rate.");
                        continue;
                    }
                    annualInterestRate = carLoanRate;// Set the annual interest rate
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");// Handle invalid choice
                    continue;
            }

            System.out.print("Enter loan tenure (in months): ");// Prompt the user to enter the loan tenure in months
            int loanTenure = scanner.nextInt();
           float monthlyInterestRate = (annualInterestRate / 12) / 100;// Calculate the monthly interest rate
            float monthlyInstallment = 0;// Initialize a variable for the monthly installment
            switch (choice) // Calculate the monthly installment based on the loan category
            {
                case 1:
                    // Personal Loan
                    monthlyInstallment = calculatePersonalLoanInstallment(loanAmount, monthlyInterestRate, loanTenure);
                    System.out.println("Monthly installment for Personal Loan: Rs. " + decimalFormat.format(monthlyInstallment));
                    break;
                case 2:
                    // Home Loan
                    monthlyInstallment = calculateHomeLoanInstallment(loanAmount, monthlyInterestRate, loanTenure);
                    System.out.println("Monthly installment for Home Loan: Rs. " + decimalFormat.format(monthlyInstallment));
                    break;
                case 3:
                    // Car Loan
                    monthlyInstallment = calculateCarLoanInstallment(loanAmount, monthlyInterestRate, loanTenure);
                    System.out.println("Monthly installment for Car Loan: Rs. " + decimalFormat.format(monthlyInstallment));
                    break;
                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
         // Display the thank you message
            System.out.println("Thank you for availing a loan from our bank");
        }
       scanner.close(); // Close the scanner
    }
    public static float calculatePersonalLoanInstallment(float loanAmount, float monthlyInterestRate, int loanTenure) // Method to calculate the monthly installment for Personal Loan
    {
        float numerator = (float) Math.pow(1 + monthlyInterestRate, loanTenure);
        return (loanAmount * monthlyInterestRate * numerator) / (numerator - 1);
    }
    public static float calculateHomeLoanInstallment(float loanAmount, float monthlyInterestRate, int loanTenure)// Method to calculate the monthly installment for Home Loan 
    {
        float numerator = (float) Math.pow(1 + monthlyInterestRate, loanTenure);
        return (loanAmount * monthlyInterestRate * numerator) / (numerator - 1);
    }
    public static float calculateCarLoanInstallment(float loanAmount, float monthlyInterestRate, int loanTenure) // Method to calculate the monthly installment for Car Loan
    {
        float numerator = (float) Math.pow(1 + monthlyInterestRate, loanTenure);
        return (loanAmount * monthlyInterestRate * numerator) / (numerator - 1);
    }
}
