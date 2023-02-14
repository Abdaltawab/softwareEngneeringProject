import java.util.LinkedList;
import java.util.Scanner;

public class Driver extends  User
{
    LinkedList<Vehicle> vehicles = new LinkedList<>();

    public Driver(int id)
    {
        super(id);
        this.isAdmin = false;
    }

    //-------------------------------------

    public void addVehicle()
    {
        String ModelName;
        int ModelYear;
        int id;
        double Width;
        double Depth;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter The Model Name Of Your Vehicle: ");
        ModelName = input.nextLine();

        System.out.println("Enter The Model Year Of Your Vehicle: ");
        ModelYear = input.nextInt();

        System.out.println("Enter The ID Of Your Vehicle: ");
        do{id = input.nextInt();}
        while (id <= 0);

        System.out.println("Enter The Width Of Your Vehicle: ");
        Width = input.nextDouble();

        System.out.println("Enter The Depth Of Your Vehicle: ");
        Depth = input.nextDouble();

        Vehicle v = new Vehicle(ModelName, ModelYear, id, Width, Depth);

        vehicles.addLast(v);
    }

    public int park_in(Garage g)
    {
        int slot = -1;

        if(vehicles.size() == 0)
        {
            System.out.println("Add A Vehicle To Your Account First!\n");
            addVehicle();
        }
        else
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Your Vehicles: ");

            for(int i = 0; i < vehicles.size(); i++)
            {
                System.out.println((i+1) + "- " + vehicles.get(i).getModelName() + " " + vehicles.get(i).getID());
            }

            System.out.println("Type The Number beside The Vehicle you Want to Park or Type 0 To Add a New Car!");

            int VehicleChoice = input.nextInt();

            while (VehicleChoice < 0 || VehicleChoice > vehicles.size())
            {
                System.out.println("Invalid Choice, Enter Again: ");
                VehicleChoice = input.nextInt();
            }

            if(VehicleChoice == 0)
            {
                addVehicle();
            }
            else
            {
                Vehicle v = vehicles.get(VehicleChoice - 1);
                slot = (Controller.parkIn(g, v));
            }
        }
        return slot;
    }

    public void park_Out(Garage g)
    {
        int slot = -1;

        if(vehicles.size() == 0)
        {
            System.out.println("Add A Vehicle To Your Account First!\n");
            addVehicle();
        }
        else {
            LinkedList<Vehicle> ParkingVehicles = new LinkedList<>();
            System.out.println("Your Parking Vehicles:\n");
            int j = 0;
            for (int i = 0; i < vehicles.size(); i++)
            {
                if(vehicles.get(i).isParking())
                {
                    System.out.println((++j) + "- ID: " + (vehicles.get(i).getID() +1)
                            + ", Model Name : " + vehicles.get(i).getModelName()
                            + ", Model Year : " + vehicles.get(i).getModelYear()
                            + ", Width : " + vehicles.get(i).getWidth()
                            + ", Depth : " + vehicles.get(i).getDepth()
                            + ", Parked at : " + vehicles.get(i).getDateAndTimeIn()) ;

                    ParkingVehicles.addLast(vehicles.get(i));
                }
            }
            System.out.println("\nType The Number Beside the Vehicle you want to Park out OR Type 0 to Cancel!");

            Scanner input = new Scanner(System.in);
            int parkingOutChoice = input.nextInt();

            while(parkingOutChoice < 0 || parkingOutChoice < j)
            {
                System.out.println("Invalid Index, Try Again!");
            }

            if(parkingOutChoice == 0)
            {
                return;
            }
            else
            {
                Controller.ParkOut(ParkingVehicles.get(parkingOutChoice - 1).getID(), g);
            }
        }
    }
}
