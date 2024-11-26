
package Main;


public class Movie2D extends Movie{
    
    public Movie2D(String title, String genre, int duration, double price, int seats) {
        super(title, genre, duration, price, seats);
        
    }

    @Override
    public String getType() {
        return "2D";
    }
}
