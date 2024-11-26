package Main;

import java.util.List;

public class CancelCommand implements Command {

    private User user;
    private int ticketIndex;
    private CinemaView view;
    private List<Ticket> tickets;

    public CancelCommand(User user, int ticketIndex, CinemaView view, List<Ticket> tickets) {
        this.user = user;
        this.ticketIndex = ticketIndex;
        this.view = view;
        this.tickets = tickets;
    }

    @Override
    public void execute() {

        if (ticketIndex >= 0 && ticketIndex < tickets.size()) {
            Ticket ticket = tickets.get(ticketIndex);

            if (user.getTickets().contains(ticket)) {
                user.cancelTicket(ticket);
                view.displayMessage("Ticket cancelled: " + ticket.getTicketId());
                user.setWalletFunds(user.getWalletFunds() + ticket.getMovie().getPrice());// to deduct the price from user funds
            } else {
                view.displayMessage("the ticket is already canceld or not exist.");
            }
            
            Movie movie = ticket.getMovie();
            movie.setSeats(movie.getSeats() + 1); 
            view.displayMessage("Ticket canceled successfully: " + movie.getTitle());
        } else {
            view.displayMessage("Invalid ticket index.");
        }

    }
}
