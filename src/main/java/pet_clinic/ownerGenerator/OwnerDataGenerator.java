package pet_clinic.ownerGenerator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class OwnerDataGenerator {
    JSONObject oneOwner;

    JSONParser parser = new JSONParser();

    Random random = new Random();
    public JSONObject randomDataFromJson() {

        try {
            Object obj2 = parser.parse(new FileReader("ownerData.json"));

            JSONArray ownerList = (JSONArray) obj2;
            oneOwner = (JSONObject) ownerList.get(random.nextInt(ownerList.size()));
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        return oneOwner;
    }
}
