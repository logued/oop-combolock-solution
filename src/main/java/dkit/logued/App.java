package dkit.logued;

/**
 * Combination Lock simulation.
 *
 */
public class App 
{
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {

        ComboLock lock = new ComboLock( 30,15,35);

        lock.reset();

        lock.turnRight( 30 );
        lock.turnLeft( 15 );
        lock.turnRight( 35 );

        if ( lock.open() )
            System.out.println("opened successfully");
        else
            System.out.println("not opened, codes were wrong!");
    }
}
