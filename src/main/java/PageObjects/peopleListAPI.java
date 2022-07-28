package PageObjects;

import Library.apiCommonMethods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;

public class peopleListAPI extends apiCommonMethods {
    private Response response = null;

    @BeforeTest
    public void init() {
        initializeReport();
    }

    @Test
    public void initializeTest(final String api) {

        initializeAPI(api);
        passTest("API initialized");

    }

    @Test
    public void sRequest(final String requestMethod) {
        response = sendRequest(requestMethod);
        passTest(requestMethod + " request sent");
    }

    @Test
    public void confirmResponse(String name, String skinColor) {
        boolean res = false;
        try {
            if (response.getStatusCode() == 200) {
                passTest("Response returned:\n" + response.prettyPrint());
                JsonPath j = new JsonPath(response.getBody().asString());

                //get values of JSON array after getting array size
                int s = j.getInt("results.size()");
                for (int i = 0; i < s; i++) {
                    String pName = j.getString("results[" + i + "].name");
                    String sColor = j.getString("results[" + i + "].skin_color");
                    if ((Objects.equals(pName, name)) && (Objects.equals(sColor, skinColor))) {
                        passTest("Person: " + pName + " skin color is: " + sColor);
                        res = true;
                        break;
                    }
                }

                if (!res)
                    failTest("Related data does not exist");

            } else
                failTest("Response status code is not 200 : " + response.getStatusCode());
            endReport();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
