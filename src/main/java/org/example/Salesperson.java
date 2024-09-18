package org.example;

    public class Salesperson {
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


