package org.example;

    public class DemoSalesperson {

        public static void main(String[] args) {
            // Declare an array of 10 Salesperson objects
            Salesperson[] salesPeople = new Salesperson[10];

            // Initialize each Salesperson with ID 9999 and sales 0.0
            for (int i = 0; i < salesPeople.length; i++) {
                salesPeople[i] = new Salesperson(9999, 0.0);
            }

            // Display each Salesperson object
            System.out.println("Salesperson details:");
            for (Salesperson salesPerson : salesPeople) {
                System.out.println(salesPerson);
            }
        }
    }


