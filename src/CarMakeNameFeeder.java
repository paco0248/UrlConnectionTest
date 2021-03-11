import java.util.ArrayList;

public class CarMakeNameFeeder {
    private String CarMakeNAme;
    ArrayList<String> makeCarList = new ArrayList();

    public ArrayList<String> getMakeCarList() {
        return makeCarList;
    }

    public void setMakeCarList(ArrayList<String> makeCarList) {
        this.makeCarList = makeCarList;
    }




    public String getCarMakeNAme() {
        return CarMakeNAme;
    }

    public void setCarMakeNAme(String carMakeNAme) {
        CarMakeNAme = carMakeNAme;
    }
}
