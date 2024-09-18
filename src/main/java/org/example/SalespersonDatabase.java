package org.example;
import java.util.Arrays;
import java.util.Scanner;

    public class SalespersonDatabase {

        private static final int MAX_SIZE = 20;
        private static Salesperson[] database = new Salesperson[MAX_SIZE];
        private static int currentSize = 0;

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\nSalesperson Database Options:");
                System.out.println("1. Add a record");
                System.out.println("2. Delete a record");
                System.out.println("3. Change a record");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        addRecord(input);
                        break;
                    case 2:
                        deleteRecord(input);
                        break;
                    case 3:
                        changeRecord(input);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

                // Display the updated database after each operation
                displayDatabase();

            } while (choice != 4);

            input.close();
        }

        private static void addRecord(Scanner input) {
            if (currentSize >= MAX_SIZE) {
                System.out.println("Error: Database is full.");
                return;
            }

            System.out.print("Enter ID number: ");
            int id = input.nextInt();

            // Check if ID already exists
            if (findIndexById(id) != -1) {
                System.out.println("Error: ID number already exists.");
                return;
            }

            System.out.print("Enter sales value: ");
            double sales = input.nextDouble();

            // Add new record
            database[currentSize++] = new Salesperson(id, sales);
        }

        private static void deleteRecord(Scanner input) {
            if (currentSize == 0) {
                System.out.println("Error: Database is empty.");
                return;
            }

            System.out.print("Enter ID number to delete: ");
            int id = input.nextInt();

            int index = findIndexById(id);
            if (index == -1) {
                System.out.println("Error: ID number does not exist.");
                return;
            }

            // Remove the record by shifting elements
            for (int i = index; i < currentSize - 1; i++) {
                database[i] = database[i + 1];
            }
            database[--currentSize] = null; // Clear the last element
        }

        private static void changeRecord(Scanner input) {
            if (currentSize == 0) {
                System.out.println("Error: Database is empty.");
                return;
            }

            System.out.print("Enter ID number to change: ");
            int id = input.nextInt();

            int index = findIndexById(id);
            if (index == -1) {
                System.out.println("Error: ID number does not exist.");
                return;
            }

            System.out.print("Enter new sales value: ");
            double sales = input.nextDouble();
            database[index].setAnnualSales(sales);
        }

        private static void displayDatabase() {
            if (currentSize == 0) {
                System.out.println("Database is empty.");
                return;
            }

            // Sort the array by ID number
            Arrays.sort(database, 0, currentSize, (a, b) -> Integer.compare(a.getIdNumber(), b.getIdNumber()));

            System.out.println("\nSalesperson Database:");
            for (int i = 0; i < currentSize; i++) {
                System.out.println(database[i]);
            }
        }

        private static int findIndexById(int id) {
            for (int i = 0; i < currentSize; i++) {
                if (database[i].getIdNumber() == id) {
                    return i;
                }
            }
            return -1;
        }
    }


