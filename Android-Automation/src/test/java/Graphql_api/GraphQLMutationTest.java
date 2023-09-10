package Graphql_api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GraphQLMutationTest {

    public static String[] getBackgroundMusicName(String accessToken,String subcategoryId)
    {
        RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";
        String query = "query backgroundmusic{\n" +
                "  getTracks(searchAndFilterArgs:{subCategoryId:\"" + subcategoryId + "\",usage:\"background_music\"})\n" +
                "  {\n" +
                "    tracks{\n" +
                "      title\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Create the request body as JSON
        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("query", query);
        String requestBody = requestBodyJson.toString();

        // Send the POST request and retrieve the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(requestBody)
                .post();

        // Extract the response body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        // Extract the titles from the response
        JsonPath jsonPath = new JsonPath(responseBody);
        ArrayList<String> titlesList = jsonPath.get("data.getTracks.tracks.title");

        // Convert ArrayList to String array
        String[] titles = titlesList.toArray(new String[0]);
        return titles;
    }


    public static String getSubcategoriesID(String accessToken) {
        RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";
        String query = "query getsubcategoriesid{\n" +
                " getSubCategoriesFromTracks(paginationInput:{},usage:\"background_music\")\n" +
                "  {\n" +
                "    categories{\n" +
                "      categoryName\n" +
                "      id\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Create the request body as JSON
        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("query", query);
        String requestBody = requestBodyJson.toString();

        // Send the POST request and retrieve the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(requestBody)
                .post();

        // Extract the response body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        // Extract the ID of the first category from the response
        JsonPath jsonPath = new JsonPath(responseBody);
        String categoryId = jsonPath.getString("data.getSubCategoriesFromTracks.categories[0].id");
        System.out.println("First Category ID: " + categoryId);
        return categoryId;
    }

    public static String[] getSubcategoriesID1(String accessToken) {
        RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";
        String query = "query getsubcategoriesid{\n" +
                " getSubCategoriesFromTracks(paginationInput:{},usage:\"background_music\")\n" +
                "  {\n" +
                "    categories{\n" +
                "      categoryName\n" +
                "      id\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Create the request body as JSON
        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("query", query);
        String requestBody = requestBodyJson.toString();

        // Send the POST request and retrieve the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(requestBody)
                .post();

        // Extract the response body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        // Extract the ID of the first category from the response
        JsonPath jsonPath = new JsonPath(responseBody);
        String categoryId = jsonPath.getString("data.getSubCategoriesFromTracks.categories[1].id");
        String categoryName=jsonPath.getString("data.getSubCategoriesFromTracks.categories[1].categoryName");
        System.out.println("First Category ID: " + categoryId);
        String[] results = new String[2];
        results[0] = categoryId;
        results[1] = categoryName;
        return results;
    }



    public static String verifyUser(String emails) {
        System.out.println(emails);
        RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";
        JSONObject requestParams = new JSONObject();
        requestParams.put("query", String.format("{validatePaymentSubscription(email:\"%s\",firstName:\"sauggg\",lastName:\"happ\",password:\"Kathmandu@123\",subscriptionOffer:{name:\"sssf\"})\n}", emails));
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestParams.toString())
                .post();
        System.out.println(response.getBody().asString());
        String messages = response.jsonPath().getString("data.validatePaymentSubscription");
        System.out.println(messages);
        return  messages;

    }

    public static String getAcessToken() {
        RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";

        // GraphQL query
        String query = "query { " +
                "  login(loginInputDto: {username: \"saugst621@clickandpress.com\", password: \"Kathmandu@123\"}) { " +
                "    access_token " +
                "  } " +
                "}";

        // Send the GraphQL request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"query\": \"" + query.replace("\"", "\\\"") + "\"}")
                .post();

        // Extract the access token from the response
        System.out.println(response.getBody().asString());
        String accessToken = response.jsonPath().getString("data.login.access_token");
        System.out.println("Access Token: " + accessToken);
        return accessToken;

    }

        public static String[] getTracksFromSession(String accessToken) {
            String id = "ec7cce2b-1cfd-4061-b3e9-86d364d7d04f";
            RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";
            JSONObject requestParams = new JSONObject();
            requestParams.put("query", String.format("{getSessionTracks(sessionId:\"%s\",paginationInput:{})\n" +
                    "  \n" +
                    "  {\n" +
                    "    sessionTrack{\n" +
                    "     order\n"+
                    "      track{\n" +
                    "        title\n" +
                    "      }\n" +
                    "    }\n" +
                    "    meta{\n"+
                    "     total\n"+
                    "    }\n" +
                    "  }\n}", id));
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + accessToken)
                    .body(requestParams.toString())
                    .post();
            System.out.println(response.getBody().asString());

            JSONObject responseData = new JSONObject(response.getBody().asString());
            JSONObject data = responseData.getJSONObject("data");
            JSONObject getSessionTracks = data.getJSONObject("getSessionTracks");
            JSONArray sessionTrackArray = getSessionTracks.getJSONArray("sessionTrack");

            TreeMap<Integer, String> titleMap = new TreeMap<>();

            for (int i = 0; i < sessionTrackArray.length(); i++) {
                JSONObject sessionTrackObject = sessionTrackArray.getJSONObject(i);
                int order = sessionTrackObject.getInt("order");
                JSONObject trackObject = sessionTrackObject.getJSONObject("track");
                String title = trackObject.getString("title");
                titleMap.put(order, title);
            }

            // Extract the titles from the TreeMap in ascending order
            List<String> titleList = new ArrayList<>(titleMap.values());

            // Convert the list of track titles to a String array
            String[] titles = titleList.toArray(new String[0]);

            return titles;
        }

        public static void getTracksMenifest()
        {
            // Set the base URL for the GraphQL endpoint
            String baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";

            // Define the access token
            String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjcyMDdjZjI3LTE1MzUtNGJhOS05NjQ5LThjMGM4YTIwOWFjNCIsImZpcnN0TmFtZSI6InNhdWdhdCIsIm1pZGRsZU5hbWUiOm51bGwsImxhc3ROYW1lIjoicGF1ZGVsIiwiZW1haWwiOiJzYWhhckBjbGlja2FuZHByZXNzLmNvbSIsInVzZXJUeXBlIjoiY3VzdG9tZXIiLCJpYXQiOjE2ODg2NjEyNjIsImV4cCI6MTY4ODY2NDg2Mn0.4dg_aE1e_76Uq-Bh8AuF40DGJqyhNR9qc_c10XPIrU8";

            // Define the GraphQL query
            String query = "{ \"query\": \"query GetTracks { getTracks(searchAndFilterArgs:{limit:10}) { tracks { title storageKeys { manifestFileUrl } } } }\" }";

            // Send a POST request with the GraphQL query and access token
            Response response = RestAssured.given()
                    .header("Authorization", "Bearer " + accessToken)
                    .contentType("application/json")
                    .body(query)
                    .post(baseURI);

            // Retrieve the manifestFileUrl from the response
            List<String> manifestFileUrls = response.path("data.getTracks.tracks[*].storageKeys.manifestFileUrl");

            // Print the manifestFileUrls
            for (String url : manifestFileUrls) {
                System.out.println("Manifest File URL: " + url);
            }
        }
}












