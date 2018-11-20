/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
//            // Specify the base URL to the RESTful web service
 RestAssured.baseURI = "https://dog.ceo/dog-api/documentation/";
// 
// // Get the RequestSpecification of the request that you want to sent
// // to the server. The server is specified by the BaseURI that we have
// // specified in the above step.
 RequestSpecification httpRequest = RestAssured.given();
      
 // Make a request to the server by specifying the method Type and the method URL.
 // This will return the Response from the server. Store the response in a variable.
 Response response = httpRequest.request(Method.GET, "https://dog.ceo/api/breeds/list/all");
 
 // Now let us print the body of the message to see what response
 // we have recieved from the server
 
 String responseBody = response.getBody().asString();
 JSONParser parser = new JSONParser();
JSONObject json = (JSONObject) parser.parse(responseBody);
 
 System.out.println("Response Body is =>  " + json);
 
// call expression method
 expressionRetriever();
 //initiate getSubBreed  method and list sub breed for retriever
 getSubBreed();
 //initiate getRandomimage method and list golden image
 getRandomImage(); 
 
   
    }
   public static void getSubBreed(){
       
            // Specify the base URL to the RESTful web service
 RestAssured.baseURI = "https://dog.ceo/dog-api/documentation/";
 
 // Get the RequestSpecification of the request that you want to sent
 // to the server. The server is specified by the BaseURI that we have
 // specified in the above step.
 RequestSpecification httpRequest = RestAssured.given();
 
 // Make a request to the server by specifying the method Type and the method URL.
 // This will return the Response from the server. Store the response in a variable.
 Response response = httpRequest.request(Method.GET, "https://dog.ceo/api/breed/retriever/list");
 
 // Now let us print the body of the message to see what response
 // we have recieved from the server
 String responseBody = response.getBody().asString();
 System.out.println("Response Body is =>  " + responseBody);
       
   }
   
   public static void getRandomImage(){
   
        RestAssured.baseURI = "https://dog.ceo/dog-api/documentation/";
 
 // Get the RequestSpecification of the request that you want to sent
 // to the server. The server is specified by the BaseURI that we have
 // specified in the above step.
 RequestSpecification httpRequest = RestAssured.given();
 
 // Make a request to the server by specifying the method Type and the method URL.
 // This will return the Response from the server. Store the response in a variable.
 Response response = httpRequest.request(Method.GET, "https://dog.ceo/api/breed/retriever-golden/images/random");
 
 // Now let us print the body of the message to see what response
 // we have recieved from the server
 String responseBody = response.getBody().toString();
 JSONObject jsonObj = new JSONObject();
//jsonObj.append(responseBody);
 System.out.println("Response Body is =>  " + responseBody);
   }
   public static void expressionRetriever(){
   
              // Specify the base URL to the RESTful web service
 RestAssured.baseURI = "https://dog.ceo/dog-api/documentation/";
 
 // Get the RequestSpecification of the request that you want to sent
 // to the server. The server is specified by the BaseURI that we have
 // specified in the above step.
 RequestSpecification httpRequest = RestAssured.given();
 
 // Make a request to the server by specifying the method Type and the method URL.
 // This will return the Response from the server. Store the response in a variable.
 Response response = httpRequest.request(Method.GET, "https://dog.ceo/api/breeds/list/all");
  // Retrieve the body of the Response
 ResponseBody body = response.getBody();
 // To check for sub string presence get the Response body as a String.
 // Do a String.contains
 String bodyAsString = body.asString();
 
 Assert.assertEquals(bodyAsString.toLowerCase().contains("retriever") /*Expected value*/, true /*Actual Value*/, "Response body contains retriever");
 System.out.println("Response Body is =>  " + "Contains Retriever");
 
}
  
}

