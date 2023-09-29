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
        System.out.println("\n\n*********  Combination Lock Simulator App ***********");

        ComboLock lock = new ComboLock( 30,15,35);

        lock.reset();
        lock.turnRight( 30 );
        lock.turnLeft( 15 );
        lock.turnRight( 99 );   // an incorrect entry

        System.out.print("First attempt:\t");
        if ( lock.open() )
            System.out.println("lock opened successfully");
        else
            System.out.println("lock not opened, incorrect code combination entered!");


        System.out.print("\nSecond attempt:\t");
        lock.reset();
        lock.turnRight( 30 );
        lock.turnLeft( 15 );
        lock.turnRight( 35 );

        if ( lock.open() )
            System.out.println("lock opened successfully");
        else
            System.out.println("lock not opened, incorrect code combination entered!");
    }
}


