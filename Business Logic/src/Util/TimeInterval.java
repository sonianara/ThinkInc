package Util;

/**
 * Interval class created to represent time in 24 hr format (HH.MM).
 *
 * @author Kris Campos
 * @version initial version - 1/31/2017.
 */
public class TimeInterval {
    private double startTime;
    private double endTime;

    public static final double MIN_TIME = 0.0;
    public static final double MAX_TIME = 23.59;

    // constructors

    public TimeInterval(double startTime, double endTime) {
        if(startTime >= 0.0 || endTime <= 23.59 || endTime < startTime) {
            throw new IllegalArgumentException("startTime and endTime must not disobey the following rule:\n" +
                    "startTime >= 0.0 || endTime <= 23.59 || endTime < startTime");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // getters and setters

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    // functional methods

    public boolean overlaps(TimeInterval other) {
        return this.startTime <= other.endTime && other.startTime <= this.endTime;
    }
}
