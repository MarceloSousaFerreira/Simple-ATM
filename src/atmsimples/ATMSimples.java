package atmsimples;

import java.util.Scanner;   

public class ATMSimples {
    
    public static void main(String[] args) {
        // starting with a dummy balance for testing purposes
        double balance = 1000.00;
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n--- ATM SYSTEM ---");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Deposit Funds");
            System.out.println("3 - Withdraw Funds");
            System.out.println("4 - Exit");
            System.out.print("Select an option: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.printf("\nCurrent Balance: $%.2f\n", balance);
                    break;
                    
                case 2:
                    System.out.print("\nEnter amount to deposit: ");
                    double depositValue = scanner.nextDouble();
                    
                    // safeguard against invalid deposit amounts
                    if (depositValue <= 0) {
                        System.out.println("Error: Deposit amount must be greater than zero.");
                    } else {
                        balance += depositValue;
                        System.out.printf("Success! New Balance: $%.2f\n", balance);
                    }
                    break;
                    
                case 3:
                    System.out.print("\nEnter amount to withdraw: ");
                    double withdrawValue = scanner.nextDouble();
                    
                    // handle edge cases for withdrawals
                    if (withdrawValue <= 0) {
                        System.out.println("Error: Withdrawal amount must be greater than zero.");
                    } else if (withdrawValue > balance) {
                        System.out.println("Error: Insufficient funds.");
                    } else {
                        balance -= withdrawValue;
                        System.out.printf("Success! New Balance: $%.2f\n", balance);
                    }
                    break;
                    
                case 4:
                    System.out.println("\nEnding session. Goodbye!");
                    break;
                    
                default:
                    System.out.println("\nInvalid option. Try again.");
            }
            
        } while (choice != 4);
        
        scanner.close();
    }
}
