// Abstract class - Template Method Pattern
abstract class PaymentProcessor {

    // Template method (final - can't be overridden)
    public final void processPayment(double amount) {
        validatePaymentDetails();
        debitAmount(amount);
        sendReceipt();
    }

    // Steps that subclasses must implement
    protected abstract void validatePaymentDetails();
    protected abstract void debitAmount(double amount);

    // Common step for all payment methods
    protected void sendReceipt() {
        System.out.println("Sending payment receipt to customer.");
    }
}

// Concrete class for Credit Card payments
class CreditCardPayment extends PaymentProcessor {
    @Override
    protected void validatePaymentDetails() {
        System.out.println("Validating credit card details...");
    }

    @Override
    protected void debitAmount(double amount) {
        System.out.println("Debiting $" + amount + " from credit card.");
    }
}

// Concrete class for UPI payments
class UPIPayment extends PaymentProcessor {
    @Override
    protected void validatePaymentDetails() {
        System.out.println("Validating UPI ID...");
    }

    @Override
    protected void debitAmount(double amount) {
        System.out.println("Debiting $" + amount + " from UPI account.");
    }
}

// Client
public class TemplateMethodPaymentExample {
    public static void main(String[] args) {
        PaymentProcessor ccPayment = new CreditCardPayment();
        System.out.println("=== Credit Card Payment ===");
        ccPayment.processPayment(150.75);

        System.out.println();

        PaymentProcessor upiPayment = new UPIPayment();
        System.out.println("=== UPI Payment ===");
        upiPayment.processPayment(80.50);
    }
}
