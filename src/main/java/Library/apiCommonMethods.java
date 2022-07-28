package Library;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiCommonMethods extends extentReport {
    private RequestSpecification httpRequest = null;
    private Response response = null;

    public void initializeAPI(final String api) {
        try {
            RestAssured.baseURI = api;
            this.httpRequest = RestAssured.given();
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
    }

    public Response sendRequest(final String requestMethod) {

        try {
            response = switch (requestMethod.toUpperCase()) {
                case "GET":
                    yield httpRequest.request(Method.GET, "");
                case "POST":
                    yield httpRequest.request(Method.POST, "");
                case "DELETE":
                    yield httpRequest.request(Method.DELETE, "");
                default:
                    yield null;
            };
        } catch (Exception e) {
            failTest(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
