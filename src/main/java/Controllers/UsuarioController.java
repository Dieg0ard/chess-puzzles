/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entity.Usuario;
import Services.UsuarioServices;
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
@Path("usuarios")
public class UsuarioController {
    
     UsuarioServices usuarioServices = new UsuarioServices();

    @GET
    @Path("todosusuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Usuario> tiposDocumentos = usuarioServices.consultar();
        return Response
                .ok(tiposDocumentos)
                .build();
    }

    @GET
    @Path("usuarioid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Usuario usuario = new Usuario(id);
        return Response
                .ok()
                .entity(usuarioServices.consultarId(usuario))
                .build();
    }

    @DELETE
    @Path("usuarioid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
         Usuario usuario = new Usuario(id);
        int registro = usuarioServices.eliminar(usuario);
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
    @Path("usuario/{nombre_usuario}/{nombre_real}/{correo}/{clave}/{nivel_ajedrez}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response crear(@PathParam("nombre_usuario") String nombreUsuario,
                                            @PathParam("nombre_real") String nombreReal,
                                            @PathParam("correo") String correo,
                                            @PathParam("clave") String clave,
                                            @PathParam("nivel_ajedrez") int nivelAjedrez){
         Usuario usuario = new Usuario(nombreUsuario,nombreReal,correo,clave,nivelAjedrez);
         int registro = usuarioServices.insertar(usuario);
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
    @Path("usuarioid/{nombre_usuario}/{idcambiar}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response actualizar(@PathParam("nombre_usuario") String nombre, @PathParam("idcambiar") int id )   {
          Usuario usuario = new Usuario(id ,nombre);
          int registro =  usuarioServices.actualizar(usuario);
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
