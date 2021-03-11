import com.google.gson.Gson;

public class JsonToObject {
  /**  public static void main(String[] args)
    {
        // Creating object of Organisation
       Pojo org = new Pojo();

        // Converting json to object
        org = getOrganisationObject();


        // Displaying object
        System.out.println(org);
    } */

    private static Pojo getOrganisationObject()
    {
        // Storing preprocessed json(Added slashes)
        String OrganisationJson
                = "{\"Make_Name\" : \"Make_Name\"}";
        //\"Make_ID\" : \"Make_ID\"}";

        // Creating a Gson Object
        Gson gson = new Gson();

        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class
        Pojo organisation
                = gson.fromJson(OrganisationJson,
                Pojo.class);

        // return object
        return organisation;
    }
}
