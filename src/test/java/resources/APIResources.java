package resources;



// enum is a special type of java class which has collection of constant and methods
public enum APIResources 
{
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	



         APIResources(String resource) 
{
	this.resource=resource;
}
         
         public String getResource()
         {
        	 return resource;
         }






}
