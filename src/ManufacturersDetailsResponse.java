import java.util.ArrayList;

public class ManufacturersDetailsResponse {
    private String Count;
    private String Message;
    private ArrayList<ManufacturerDetails> Results;

    public ArrayList<ManufacturerDetails> getResults() {
        return Results;
    }

    public void setResults(ArrayList<ManufacturerDetails> results) {
        Results = results;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }
    @Override
    public String toString(){
        return "ManufacturerDetails [ Address=" + Count  +
                " Address2=" + Message  + "]";

    }
}
