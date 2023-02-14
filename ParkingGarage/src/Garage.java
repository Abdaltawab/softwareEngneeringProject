import java.util.LinkedList;
import java.util.Scanner;

public class Garage
{
    private int numOfTotalSlots;
    private int numOfFreeSlots;
    private double TotalIncome;
    private int numOfVehiclesInTheGarage;
    private boolean firstComesFirstServedSlots;

    private LinkedList<Slot> slots = new LinkedList<>();
    private LinkedList<User> Accounts = new LinkedList<>();
    private LinkedList<Vehicle> parkingVehicles = new LinkedList<>();
    private LinkedList<Slot> parkingSlotsForVehicles = new LinkedList<>();

    public Garage()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter The Number Of Slots in The Garage!");
        int initNumOfSlots = input.nextInt();

        System.out.println("\n--------------------------------------------------------------");

        System.out.println("Which Configuration Do You Want To Implement?");
        System.out.println("Type 1 for \"first come first served slots\" configuration. ");
        System.out.println("Type 2 for \"best-fit approach\" configuration. ");
        System.out.println("--------------------------------------------------------------");

        int choice = input.nextInt();

        while (choice < 1 || choice > 2)
        {
            System.out.println("Please Type Either 1 or 2");
            choice = input.nextInt();
        }

        if(choice == 1)
        {
            firstComesFirstServedSlots = true;
        }
        else
        {
            firstComesFirstServedSlots = false;
        }

        while(initNumOfSlots <= 0)
        {
            System.out.println("Can't Create Empty Garage!\nPlease Enter The Number Of Slots Again: ");
            initNumOfSlots = input.nextInt();
        }

        numOfTotalSlots = 0;
        numOfFreeSlots =  0;
        numOfVehiclesInTheGarage = 0;
        TotalIncome = 0;

        double w;
        double d;

        for(int i = 0; i < initNumOfSlots; i++)
        {
            System.out.println("Enter Slot " + (i+1) + "'s Width:");
            w = input.nextDouble();

            System.out.println("Enter Slot " + (i+1) + "'s Depth:");
            d = input.nextDouble();

            Slot tmp = new Slot(i, w, d);
            slots.addLast(tmp);

            numOfTotalSlots++;
        }
    }

    //------------------------
    // -------Getters---------
    //------------------------


    public LinkedList<Slot> getParkingSlotsForVehicles() {
        return parkingSlotsForVehicles;
    }

    public int getNumOfTotalSlots() {
        return numOfTotalSlots;
    }

    public int getNumOfFreeSlots() {
        return numOfFreeSlots;
    }

    public double getTotalIncome() {
        return TotalIncome;
    }

    public int getNumOfVehiclesInTheGarage() {
        return numOfVehiclesInTheGarage;
    }

    public Slot getSlotByIndex(int i) {
        return slots.get(i);
    }

    public User getUserByIndex(int i)
    {
        return Accounts.get(i);
    }

    public boolean isFirstComesFirstServedSlots()
    {
        return firstComesFirstServedSlots;
    }

    public int getNumOfAccounts()
    {
        return Accounts.size();
    }

    public LinkedList<Vehicle> getParkingVehicles() {
        return parkingVehicles;
    }

    //----------------------------------

    public void addToParkingVehicles(Vehicle v)
    {
        parkingVehicles.addLast(v);
    }

    public void decreaseFreeSlots()
    {
        numOfFreeSlots--;
    }

    public void DisplaySlots()
    {
        System.out.println("All Slots in The Garage: ");
        for(int i = 0; i<numOfTotalSlots; i++)
        {
            System.out.println((i+1) + "- Slot's ID: " + (slots.get(i).getID() + 1)
                    + ", Width: " + slots.get(i).getWidth()
                    + ", Depth: " + slots.get(i).getDepth()
                    + ", Status: " + (slots.get(i).isEmpty()?"Empty":"Not-Empty")) ;
        }
        System.out.println("---------------------------------------------");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    public void DisplayAvailableSlots()
    {
        int j = 1;
        System.out.println("All Available Slots in The Garage: ");
        for(int i = 0; i<numOfTotalSlots; i++)
        {
            if(slots.get(i).isEmpty())
            {
                System.out.println((j++) + "- ID: " + (slots.get(i).getID() + 1)
                        + ", Width: " + slots.get(i).getWidth()
                        + ", Depth: " + slots.get(i).getDepth()) ;
            }
        }
        System.out.println("---------------------------------------------");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    void DisplayParkingVehicles()
    {
        int j = 1;
        System.out.println("All Parking Vehicles in The Garage: ");
        for(int i = 0; i<parkingVehicles.size(); i++)
        {
            if(parkingVehicles.get(i).isParking())
            {
                System.out.println((j++) + "- ID: " + (parkingVehicles.get(i).getID() +1)
                        + ", Model Name : " + parkingVehicles.get(i).getModelName()
                        + ", Model Year : " + parkingVehicles.get(i).getModelYear()
                        + ", Width : " + parkingVehicles.get(i).getWidth()
                        + ", Depth : " + parkingVehicles.get(i).getDepth()
                        + ", Parked at : " + parkingVehicles.get(i).getDateAndTimeIn()) ;
            }
        }
        System.out.println("---------------------------------------------");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    public void addAccount(User u)
    {
        Accounts.addLast(u);
    }
}
