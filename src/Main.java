import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Call Array Operations
                    break;
                case 2:
                    // Call Stack Operations
                    break;
                case 3:
                    // Call Queue Operations
                    break;
                case 4:
                    // Call Linked List Operations
                    break;
                case 5:
                    // Call Searching Operations
                    break;
                case 6:
                    // Call Graph Operations
                    break;
                case 7:
                    // Call Performance Comparison
                    break;
                case 8:
                    // Call Display All Results
                    break;
                case 9:
                    System.out.println("Exiting System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}