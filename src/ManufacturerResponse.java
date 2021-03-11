import java.util.ArrayList;

public class ManufacturerResponse {
    private String Count;
    private String Message;
    private ArrayList<Pojo> Results;


    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ArrayList<Pojo> getResults() {
        return Results;
    }

    public void setResults(ArrayList<Pojo> results) {
        Results = results;
    }

        // Creating toString
    @Override
    public String toString()
    {
        return "Pojo [Make_Name="
                + Count
                + ", Make_ID="
                + Message + "]" ;
    }
}
