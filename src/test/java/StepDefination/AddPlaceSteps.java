package StepDefination;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;








import io.cucumber.java.en.*;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class AddPlaceSteps extends Utils
{
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response responce;
	TestDataBuild data=new TestDataBuild();
	
	
	 @Given("Add place Payload with {string} {string} {string}")
		public void add_place_payload_with(String name, String language, String address) throws Exception
	{
		// write code here to that turn the phase above into concrete actions
		
	      resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			res=given().spec(requestSpecfications())
				.body(data.addPlacePayLoad(name, language, address));

	}

	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String resource) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
	  responce = res.when().post(resourceAPI.getResource())
	    .then().spec(resspec).extract().response();
	}

	@And("the API call is sucess with status code {int}")
	public void the_api_call_is_sucess_with_status_code(Integer int1) 
	{
		assertEquals(responce.getStatusCode(),200);
		
	    
	}

	@Then("and {string} in responce body should be {string}")
	public void and_in_responce_body_should_be(String key, String value) 
	{
	    String req=responce.asString();
	    JsonPath js=new JsonPath(req);
	    assertEquals(js.get(key).toString(), value);
	}


}
