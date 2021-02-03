package fr.polytech.TPRest.Servlet;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloServlet extends HttpServlet {

    @GET
    @Path("sayHello")
    public String sayHello() {

        return "hello";
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(){
        Person perso1 = new Person("Lulu" , "Cuoco");
        return Response.ok().entity(perso1).build();
    }

    @PUT
    @Path("put")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    //poke

    private static List<Pokemon> pokemons;
    static {
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Gengar", 100));
        pokemons.add(new Pokemon(2, "Charizard", 85));
        pokemons.add(new Pokemon(3, "Mudkip", 15));

    }

    @GET
    @Path("getPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoke() {
        return Response.ok().entity(pokemons).build();
    }

    @POST
    @Path("postPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return Response.ok().entity(pokemon).build();
    }

    // PUT Thibou a dit de pas le faire

    @DELETE
    @Path("delPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delPokemon(Pokemon pokemon){
        return Response.ok().entity(pokemon).build();
    }

}



