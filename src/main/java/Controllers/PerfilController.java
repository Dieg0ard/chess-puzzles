/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entity.Perfil;
import Services.PerfilServices;
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
@Path("perfiles")
public class PerfilController {
       PerfilServices perfilServices = new PerfilServices();

    @GET
    @Path("todosperfiles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Perfil> perfiles = perfilServices.consultar();
        return Response
                .ok(perfiles)
                .build();
    }

    @GET
    @Path("perfilid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Perfil perfil = new Perfil(id);
        return Response
                .ok()
                .entity(perfilServices.consultarId(perfil))
                .build();
    }

    @DELETE
    @Path("perfilid/{id}")    //usuario_id
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
         Perfil perfil = new Perfil(id);
        int registro = perfilServices.eliminar(perfil);
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
    @Path("usuario/{id_usuario}/{id_rating}")   //pasa el id del usuario y su rating
    @Produces(MediaType.APPLICATION_JSON) 
    public Response crear(@PathParam("id_usuario") int id_usuario,  @PathParam("id_rating") int id_rating){
         
        Perfil perfil = new Perfil(id_usuario,id_rating);
         int registro = perfilServices.insertar(perfil);
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
    @Path("perfilid/{rating_nuevo}/{id_usuario_modificar}")   //pasa el id  tanto del usuario como del rating
    @Produces(MediaType.APPLICATION_JSON) 
    public Response actualizar(@PathParam("rating_nuevo") int rating, @PathParam("id_usuario_modificar") int id )   {
          Perfil perfil = new Perfil(id ,rating);
          int registro =  perfilServices.actualizar(perfil);
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
