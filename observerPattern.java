import java.util.*;

// Main class to run the example
public class observerPattern {

    // Observer interface
    interface Observer {
        void update(float temperature);
    }

    // Subject interface
    interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }

    // Concrete Subject
    static class WeatherStation implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private float temperature;

        public void setTemperature(float temperature) {
            this.temperature = temperature;
            System.out.println("\nWeatherStation: Temperature changed to " + temperature + "°C");
            notifyObservers();
        }

        public void registerObserver(Observer o) {
            observers.add(o);
        }

        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(temperature);
            }
        }
    }

    // Concrete Observer
    static class DisplayDevice implements Observer {
        private String name;

        public DisplayDevice(String name) {
            this.name = name;
        }

        public void update(float temperature) {
            System.out.println(name + " received temperature update: " + temperature + "°C");
        }
    }

    // Main method to test
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        DisplayDevice phoneDisplay = new DisplayDevice("Phone Display");
        DisplayDevice wallDisplay = new DisplayDevice("Wall Display");

        station.registerObserver(phoneDisplay);
        station.registerObserver(wallDisplay);

        station.setTemperature(25.5f);
        station.setTemperature(30.0f);

        // Remove one observer
        station.removeObserver(phoneDisplay);
        station.setTemperature(32.0f);
    }
}
