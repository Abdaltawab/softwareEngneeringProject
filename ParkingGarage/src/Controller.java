public class Controller
{
    static public int parkIn(Garage g, Vehicle v)
    {
        if (g.getParkingVehicles().contains(v))
        {
            return -1;
        }
        else
        {
            if(g.isFirstComesFirstServedSlots())
            {
                int i;
                int j = -2;

                for(i = 0; i < g.getNumOfTotalSlots(); i++)
                {
                    if(g.getSlotByIndex(i).isEmpty())
                    {
                        Slot s = g.getSlotByIndex(i);
                        s.setEmpty(false);
                        g.decreaseFreeSlots();

                        v.setParking(true);

                        g.addToParkingVehicles(v);

                        v.setDateAndTimeIn();

                        j = i;

                        break;
                    }
                }
                return j;
            }
            else
            {
                int i;
                int j = -1;

                for(i = 0; i < g.getNumOfTotalSlots(); i++)
                {
                    if(g.getSlotByIndex(i).getWidth() >= v.getWidth() &&
                        g.getSlotByIndex(i).getDepth() >= v.getDepth())
                    {
                        Slot s = g.getSlotByIndex(i);
                        s.setEmpty(false);
                        g.decreaseFreeSlots();

                        v.setParking(true);

                        g.addToParkingVehicles(v);

                        v.setDateAndTimeIn();
                        g.getParkingSlotsForVehicles().addLast(s);

                        j = i;

                        break;
                    }
                }
                return j;
            }
        }
    }

    static public boolean ParkOut(int id, Garage g)
    {
        for( int i = 0; i < g.getParkingVehicles().size(); i++)
        {
            if(g.getParkingVehicles().get(i).getID() == id)
            {
                g.getParkingVehicles().get(i).setDateAndTimeOut();
                g.getParkingVehicles().get(i).setParking(false);

                g.getParkingVehicles().remove(i);
                g.getParkingSlotsForVehicles().get(i).setEmpty(true);
                g.getParkingSlotsForVehicles().remove(i);

                //duration

                return true;


            }
        }
        return true;
    }
}
