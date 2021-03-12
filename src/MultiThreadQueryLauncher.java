import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MultiThreadQueryLauncher {


    private static final String USER_AGENT = "Mozilla/5.0";
    public String[] getHostList2() {
        return hostList2;
    }

    public void setHostList2(String[] hostList2) {
        this.hostList2 = hostList2;
    }

    private static String[] hostList2 = new String[100];

    public static int getIterator() {
        return iterator;
    }

    public static void setIterator(int iterator) {
        MultiThreadQueryLauncher.iterator = iterator;
    }

    private static int iterator = 955;

    private static final int MyTheads = 100;

    public static void main(String args[]) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(MyTheads);
        makeHostList();

        for (int i = 0; i < 100; i++) {
            System.out.println(hostList2[i]);
        }
        Long start = System.currentTimeMillis();
        for (int i = 0; i < hostList2.length; i++) {
            String url = hostList2[i];
            Runnable worker = new MyRunnable(url, i);
            executor.execute(worker);
            System.out.println(worker);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {

        }
        System.out.println("\nFinished all threads");
        Long end = System.currentTimeMillis();
        System.out.println("Time needed to run: " + (end-start) + " milliseconds");

    }

   public static void multiThreading(int i) throws IOException {
    URL obj = new URL(hostList2[i]);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
    int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK)

    { // success
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


        for (ManufacturerDetails Obj : arrayObj.getResults()) {
            System.out.println(Obj.toString());
            System.out.println();
        }
    }

    }




    public static void makeHostList() {

        for (int i = 0; i < 100; i++) {
            hostList2[i] = UrlConnection.getGetUrlGetManufacturingDetails() + iterator + "?format=json";
            setIterator(iterator + 1);
        }
    }


    public static class MyRunnable implements Runnable {
        private final String url;

        MyRunnable(String url, int i) throws IOException {
            this.url = url;
            multiThreading(i);
        }

        @Override
        public void run() {

        }
    }
}




