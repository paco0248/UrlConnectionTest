import com.google.gson.Gson;

import java.util.List;

public class PojoTest {


    public static void main(String[] args) {
        Gson gson = new Gson();
        Gson gson2 = new Gson();

        Pojo[] userArray = gson.fromJson("[{\"Make_Name\":\"raja\",\"Make_ID\":25},{\"Make_Name\":\"raja2\",\"Make_ID\":30}]", Pojo[].class);
        System.out.println("asdfsdf");
        for(Pojo user : userArray) {
            System.out.println(user);
        }

        /*ManufacturerDetails[] UserArray1 = gson2.fromJson("[{\"Make_Name\":\"raja\",\"Make_ID\":25},{\"Make_Name\":\"raja2\",\"Make_ID\":30}]", ManufacturerDetails[].class);
        for(ManufacturerDetails user2 : userArray) {
            System.out.println(user2);
        }*/

    }
}
