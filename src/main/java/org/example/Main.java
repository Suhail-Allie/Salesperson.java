package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Salesperson
         class Salesperson {
            private int idNumber;
            private double annualSales;

            // Constructor that requires values for both fields
            public Salesperson(int idNumber, double annualSales) {
                this.idNumber = idNumber;
                this.annualSales = annualSales;
            }

            // Getter for idNumber
            public int getIdNumber() {
                return idNumber;
            }

            // Setter for idNumber
            public void setIdNumber(int idNumber) {
                this.idNumber = idNumber;
            }

            // Getter for annualSales
            public double getAnnualSales() {
                return annualSales;
            }

            // Setter for annualSales
            public void setAnnualSales(double annualSales) {
                this.annualSales = annualSales;
            }

            // Method to display Salesperson details
            public String toString() {
                return "ID Number: " + idNumber + ", Annual Sales: $" + annualSales;
            }
        }

//DemoSalesperson
 class DemoSalesperson {

            public static void main(String[] args) {
                // Declare an array of 10 Salesperson objects
                org.example.Salesperson[] salesPeople = new org.example.Salesperson[10];

                // Initialize each Salesperson with ID 9999 and sales 0.0
                for (int i = 0; i < salesPeople.length; i++) {
                    salesPeople[i] = new org.example.Salesperson(9999, 0.0);
                }

                // Display each Salesperson object
                System.out.println("Salesperson details:");
                for (org.example.Salesperson salesPerson : salesPeople) {
                    System.out.println(salesPerson);
                }
            }
        }

        //DemoSalesperson2
 class DemoSalesperson2 {

            public static void main(String[] args) {
                // Declare an array of 10 Salesperson objects
                org.example.Salesperson[] salesPeople = new org.example.Salesperson[10];

                // Initialize each Salesperson with a successive ID from 111 to 120
                // and sales values ranging from $25,000 to $70,000, increasing by $5,000
                int startingId = 111;
                double startingSales = 25000.0;

                for (int i = 0; i < salesPeople.length; i++) {
                    salesPeople[i] = new org.example.Salesperson(startingId + i, startingSales + (i * 5000));
                }

                // Display each Salesperson object
                System.out.println("Salesperson details:");
                for (org.example.Salesperson salesPerson : salesPeople) {
                    System.out.println(salesPerson);
                }
            }
        }

        //SalespersonSort
         class SalespersonSort {

            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                org.example.Salesperson[] salesPeople = new org.example.Salesperson[7];

                // Input data for 7 Salesperson objects
                for (int i = 0; i < salesPeople.length; i++) {
                    System.out.print("Enter ID number for Salesperson " + (i + 1) + ": ");
                    int id = input.nextInt();
                    System.out.print("Enter sales value for Salesperson " + (i + 1) + ": ");
                    double sales = input.nextDouble();
                    salesPeople[i] = new org.example.Salesperson(id, sales);
                }

                // Ask user how to sort the objects
                System.out.println("\nDo you want to sort the Salesperson objects by:");
                System.out.println("1. ID number");
                System.out.println("2. Sales value");
                int choice = input.nextInt();

                // Sort based on user's choice
                if (choice == 1) {
                    Arrays.sort(salesPeople, Comparator.comparing(org.example.Salesperson::getIdNumber));
                    System.out.println("\nSalesperson objects sorted by ID number:");
                } else if (choice == 2) {
                    Arrays.sort(salesPeople, Comparator.comparing(org.example.Salesperson::getAnnualSales));
                    System.out.println("\nSalesperson objects sorted by sales value:");
                } else {
                    System.out.println("Invalid choice.");
                    input.close();
                    return;
                }

                // Display the sorted Salesperson objects
                for (org.example.Salesperson salesPerson : salesPeople) {
                    System.out.println(salesPerson);
                }

                input.close();
            }
        }

        //SalespersonDatabase
         class SalespersonDatabase {

            private static final int MAX_SIZE = 20;
            private static org.example.Salesperson[] database = new org.example.Salesperson[MAX_SIZE];
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
                database[currentSize++] = new org.example.Salesperson(id, sales);
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

    }
}