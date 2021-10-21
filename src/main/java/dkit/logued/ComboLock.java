package dkit.logued;

public class ComboLock {

    // The three correct (secret) combination numbers for this ComboLock
    // are stored in order (Right,Left,Right), and initialized in constructor
    int secret1;
    int secret2;
    int secret3;

    private ComboLockState comboLockState;  // Enum to store state of Lock
                                            // See definition in ComboLockState.java

    // constructor
    public ComboLock(int num1, int num2, int num3) {
        this.secret1 = num1;
        this.secret2 = num2;
        this.secret3 = num3;
        this.comboLockState = ComboLockState.NONE_CORRECT;
    }

    public void reset() {
        this.comboLockState = ComboLockState.NONE_CORRECT;
    }

    public void turnRight(int number) {
        if (comboLockState == ComboLockState.NONE_CORRECT && secret1 == number)
            comboLockState = ComboLockState.FIRST_CORRECT;
        else {

            if (comboLockState == ComboLockState.SECOND_CORRECT && secret3 == number)
                comboLockState = ComboLockState.ALL_CORRECT;
            else
                reset();    // if neither of above then, reset() lock to NONE_CORRECT state
        }
    }

    public void turnLeft(int number) {
        if (comboLockState == ComboLockState.FIRST_CORRECT && secret2 == number)
            comboLockState = ComboLockState.SECOND_CORRECT;
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
