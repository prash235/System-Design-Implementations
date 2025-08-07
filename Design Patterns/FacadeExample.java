// Subsystem 1
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}

// Subsystem 2
class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }

    public void off() {
        System.out.println("Projector is OFF");
    }
}

// Subsystem 3
class SoundSystem {
    public void on() {
        System.out.println("Sound System is ON");
    }

    public void setVolume(int level) {
        System.out.println("Sound volume set to: " + level);
    }

    public void off() {
        System.out.println("Sound System is OFF");
    }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem sound) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing to watch a movie...");
        projector.on();
        projector.setInput("DVD");
        sound.on();
        sound.setVolume(8);
        dvd.on();
        dvd.play(movie);
        System.out.println("Enjoy your movie!\n");
    }

    public void endMovie() {
        System.out.println("Shutting down the theater...");
        dvd.off();
        projector.off();
        sound.off();
        System.out.println("Movie finished. Everything is OFF.\n");
    }
}

// Client
public class FacadeExample {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
