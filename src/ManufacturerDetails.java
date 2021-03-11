
public class ManufacturerDetails {

    private String Address;
    private String Address2;
    private String City;
    private String Mfr_CommonName;
    private int Mfr_ID;


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getMfr_CommonName() {
        return Mfr_CommonName;
    }

    public void setMfr_CommonName(String mfr_CommonName) {
        Mfr_CommonName = mfr_CommonName;
    }

    public int getMfr_ID() {
        return Mfr_ID;
    }

    public void setMfr_ID(int mfr_ID) {
        Mfr_ID = mfr_ID;
    }
    // Creating toString
    @Override
    public String toString(){
        return "ManufacturerDetails[ Address=" + Address + "," +
                " Address2=" + Address2 +
                ", City=" + City +
                ", Mfr_CommonName" + Mfr_CommonName +
                ", Mfr_ID" + Mfr_ID;
    }
}
