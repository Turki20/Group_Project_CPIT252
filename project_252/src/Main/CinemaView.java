package Main;

import Main.Ticket;
import Main.Movie;
import java.util.List;

public class CinemaView {

    public void displayMovies(List<Movie> movies) {
        System.out.println("Available Movies:");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " | " + movie.getType() + " | " + movie.getGenre()
                    + " | Duration: " + movie.getDuration() + " mins | Seats: " + movie.getSeats()
                    + " | Price: $" + movie.getPrice());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTickets(List<Ticket> tickets) {
        System.out.println("Your Tickets:");
        for (Ticket ticket : tickets) {
            System.out.println("Ticket ID: " + ticket.getTicketId() + " | Movie: " + ticket.getMovie().getTitle());
        }
    }

    public void diplayAdminMinu() {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. Add a movie");
        System.out.println("2. Remove a movie");
        System.out.println("3. Display all movies");
        System.out.println("4. Display all tickets");
        System.out.println("5. Logout");
        System.out.print("Choose an action: ");
    }

    public void diplayUserMinu() {
        System.out.println("\n--- User Menu ---");
        System.out.println("1. Display all movies");
        System.out.println("2. Book a ticket");
        System.out.println("3. View your tickets");
        System.out.println("4. Cancel a ticket");
        System.out.println("5. Add funds to your wallet");
        System.out.println("6. Show wallet balance");
        System.out.println("7. Logout");
        System.out.print("Choose an action: ");
    }
}
