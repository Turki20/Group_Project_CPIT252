package Main;


import java.util.List;

public class CinemaController {

    private final CinemaView view;
    private final CinemaModel model;
    private Command command;

    public CinemaController(CinemaView view, CinemaModel model) {
        this.view = view;
        this.model = model;
    }

    public void addAdmin(int userId, String name, String email) {
        model.addUser(new Admin(userId, name, email));
    }

    public void addUser(int userId, String name, String email) {
        model.addUser(new User(userId, name, email));
    }

    public void addMovie(String type, String title, String genre, int duration, double price, int seats) {
        try {
            Movie movie = MovieFactory.createMovie(type, title, genre, duration, price, seats);
            model.addMovie(movie);
           view.displayMessage("Movie added successfully: " + title);
        } catch (IllegalArgumentException e) {
            view.displayMessage("Error adding movie: " + e.getMessage());
        }
    }

    public void removeMovie(int index) {
        List<Movie> movies = model.getMovies();
        if (index >= 0 && index < movies.size()) {
            Movie movie = movies.get(index);
            movies.remove(movie);
            view.displayMessage("Movie removed successfully: " + movie.getTitle());
        } else {
            view.displayMessage("Invalid movie index.");
        }
    }

    public void displayMovies() {
        List<Movie> movies = model.getMovies();
        view.displayMovies(movies);
    }

    public void bookTickets(User user, int movieIndex, int ticketCount) {
        command = new BookingCommand(user, movieIndex, ticketCount, model.getMovies(), view);
        command.execute();
    }

    public void displayMessage(String msg) {
        view.displayMessage(msg);
    }

    public void diplayAdminMinu() {
        view.diplayAdminMinu();
    }

    public void diplayUserMinu() {
        view.diplayUserMinu();
    }

    // إلغاء تذكرة
    public void cancelUserTicket(User user, int ticketIndex) {
        command = new CancelCommand(user, ticketIndex, view, user.getTickets());
        command.execute();
    }

    // عرض تذاكر المستخدم
    public void displayUserTickets(User user) {
        List<Ticket> tickets = user.getTickets();
        view.displayTickets(tickets);
    }

    // عرض جميع التذاكر
    public void displayAllTickets() {
        List<User> users = model.getUsers();
        for (User user : users) {
            if (!user.getTickets().isEmpty()) {
                view.displayMessage("*****\tTickets for user: " + user.getName()+"\t*****");
                view.displayTickets(user.getTickets());
            }
        }
    }

    // الحصول على مستخدم حسب ID
    public User getUserById(int userId) {
        return model.getUsers().stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public void addObserver(Observer observer) {

    }
}
