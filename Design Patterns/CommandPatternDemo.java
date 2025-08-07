// Command interface
interface Command {
    void execute();
}

// Receiver - Light
class Light {
    public void on() {
        System.out.println("🔆 Light turned ON");
    }

    public void off() {
        System.out.println("🌑 Light turned OFF");
    }
}

// Receiver - Fan
class Fan {
    public void on() {
        System.out.println("🌀 Fan started");
    }

    public void off() {
        System.out.println("🛑 Fan stopped");
    }
}

// Receiver - TV
class TV {
    public void on() {
        System.out.println("📺 TV turned ON");
    }

    public void off() {
        System.out.println("📴 TV turned OFF");
    }
}

// Concrete Commands
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
}

class FanOnCommand implements Command {
    private Fan fan;
    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }
    public void execute() {
        fan.on();
    }
}

class FanOffCommand implements Command {
    private Fan fan;
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }
    public void execute() {
        fan.off();
    }
}

class TVOnCommand implements Command {
    private TV tv;
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.on();
    }
}

class TVOffCommand implements Command {
    private TV tv;
    public TVOffCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.off();
    }
}

// Invoker - Remote Control with multiple buttons
class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl(int slots) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOnButton(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
        }
    }

    public void pressOffButton(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
        }
    }
}

// Client
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receivers
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();
        TV television = new TV();

        // Command objects
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanOn = new FanOnCommand(ceilingFan);
        Command fanOff = new FanOffCommand(ceilingFan);
        Command tvOn = new TVOnCommand(television);
        Command tvOff = new TVOffCommand(television);

        // Remote with 3 slots
        RemoteControl remote = new RemoteControl(3);
        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, fanOn, fanOff);
        remote.setCommand(2, tvOn, tvOff);

        // Simulate button presses
        remote.pressOnButton(0);   // Light ON
        remote.pressOffButton(0);  // Light OFF
        remote.pressOnButton(1);   // Fan ON
        remote.pressOffButton(1);  // Fan OFF
        remote.pressOnButton(2);   // TV ON
        remote.pressOffButton(2);  // TV OFF
    }
}
