
package Main;


public class MovieFactory {
    public static Movie createMovie(String type, String title, String genre, int duration, double price, int seats) {
        switch (type) {
            case "2D":
                return new Movie2D(title, genre, duration, price, seats);
            case "3D":
                return new Movie3D(title, genre, duration, price, seats);
            case "IMAX":
                return new MovieIMAX(title, genre, duration, price, seats);
            default:
                throw new IllegalArgumentException("Invalid movie type");
        }
    }
}
