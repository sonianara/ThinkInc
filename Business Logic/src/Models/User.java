class User
{
   private int userID;
   private String userName;
   private String hashWord;
	
   public boolean setID(int id)
   {
       //check for valid id, if not valid return false	
	   userID = id;
	   return true;
   }
	
   public int getID()
   {
       return userID;
   }
	
   public boolean setName(String name)
   {
      //check for valid string, return false if not valid
      userName = name;
      return true;
   }
   public String getName()
   {
      return userName;
   }
   
}