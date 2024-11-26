
package Main;

import java.util.List;


public class BookingCommand implements Command{
    private User user;
    private int movieIndex;
    private int ticketCount;
    private List<Movie> movies;
    CinemaView view;
 
    
    public BookingCommand(User user, int movieIndex, int ticketCount, List<Movie> movies, CinemaView view) {
        this.user = user;
        this.movieIndex =movieIndex;
        this.ticketCount = ticketCount;
        this.movies = movies;
        this.view = view;
    }

    @Override
    public void execute() { 
        
        if (movieIndex >= 0 && movieIndex < movies.size()) {
            Movie movie = movies.get(movieIndex);
            if (ticketCount > 0 && ticketCount <= movie.getSeats()) {
                double totalPrice = ticketCount * movie.getPrice();
                PaymentProxy px = new PaymentProxy();                
                if (px.processPayment(user, totalPrice)) {
                    for (int i = 0; i < ticketCount; i++) {
                        Ticket ticket = new Ticket(movie, movie.getPrice());
                         user.addTicket(ticket);
                        
                      //  user.addTicket(ticket); // command pattern 
                    }
                    user.deductFunds(totalPrice);
                    movie.setSeats(movie.getSeats() - ticketCount);
                    view.displayMessage("Tickets booked successfully. Total price: $" + totalPrice);
                } else {
                    view.displayMessage("Insufficient funds. Please add money to your wallet.");
                }
            } else {
                view.displayMessage("Invalid ticket count or not enough seats available.");
            }
        } else {
            view.displayMessage("Invalid movie index.");
        }
       
    }
}
