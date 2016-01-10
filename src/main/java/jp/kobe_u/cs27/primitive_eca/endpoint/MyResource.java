package jp.kobe_u.cs27.primitive_eca.endpoint;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.hk2.api.Unproxiable;

import jp.kobe_u.cs27.primitive_eca.model.EventModel;
import jp.kobe_u.cs27.primitive_eca.webapi.EventController;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {
	private EventController eventController;
	public MyResource() {
		eventController = new EventController();
	}
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value="test")
    public Response getEvent(@PathParam("id") final String eid){
    	EventModel emList = eventController.getOneEvent();
    	
    	System.out.println(emList.getId());
		return Response.ok().entity(emList).build();
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value="events")
    public Response getEvents(@PathParam("id") final String eid){
    	EventModel emList = eventController.getOneEvent();
    	
//    	GenericEntity<List<EventModel>> result = new GenericEntity<List<EventModel>>(emList){};
    	
		return Response.ok().entity(emList).build();
    }
    
    
    
}
