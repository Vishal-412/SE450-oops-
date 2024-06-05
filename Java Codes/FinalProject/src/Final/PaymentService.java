package Final;

public class PaymentService {
    public boolean processPayment(User user, double amount) { 
        Logger.log("Processing payment of $" + amount + " for user: " + user.getUsername());
     // Log payment processing event
        return true; // this shows a successful payment
    }
}

