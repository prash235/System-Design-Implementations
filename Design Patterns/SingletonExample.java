// Singleton class
class AppConfig {
    // Step 1: Declare a private static instance
    private static AppConfig instance;

    // Step 2: Private constructor to prevent external instantiation
    private AppConfig() {
        System.out.println("AppConfig instance created!");
    }

    // Step 3: Public method to provide access to the instance
    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig(); // Lazy initialization
        }
        return instance;
    }

    public void printConfig() {
        System.out.println("Reading application configuration...");
    }
}

// Main class to test
public class SingletonExample {
    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        config1.printConfig();

        AppConfig config2 = AppConfig.getInstance();
        config2.printConfig();

        System.out.println("Are both instances same? " + (config1 == config2));
    }
}
