package group_p.sk_motorsauction;


import java.util.*;

class Vehicle {
    private String name;
    private String registrationNumber;
    private double costPrice;
    private double expenses;
    private double deposits;
    private double balance;

    public Vehicle(String name,String registrationNumber, double costPrice, double expenses) {
        this.name =name;
        this.registrationNumber = registrationNumber;
        this.costPrice = costPrice;
        this.expenses = expenses;
        
        this.balance = 0 ; // initial balance
    }
    public String getName(){
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getDeposits() {
        return deposits;
    }

    public double getBalance() {
        return balance;
    }

    public void clearBalance(double newbalance) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Deposits made on Vehicle: ");
        double newdeposits = sc.nextDouble();
        
        balance = newbalance - newdeposits;
        if (balance < 0) balance =0; // no negative balance
        deposits =  newdeposits;
    }
    

    public double computeProfitOrLoss(double sellingPrice) {
        double totalCost = costPrice + expenses;
        return sellingPrice - totalCost;
    }

    public void displayDetails() {
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Cost Price: " + costPrice);
        System.out.println("Expenses: " + expenses);
        System.out.println("Deposits: " + deposits);
        System.out.println("Balance Left: " + balance);
    }
}

public class VEhicleAuction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        

        // Step 1: Enter vehicle details
        System.out.println("Enter Vehicle name");
        String name = sc.nextLine();
        System.out.print("Enter Vehicle Registration Number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Vehicle Cost Price: ");
        double costPrice = sc.nextDouble();

        System.out.print("Enter Expenses incurred on Vehicle: ");
        double expenses = sc.nextDouble();

        

        Vehicle vehicle = new Vehicle(name, regNo, costPrice, expenses);

        // Step 2: Accept bids from 3 bidders
        double[] bids = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter bid amount for Bidder " + (i + 1) + ": ");
            bids[i] = sc.nextDouble();
        }

        // Step 3: Find highest bidder
        double highestBid = bids[0];
        int highestBidder = 1;
        for (int i = 1; i < 3; i++) {
            if (bids[i] > highestBid) {
                highestBid = bids[i];
                highestBidder = i + 1;
            }
        }

        System.out.println("\nHighest Bidder is Bidder " + highestBidder + " with amount: " + highestBid);

        // Step 4: Clear balance (simulate payment)
        vehicle.clearBalance(highestBid);

        // Step 5: Display vehicle details
        vehicle.displayDetails();

        // Step 6: Compute profit/loss
        double profitOrLoss = vehicle.computeProfitOrLoss(highestBid);
        if (profitOrLoss > 0) {
            System.out.println("Profit made: " + profitOrLoss);
        } else if (profitOrLoss < 0) {
            System.out.println("Loss incurred: " + profitOrLoss);
        } else {
            System.out.println("No Profit, No Loss.");
        }

        sc.close();
    }
}


    

