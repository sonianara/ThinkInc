package Models;

public class Faculty extends User {
   private FacultyPreferences preferences;

    public Faculty(int userID, String userName, String email, String firstName, String lastName) {
        super(userID, userName, email, firstName, lastName);
    }

    public void setPreferences()
   {
      return;
   }
}