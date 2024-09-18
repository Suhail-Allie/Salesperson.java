package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

    public class SalespersonSort {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Salesperson[] salesPeople = new Salesperson[7];

            // Input data for 7 Salesperson objects
            for (int i = 0; i < salesPeople.length; i++) {
                System.out.print("Enter ID number for Salesperson " + (i + 1) + ": ");
                int id = input.nextInt();
                System.out.print("Enter sales value for Salesperson " + (i + 1) + ": ");
                double sales = input.nextDouble();
                salesPeople[i] = new Salesperson(id, sales);
            }

            // Ask user how to sort the objects
            System.out.println("\nDo you want to sort the Salesperson objects by:");
            System.out.println("1. ID number");
            System.out.println("2. Sales value");
            int choice = input.nextInt();

            // Sort based on user's choice
            if (choice == 1) {
                Arrays.sort(salesPeople, Comparator.comparing(Salesperson::getIdNumber));
                System.out.println("\nSalesperson objects sorted by ID number:");
            } else if (choice == 2) {
                Arrays.sort(salesPeople, Comparator.comparing(Salesperson::getAnnualSales));
                System.out.println("\nSalesperson objects sorted by sales value:");
            } else {
                System.out.println("Invalid choice.");
                input.close();
                return;
            }

            // Display the sorted Salesperson objects
            for (Salesperson salesPerson : salesPeople) {
                System.out.println(salesPerson);
            }

            input.close();
        }
    }


