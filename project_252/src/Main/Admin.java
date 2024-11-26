
package Main;


public class Admin extends User implements Observer{
    public Admin(int userId, String name, String email) {
        super(userId, name, email);
    }
    
    /*

    public void addMovie(String type, String title, String genre, int duration,double price, int seats) {
        MovieFactory.createMovie(type, title, genre, duration,price,seats);
        System.out.println("Movie added: " + title);
    }

    public void removeMovie(Movie movie) {
        // Add logic to remove movie from the list (not implemented here). check must implemented here 
        System.out.println("Movie removed: " + movie.getTitle());
    }
*/
}
