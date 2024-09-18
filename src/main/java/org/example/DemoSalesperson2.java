package org.example;

    public class DemoSalesperson2 {

        public static void main(String[] args) {
            // Declare an array of 10 Salesperson objects
            Salesperson[] salesPeople = new Salesperson[10];

            // Initialize each Salesperson with a successive ID from 111 to 120
            // and sales values ranging from $25,000 to $70,000, increasing by $5,000
            int startingId = 111;
            double startingSales = 25000.0;

            for (int i = 0; i < salesPeople.length; i++) {
                salesPeople[i] = new Salesperson(startingId + i, startingSales + (i * 5000));
            }

            // Display each Salesperson object
            System.out.println("Salesperson details:");
            for (Salesperson salesPerson : salesPeople) {
                System.out.println(salesPerson);
            }
        }
    }


