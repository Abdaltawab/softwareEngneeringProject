import java.util.Scanner;

public class MainClass {
    public static void main(String[]args)
    {
        Garage g1 = new Garage();

        System.out.println("------------------------------------------");

        while(true)
        {
            System.out.println("1- Create a New Account\n2- Log-in");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            while (choice < 1 || choice > 2)
            {
                System.out.println("Please Type Either 1 or 2 :");
                choice = input.nextInt();
            }

            if(choice == 1)
            {
                System.out.println("Are You Admin? (Press 'Y' if Yes)");
                String admin = input.next();

                if (admin.equals("y") || admin.equals("Y") || admin.equals("yes") || admin.equals("Yes"))
                {
                    Admin a = new Admin((g1.getNumOfAccounts()+1));
                    g1.addAccount(a);
                    input.nextLine();
                }
                else
                {
                    Driver d = new Driver((g1.getNumOfAccounts()+1));
                    g1.addAccount(d);
                    input.nextLine();
                }

            }
            else if(choice == 2)
            {
                System.out.println("Enter Your ID");
                int id = input.nextInt();

                int i = 0;
                boolean isValid = false;

                for(i = 0 ; i < g1.getNumOfAccounts(); i++) {
                    if (id == g1.getUserByIndex(i).getID()) {
                        User d = g1.getUserByIndex(i);
                        System.out.println("Please Enter Your Password: ");

                        input.nextLine();
                        String p = input.nextLine();

                        if (p.equals(d.getPassword())) {
                            System.out.println("Welcome " + d.getName() + "!\n");
                            isValid = true;
                            break;
                        } else {
                            for (int j = 0; j < 2; j++) {
                                System.out.println("Wrong Password!");
                                System.out.println("You Have " + (2 - i) + " More Tr" + ((i++ ==  1) ?"y":"ies") + "!\nTry Again:");
                                p = input.nextLine();
                                if (p == d.getPassword()) {
                                    System.out.println("Welcome " + d.getName() + "!");
                                    break;
                                }
                                if(i == 3)
                                {
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("ID not Found!");
                    input.nextLine();
                }

                if (g1.getUserByIndex(i).isAdmin)
                {
                    boolean logOut = false;
                    while (logOut == false && isValid) {
                        logOut = false;
                        System.out.println("List Of Services: ");
                        System.out.println("1- Show Total Income.");
                    }
                }
                else
                {
                    boolean logOut = false;
                    while (logOut == false && isValid)
                    {
                        logOut = false;
                        System.out.println("List Of Services: ");
                        System.out.println("1- Park-in.");
                        System.out.println("2- Add a New Vehicle.");
                        System.out.println("3- Display All Slots.");
                        System.out.println("4- Display Available Slots.");
                        System.out.println("5- Display Parking Vehicles.");
                        System.out.println("6- Log Out.");
                        System.out.println("Just Type the Number Beside the Choice you Want!");

                        int listChoice = input.nextInt();
                        while(listChoice < 1 || listChoice > 6)
                        {
                            System.out.println("Invalid Input\nEnter Again!");
                            listChoice = input.nextInt();
                        }

                        if(listChoice == 1)
                        {
                            Driver d = (Driver) g1.getUserByIndex(i);
                            int slot = d.park_in(g1);

                            if(slot > 0)
                            {
                                System.out.println("Successful Parking Reservation at Slot " + (slot +1) + "\n");
                            }
                            else if(slot == -1)
                            {
                                System.out.println("Already Parking!\n");
                            }
                            else if(slot == -2)
                            {
                                System.out.println("No Free Slots!\n");
                            }
                        }
                        else if(listChoice == 2)
                        {
                            Driver d = (Driver)g1.getUserByIndex(i);
                            d.addVehicle();
                        }
                        else if(listChoice == 3)
                        {
                            g1.DisplaySlots();
                        }
                        else if(listChoice == 4)
                        {
                            g1.DisplayAvailableSlots();
                        }
                        else if(listChoice == 5)
                        {
                            g1.DisplayParkingVehicles();
                        }
                        else if(listChoice == 6)
                        {
                            logOut = true;
                        }
                    }
                }
            }
        }
    }
}
