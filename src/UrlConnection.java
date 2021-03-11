import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class UrlConnection{

    private static int mfrID = 955;


    public static int getMfrID() {
        return mfrID;
    }

    public static void setMfrID(int mfrID) {
        UrlConnection.mfrID = mfrID;
    }
        private static String makeName = String.valueOf(mfrID) ;

        public static String[] getHostList() {
        return HostList;
        }

        public static void setHostList(String[] hostList) {
        HostList = hostList;
        }

        private static String[] HostList = new String[100];
        private static int nameCounter = 0;

        public static String getMakeName(){
            return makeName;
        }

        public static void setMakeName(String makeName) {
        UrlConnection.makeName = makeName;
    }

        private static final String USER_AGENT = "Mozilla/5.0";

        private static final String GET_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/GetAllMakes?format=json";

        private static  final String GET_URL_GET_MANUFACTURING_DETAILS = "https://vpic.nhtsa.dot.gov/api/vehicles/GetManufacturerDetails/";// +  makeName  + "?format=json";

        private static final String POST_URL = "";

        private static final String POST_PARAMS = "userName=Pankaj";

        public static void main(String[] args) throws IOException {




            Long start = System.currentTimeMillis();
            for(int i = 0; i<100; i++){
                getGetUrlGetManufacturingDetails();
                setMakeName(String.valueOf(mfrID));
                setMfrID(mfrID++);
                mfrID++;

                System.out.println(mfrID +" "+ makeName);

            }

            Long end = System.currentTimeMillis();

            System.out.println("Time needed to run: " + (end-start) + " milliseconds");
            System.out.println("GET SHIT DONE");
          //sendGETRetrievesManNames();
            System.out.println("Top 1OO manufacturers Names");
            //  sendPOST();
            System.out.println("POST DONE");
        }

        private static void sendGET() throws IOException {
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                Gson gson = new Gson();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                ManufacturerResponse userArray = gson.fromJson(response.toString(), ManufacturerResponse.class);
                for(Pojo user : userArray.getResults()) {
                    System.out.println(user);
                    System.out.println();
                }
            } else {
                System.out.println("GET request not worked");
            }
        }

    private static String sendGETRetrievesManNames() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            Gson gson = new Gson();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            ManufacturerResponse userArray = gson.fromJson(response.toString(), ManufacturerResponse.class);
            ArrayList<Pojo> user = userArray.getResults();


                System.out.println(userArray.getResults().get(nameCounter).getMake_Name());
               // System.out.println(makeName + "alpha");
                setMakeName(userArray.getResults().get(nameCounter).getMake_Name());
              //  System.out.println(makeName+ "beta");
            System.out.println(makeName);
            //nameCounter++;

            return userArray.getResults().get(nameCounter).getMake_Name();


        } else {
            return "GET request not worked";

        }
    }
        /*
        url no cambiaba, no sabia porque
        porque es una variable estatica solo se asigna una vez al principio y ya no cambia
         */
        private static void getGetUrlGetManufacturingDetails() throws IOException{
            System.out.println(GET_URL_GET_MANUFACTURING_DETAILS);
            String url = GET_URL_GET_MANUFACTURING_DETAILS + makeName +"?format=json";
            HostList[]
            System.out.println(url);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                Gson gson = new Gson();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
               // System.out.println(response);
                ManufacturersDetailsResponse arrayObj = gson.fromJson(response.toString(), ManufacturersDetailsResponse.class);

                for(ManufacturerDetails Obj : arrayObj.getResults()) {
                    System.out.println(Obj);
                    System.out.println();
                }

            }
        }

        private static void sendPOST() throws IOException {
            URL obj = new URL(POST_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;



                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("POST request not worked");
            }
        }

}
