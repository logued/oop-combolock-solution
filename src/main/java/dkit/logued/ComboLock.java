package dkit.logued;

public class ComboLock {

    // instance variables (fields)
    // The three correct combination numbers in order (Right,Left,Right)
    int secret1;
    int secret2;
    int secret3;

    private ComboLockState comboLockState;

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
                reset();    // if incorrrect number entered, reset lock to initial state
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
