import java.util.ArrayList;
import java.util.List;

// Component
interface MenuComponent {
    void showDetails(String indent);
}

// Leaf
class MenuItem implements MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "🍽 " + name + " - $" + price);
    }
}

// Composite
class Menu implements MenuComponent {
    private String name;
    private List<MenuComponent> components = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    public void remove(MenuComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📋 " + name);
        for (MenuComponent c : components) {
            c.showDetails(indent + "   ");
        }
    }
}

// Client
public class CompositeMenuExample {
    public static void main(String[] args) {
        // Leaf menu items
        MenuItem pizza = new MenuItem("Pizza", 8.99);
        MenuItem burger = new MenuItem("Burger", 5.49);
        MenuItem iceCream = new MenuItem("Ice Cream", 3.99);
        MenuItem cake = new MenuItem("Chocolate Cake", 4.49);

        // Composite menus
        Menu mainMenu = new Menu("Main Menu");
        Menu dessertMenu = new Menu("Desserts");

        // Build structure
        mainMenu.add(pizza);
        mainMenu.add(burger);
        dessertMenu.add(iceCream);
        dessertMenu.add(cake);

        // Nested menu
        mainMenu.add(dessertMenu);

        // Display
        mainMenu.showDetails("");
    }
}
