/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package RestfulSortArray;

import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import java.util.Arrays;

/**
 * REST Web Service
 *
 * @author Asus
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    @EJB
    data obj = new data();
 
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of RestSortArray.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.TEXT_PLAIN)
    public String getHtml() {
        //TODO return proper representation object
        return obj.get();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.TEXT_PLAIN)

    public void putHtml(String content) {
        String[] splitArray = content.split(" ");
        int[] array = new int[splitArray.length];
 
        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        for(int i=0;i<splitArray.length-1;i++){
            for(int j=0;j<splitArray.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        obj.put("<html><body><h1 style=\"color:blue\">Lab Assessment 3: Adnan Sattikar 20MIC0124<br>Sorted Array: " +Arrays.toString(array)+"</h1></body></html>");
    }
}
