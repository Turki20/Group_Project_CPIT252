
package Main;


public class Ticket {
    private static int ticketCounter = 0;
    private int ticketId;
    private Movie movie;
   private int seatNumber; // unused 
    private double price;

    public Ticket(Movie movie, double price) {
        this.ticketId = ++ticketCounter;
        this.movie = movie;
     //   this.seatNumber = seatNumber;
        this.price = price;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }
}
