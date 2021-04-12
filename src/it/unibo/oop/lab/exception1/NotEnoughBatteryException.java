package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotEnoughBatteryException() {
        super();
    }

    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Not enough battery";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

}
