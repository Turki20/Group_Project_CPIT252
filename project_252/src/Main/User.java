package Main;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {

    protected int userId;
    protected String name;
    protected String email;
    protected List<Ticket> tickets;
    protected double walletFunds = 0;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.tickets = new ArrayList<>();
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            walletFunds += amount;
            System.out.println(amount + " Added to the wallet successfuly");
            System.out.println("the new wallet funds is: " + walletFunds + "$");
        } else {
            throw new IllegalArgumentException("Amount must be positive.");
        }
    }

    // Deduct Funds
    public void deductFunds(double amount) {
        if (amount > 0 && walletFunds >= amount) {
            walletFunds -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid amount.");
        }
    }

    // Add Ticket
    public void addTicket(Ticket ticket) {
        if (ticket != null) {
            tickets.add(ticket);
        } else {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }
    }

    // Remove Ticket
    public void removeTicket(Ticket ticket) {
        if (ticket != null && tickets.contains(ticket)) {
            tickets.remove(ticket);
        } else {
            throw new IllegalArgumentException("Ticket not found.");
        }
    }

    public void setWalletFunds(double walletFunds) {
        this.walletFunds = walletFunds;
    }

    public double getWalletFunds() {
        return walletFunds;
    }

    public void bookTicket(Ticket ticket) { // dont use it and tha function is the same as addTicket ---
        tickets.add(ticket);
    }

    public void cancelTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(String message) {
        System.out.println("USER " + name + " notified: " + message);
    }
}
