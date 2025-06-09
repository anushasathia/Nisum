class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
final class InvalidPaymentMethodException extends PaymentException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}
final class InvalidOfferAppliedException extends PaymentException {
    public InvalidOfferAppliedException(String message) {
        super(message);
    }
}

enum PaymentType {
    CREDIT_CARD, DEBIT_CARD, UPI, WALLET
}
enum OfferType {
    NONE, DISCOUNT_10, FREE_SHIPPING
}

public class MyPaymentService {

    public void executePayment(PaymentType methodUsed, OfferType promoCode) {
        System.out.println("Attempting payment with " + methodUsed + " and offer " + promoCode + "...");

        if (methodUsed == PaymentType.UPI) {
            throw new InvalidPaymentMethodException("UPI is not available right now");
        }

        if (promoCode == OfferType.FREE_SHIPPING && methodUsed != PaymentType.CREDIT_CARD) {
            throw new InvalidOfferAppliedException("Free shipping only works with Credit Card payments");
        }

        System.out.println("Payment processed successfully with " + methodUsed + " and offer " + promoCode + "!");
    }

    public void tryToProcessPayment(PaymentType currentMethod, OfferType currentOffer) {
        try {
            executePayment(currentMethod, currentOffer);
        } catch (PaymentException pe) {
            
            if (pe instanceof InvalidPaymentMethodException) {
                InvalidPaymentMethodException paymentMethodIssue = (InvalidPaymentMethodException) pe;
                System.out.println("Method Error: " + paymentMethodIssue.getMessage());
            } else if (pe instanceof InvalidOfferAppliedException) {
                InvalidOfferAppliedException offerIssue = (InvalidOfferAppliedException) pe;
                System.out.println("Offer Error: " + offerIssue.getMessage());
            } else {
                System.out.println("Unexpected payment error: " + pe.getMessage());
            }
        } catch (Exception anyOtherError) {
            System.out.println("Unexpected error: " + anyOtherError.getMessage());
        }
    }

    public static void main(String[] args) {
        MyPaymentService paymentBuddy = new MyPaymentService();

        System.out.println("Test 1: Good Payment");
        paymentBuddy.tryToProcessPayment(PaymentType.DEBIT_CARD, OfferType.NONE);

        System.out.println("\nTest 2: Invalid Payment Method");
        paymentBuddy.tryToProcessPayment(PaymentType.UPI, OfferType.NONE);

        System.out.println("\nTest 3: Invalid Offer for Method");
        paymentBuddy.tryToProcessPayment(PaymentType.DEBIT_CARD, OfferType.FREE_SHIPPING);

        System.out.println("\n Test 4: Another Good Payment");
        paymentBuddy.tryToProcessPayment(PaymentType.CREDIT_CARD, OfferType.FREE_SHIPPING);
    }
}
