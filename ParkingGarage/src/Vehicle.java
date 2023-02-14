import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Vehicle
{
    private String modelName;
    private int modelYear;
    private int ID;
    private double width;
    private double depth;
    private boolean parking;
    private String dateAndTimeIn;
    private String dateAndTimeOut;

    public Vehicle(String ModelName, int ModelYear, int id, double Width, double Depth)
    {
        modelName = ModelName;
        modelYear = ModelYear;
        ID = id;
        width = Width;
        depth = Depth;
        parking = false;
    }

    //------------------------
    // -------Setters---------
    //------------------------

    public void setModelName(String Name)
    {
        modelName = Name;
    }

    public void setModelYear(int Year)
    {
        modelYear = Year;
    }

    public void setID(int id)
    {
        ID = id;
    }

    public void setWidth(double Width)
    {
        width = Width;
    }

    public void setDepth(double Depth)
    {
        depth = Depth;
    }

    public void setParking(boolean p)
    {
        parking = p;
    }

    public void setDateAndTimeIn() {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dateAndTimeIn = dtf1.format(now);
    }

    public void setDateAndTimeOut() {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dateAndTimeOut = dtf2.format(now);
    }

    //------------------------
    // -------Getters---------
    //------------------------

    public String getModelName()
    {
        return modelName;
    }

    public int getModelYear()
    {
        return modelYear;
    }

    public int getID()
    {
        return ID;
    }

    public double getWidth()
    {
        return width;
    }

    public double getDepth()
    {
        return depth;
    }

    public boolean isParking() {
        return parking;
    }

    public String getDateAndTimeIn() {
        return dateAndTimeIn;
    }

    public String getDateAndTimeOut() {
        return dateAndTimeOut;
    }
}
