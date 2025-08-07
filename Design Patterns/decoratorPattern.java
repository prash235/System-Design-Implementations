public class decoratorPattern {

    // Component Interface
    interface Coffee {
        String getDescription();
        double getCost();
    }

    // Concrete Component
    static class BasicCoffee implements Coffee {
        public String getDescription() {
            return "Basic Coffee";
        }

        public double getCost() {
            return 5.0;
        }
    }

    // Abstract Decorator
    static abstract class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        public String getDescription() {
            return coffee.getDescription();
        }

        public double getCost() {
            return coffee.getCost();
        }
    }

    // Concrete Decorators
    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        public String getDescription() {
            return super.getDescription() + ", Milk";
        }

        public double getCost() {
            return super.getCost() + 1.5;
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        public String getDescription() {
            return super.getDescription() + ", Sugar";
        }

        public double getCost() {
            return super.getCost() + 0.5;
        }
    }

    static class WhipDecorator extends CoffeeDecorator {
        public WhipDecorator(Coffee coffee) {
            super(coffee);
        }

        public String getDescription() {
            return super.getDescription() + ", Whipped Cream";
        }

        public double getCost() {
            return super.getCost() + 2.0;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Coffee basic = new BasicCoffee();
        System.out.println(basic.getDescription() + " - $" + basic.getCost());

        Coffee milk = new MilkDecorator(basic);
        System.out.println(milk.getDescription() + " - $" + milk.getCost());

        Coffee sugarMilk = new SugarDecorator(milk);
        System.out.println(sugarMilk.getDescription() + " - $" + sugarMilk.getCost());

        Coffee fancy = new WhipDecorator(sugarMilk);
        System.out.println(fancy.getDescription() + " - $" + fancy.getCost());
    }
}