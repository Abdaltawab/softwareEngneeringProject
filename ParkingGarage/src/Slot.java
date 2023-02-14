public class Slot
{
    private int ID;
    private double width;
    private double depth;
    private boolean empty;

    public Slot(int index, double Width, double Depth)
    {
        ID = index;
        width = Width;
        depth = Depth;
        empty = true;
    }

    //------------------------
    // -------Setters---------
    //------------------------

    public void setWidth(double Width) {
        width = Width;
    }

    public void setDepth(double Depth) {
        depth = Depth;
    }

    public void setEmpty(boolean status)
    {
        empty = status;
    }

    //------------------------
    // -------Getters---------
    //------------------------

    public int getID()
    {
        return ID;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public boolean isEmpty()
    {
        return empty;
    }
}
