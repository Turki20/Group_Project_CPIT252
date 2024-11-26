
package Main;


public class MovieIMAX extends Movie{
    public MovieIMAX(String title, String genre, int duration, double price, int seats) {
        super(title, genre, duration,price, seats);
    }

    @Override
    public String getType() {
        return "IMAX";
    }
}
