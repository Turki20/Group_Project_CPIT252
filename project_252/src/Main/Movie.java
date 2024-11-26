package Main;

public abstract class Movie {

    protected String title;
    protected String genre;
    protected int duration;
    protected double price;
    protected int seats;

    public Movie(String title, String genre, int duration, double price, int seats) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.price = price;
        this.seats = seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    
    public int getSeats() {
        return seats;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }
}
