package fr.polytech.TPRest.Servlet;

import fr.polytech.TPRest.Servlet.DBManager.WarframeManager;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class HelloServlet extends HttpServlet {

    private static List<Warframe> warframes;
    static{
        warframes = new ArrayList<>();
    }

    @POST
    @Path("/warframes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Warframe createWarframe(Warframe warframe)
    {
        WarframeManager wm = new WarframeManager();
        return wm.create(warframe);
    }
    
    @PUT
    @Path("/warframes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Warframe updateWarframe(Warframe warframe)
    {
        WarframeManager wm = new WarframeManager();
        return wm.update(warframe);
    }

    @GET
    @Path("/warframes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Warframe> getWarframe(){
        WarframeManager wm = new WarframeManager();
        return wm.getAll();
    }
    @DELETE
    @Path("/warframes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteWarframe(Warframe warframe) {
        WarframeManager wm = new WarframeManager();
        return wm.delete(warframe);
    }
}