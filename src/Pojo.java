

public class Pojo {
    private String Make_Name;
    private int Make_ID;

    public String getMake_Name() {
        return Make_Name;
    }

    public void setMake_Name(String make_Name) {
        Make_Name = make_Name;
    }

    public int getMake_ID() {
        return Make_ID;
    }

    public void setMake_ID(int make_ID) {
        Make_ID = make_ID;
    }
    // Creating toString
    @Override
    public String toString() //Todo which one am i using??
    {
        return "Pojo [Make_Name="
                + Make_Name
                + ", Make_ID="
                + Make_ID + "]" ;
    }
}
