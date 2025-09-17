package dkit.logued;

public class ComboLock {
    // The three correct (secret) combination numbers for this ComboLock
    // are stored in order (Right,Left,Right), and initialized in the constructor
    private final int secret1;
    private final int secret2;
    private final int secret3;

    private ComboLockState comboLockState;  // Enum to store current state of Lock

    // See enum definition in ComboLockState.java

    // constructor
    public ComboLock(int digit1, int digit2, int digit3) {
        this.secret1 = digit1;    // program the lock with the code to open the lock
        this.secret2 = digit2;
        this.secret3 = digit3;
        this.comboLockState = ComboLockState.NONE_CORRECT;  // set initial state
    }

    public void reset() {
        this.comboLockState = ComboLockState.NONE_CORRECT;
    }


    public void turnRight(int number) {
        if (comboLockState == ComboLockState.NONE_CORRECT && secret1 == number) {
            comboLockState = ComboLockState.FIRST_CORRECT;
        } else {
            if (comboLockState == ComboLockState.SECOND_CORRECT && secret3 == number) {
                comboLockState = ComboLockState.ALL_CORRECT;
            } else {
                reset();    // if none of the above, then, reset() lock to NONE_CORRECT state
            }
        }
    }

    public void turnLeft(int number) {
        if (comboLockState == ComboLockState.FIRST_CORRECT && secret2 == number) {
            comboLockState = ComboLockState.SECOND_CORRECT;
        }
        else
            reset();
    }

    public boolean open() {
        if (comboLockState == ComboLockState.ALL_CORRECT)
            return true;
        else
            return false;
    }
}









