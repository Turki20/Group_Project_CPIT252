
package Main;

public class PaymentProxy {
    private double availableFunds ; 

    public boolean processPayment(User user, double amount) {
        availableFunds=user.getWalletFunds();
        System.out.println("Processing payment of $" + amount);

        // Check if sufficient funds are available
        if (amount <= availableFunds) {
            return true;
        } else {
            System.out.println("Payment failed. Insufficient funds. You may need to add some funds to your wallet");
            return false;
        }
    }
}
