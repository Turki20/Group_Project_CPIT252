package Main;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // إنشاء النموذج (Model) والعرض (View) والتحكم (Controller)
        CinemaModel model = new CinemaModel();
        CinemaView view = new CinemaView();
        CinemaController controller = new CinemaController(view, model);

                // إضافة أفلام تجريبية
        controller.addMovie("2D", "Avatar", "Sci-Fi", 162, 15.00, 20);
        controller.addMovie("3D", "Avengers", "Action", 143, 20.00, 20);
        controller.addMovie("IMAX", "Interstellar", "Sci-Fi", 169, 25.00, 20);
        
        // إضافة مستخدمين تجريبيين
        controller.addAdmin(1, "Admin", "admin@example.com");
        controller.addUser(2, "Turki Ahmed", "Turki@example.com");
        controller.addUser(3, "Zyad Omar", "jane@example.com");
        



        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                controller.displayMessage("\n--- Welcome to the Cinema Ticket Booking System ---");
                controller.displayMessage("Enter your User ID to log in: ");
                int userId = scanner.nextInt();
                scanner.nextLine(); // تنظيف الإدخال

                // التحقق من المستخدم
                User loggedInUser = controller.getUserById(userId);
                if (loggedInUser == null) {
                    controller.displayMessage("User not found. Please try again.");
                    continue;
                }

                // إذا كان المستخدم مديراً
                if (loggedInUser instanceof Admin) {
                    adminMenu(controller, scanner);
                } else {
                    userMenu(controller, loggedInUser, scanner);
                }
            } catch (InputMismatchException e) {
                controller.displayMessage("Error: Please enter valid input.");
                scanner.nextLine(); // تنظيف الإدخال الخاطئ
            } catch (Exception e) {
                controller.displayMessage("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void adminMenu(CinemaController controller, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            controller.diplayAdminMinu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            controller.displayMessage("\n *****\t\t*****");
            switch (choice) {
                case 1:
                    controller.displayMessage("Enter movie type (2D, 3D, IMAX): ");
                    String type = scanner.nextLine();
                    controller.displayMessage("Enter movie title: ");
                    String title = scanner.nextLine();
                    controller.displayMessage("Enter genre: ");
                    String genre = scanner.nextLine();
                    controller.displayMessage("Enter duration in minutes: ");
                    int duration = scanner.nextInt();
                    controller.displayMessage("Enter ticket price: ");
                    double price = scanner.nextDouble();
                    controller.displayMessage("Enter the number of seats: ");
                    int seats = scanner.nextInt();
                    controller.addMovie(type, title, genre, duration, price, seats);
                    break;
                case 2:
                    controller.displayMovies();
                    controller.displayMessage("Enter the index of the movie to remove: ");
                    int movieIndex = scanner.nextInt();
                    controller.removeMovie(movieIndex);
                    break;
                case 3:
                    controller.displayMovies();
                    break;
                case 4:
                    controller.displayAllTickets();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    controller.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private static void userMenu(CinemaController controller, User user, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            controller.diplayUserMinu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            controller.displayMessage("\n *****\t\t*****");

            switch (choice) {
                case 1:
                    controller.displayMovies();
                    break;
                case 2:
                    controller.displayMovies();
                    controller.displayMessage("Enter the index of the movie to book: ");
                    int movieIndex = scanner.nextInt();
                    controller.displayMessage("Enter the number of tickets: ");
                    int ticketCount = scanner.nextInt();
                    controller.bookTickets(user, movieIndex, ticketCount);
                    break;
                case 3:
                    controller.displayUserTickets(user);
                    break;
                case 4:
                    controller.displayUserTickets(user);
                    controller.displayMessage("Enter the index of the ticket to cancel: ");
                    int ticketIndex = scanner.nextInt();
                    controller.cancelUserTicket(user, ticketIndex);
                    break;
                case 5:
                    controller.displayMessage("Enter the amount to add: ");
                    double funds = scanner.nextDouble();
                    user.addFunds(funds);
                    break;
                case 6:
                    controller.displayMessage("Your wallet balance: $" + user.getWalletFunds());
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    controller.displayMessage("Invalid option. Please try again.");
            }
        }
    }
}
