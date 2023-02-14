import java.util.Scanner;

public abstract class User {
    protected String name;
    protected int ID;
    protected String password;
    boolean isAdmin;

    public User(int id)
    {
        Scanner input = new Scanner(System.in);
        String n;
        ID = id;
        isAdmin = false;
        System.out.println("Please Enter Your Name: ");
        n = input.nextLine();
        for(int i = 0; i < n.length(); i++)
        {
            if(Character.isDigit(n.charAt(i)))
            {
                i = -1;
                System.out.println("Name Can't Include a Number!\nPlease Enter Your Name:");
                n = input.nextLine();
            }
        }
        name = n;
        System.out.println("Create a Strong Password: ");
        String p = input.nextLine().toString();
        while(p.length() < 8)
        {
            System.out.println("Password Has To Be At Least 8 Characters & Digits");
        }

        password = p;

        System.out.println("Your ID is: " + id + " , Save it To log in!");
    }

    //------------------------
    // -------Getters---------
    //------------------------

    public int getID()
    {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
