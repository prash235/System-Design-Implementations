// Step 1: Notification interface
interface Notification {
    void notifyUser();
}

// Step 2: Concrete implementations
class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

// Step 3: Simple Factory class
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type == null || type.isEmpty()) return null;

        switch (type.toLowerCase()) {
            case "email": return new EmailNotification();
            case "sms": return new SMSNotification();
            case "push": return new PushNotification();
            default: return null;
        }
    }
}

// Step 4: Client code
public class SimpleFactoryExample {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("email");
        notification1.notifyUser();

        Notification notification2 = NotificationFactory.createNotification("sms");
        notification2.notifyUser();

        Notification notification3 = NotificationFactory.createNotification("push");
        notification3.notifyUser();
    }
}
