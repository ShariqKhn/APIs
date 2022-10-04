package resources;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecfications() throws Exception
	{
		if(req==null)
		{
		 PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		 req =new RequestSpecBuilder().setBaseUri(getGlobalvalues("baseUrl")).addQueryParam("key", "qaclick123")
				 
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		 
		 return req;
		}
		return req;
	}
	
	
	
	public static String getGlobalvalues(String key) throws Exception
	{
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\APIFrameWork\\src\\test\\java\\resources\\global.properties");
		properties.load(fis);
		properties.getProperty("baseUrl");
		return properties.getProperty(key);
	}

}
