/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entity.Rating;
import Services.RatingServices;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Path("ratings")
public class RatingController {
    
    RatingServices ratingServices = new RatingServices();

    @GET
    @Path("todosratings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Rating> ratings = ratingServices.consultar();
        return Response
                .ok(ratings)
                .build();
    }

    @GET
    @Path("ratingid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Rating rating = new Rating(id,0);
        return Response
                .ok()
                .entity(ratingServices.consultarId(rating))
                .build();
    }

    @DELETE
    @Path("ratingid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        Rating rating = new Rating(id,0);
        int registro = ratingServices.eliminar(rating);
        if (registro == 0) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
    }
    
    @POST
    @Path("ratingvalor/{valor}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response crear(@PathParam("valor") int valor){
         Rating rating = new Rating(0 ,valor);
         int registro = ratingServices.insertar(rating);
         if (registro == 0) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
         
    }
         
    @PUT
    @Path("ratingid/{nuevo_valor}/{idcambiar}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response actualizar(@PathParam("nuevo_valor") int valor, @PathParam("idcambiar") int id )   {
          Rating Rating = new Rating(id ,valor);
          int registro =  ratingServices.actualizar(Rating);
         if (registro == 0) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
        
    } 
    
    
    
}
