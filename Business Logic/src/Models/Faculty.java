package Models;

public class Faculty extends User {
    private static final int DAYS_IN_WEEK = 7;
    private static final int THIRTY_MIN_INTERVALS_PER_DAY = 48;

    private int[][] preferredTimes = new int[DAYS_IN_WEEK][THIRTY_MIN_INTERVALS_PER_DAY];
    // workload preference
    // course preferences

    public Faculty(int userID, String userName, String email, String firstName, String lastName) {
        super(userID, userName, email, firstName, lastName);
    }

    public void setPreferences()
   {
      return;
   }
}