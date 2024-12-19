package patterns.singleton;

/**
 *
 * @author moham
 */
public class PaymentGateway {
    private static PaymentGateway instance;

    // Private constructor to prevent direct instantiation
    private PaymentGateway() {
        // Initialize any resources required for payment processing
    }

    // Public static method to provide a single instance
    public static PaymentGateway getInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }
        return instance;
    }

    // Method to process payment
    public boolean processPayment(String paymentType, double amount) {
        // Simulate payment processing logic
        switch (paymentType.toLowerCase()) {
            case "credit card":
                return processCreditCardPayment(amount);
            case "paypal":
                return processPayPalPayment(amount);
            default:
                System.out.println("Unsupported payment type: " + paymentType);
                return false;
        }
    }

    // Private methods for specific payment types
    private boolean processCreditCardPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Add your credit card processing logic here
        return true; // Return true if payment is successful
    }

    private boolean processPayPalPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Add your PayPal processing logic here
        return true; // Return true if payment is successful
    }
}
