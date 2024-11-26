
package Main;


public class Movie3D extends Movie{
    public Movie3D(String title, String genre, int duration, double price, int seats) {
        super(title, genre, duration, price, seats);
    }

    @Override
    public String getType() {
        return "3D";
    }
}
