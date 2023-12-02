package Bookstore_Management;

public class User {
    private String name;
    private String password;
    private String position;

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    

    public User(String name, String password, String position)
    {
        this.name = name;
        this.password = password;
        this.position = position;
    }



    public String getName() {
        return name;
    }






    public String getPassword() {
        return password;
    }


    public String getPosition() {
        return position;
    }




    @Override
    public String toString() {
        String tmp = "User is created \n"
        + "The name is: "+this.name 
        + "\nThe password is: "+this.password;

        return tmp;
    }
    @Override
    public boolean equals(Object obj) {
        User tmpUser = (User) obj;
       
        if( this.name.equals(tmpUser.name) && this.password.equals(tmpUser.password) )
        {
            return true;
        }
        return false;
    }

}
