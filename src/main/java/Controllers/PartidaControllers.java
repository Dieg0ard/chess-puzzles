/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entity.Partida;
import Services.PartidaServices;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static java.lang.Integer.parseInt;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JUAN JOSE
 */
@Path("partidas")
public class PartidaControllers {

    PartidaServices partidaServices = new PartidaServices();

    @GET
    @Path("todaspartidas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Partida> partidas = partidaServices.consultar();
        return Response
                .ok(partidas)
                .build();
    }   
    @GET
    @Path("todosresueltos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarResueltos() {
        List<Partida> partidas = partidaServices.consultarResueltos();
        return Response
                .ok(partidas)
                .build();
    }   
    @GET
    @Path("todosintentados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarIntentados() {
        List<Partida> partidas = partidaServices.consultarIntentados();
        return Response
                .ok(partidas)
                .build();
    }   

    @GET
    @Path("partida/{perfil_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPartida(@PathParam("perfil_id") int id) {
        Partida partida = new Partida(id);
        return Response
                .ok()
                .entity(partidaServices.consultarPartida(partida))
                .build();

    }
    @GET
    @Path("perfilresueltos/{perfil_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarResueltosPerfil(@PathParam("perfil_id") int id) {
        Partida partida = new Partida(id);
        return Response
                .ok()
                .entity(partidaServices.consultarResueltosPerfil(partida))
                .build();

    }
    @GET
    @Path("perfilintentados/{perfil_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarIntentadosPerfil(@PathParam("perfil_id") int id) {
        Partida partida = new Partida(id);
        return Response
                .ok()
                .entity(partidaServices.consultarIntentadosPerfil(partida))
                .build();

    }
    @DELETE
    @Path("eliminar/{perfil_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("perfil_id") int perfilId) throws ParseException {
        Partida partida = new Partida(perfilId);
        int registro = partidaServices.eliminar(partida);
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
    @Path("insertar/{puzzle_id}/{perfil_id}/{puzzle_resuelto}/{fecha_intento}/{tiempo_intento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@PathParam("puzzle_id") int puzzleId,
            @PathParam("perfil_id") int perfilId,
            @PathParam("fecha_intento") String fechaIntentoStr,
            @PathParam("puzzle_resuelto") boolean puzzleResuelto,
            @PathParam("tiempo_intento") String tiempoIntentoStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date fechaIntento = dateFormat.parse(fechaIntentoStr);
        int totalSegundos=parseInt(tiempoIntentoStr);
        int horas=totalSegundos/3600;
        int minutos=(totalSegundos%3600)/60;
        int segundos=totalSegundos%60;
        String tiempoFormato=String.format("%02d:%02d:%02d",horas,minutos,segundos);
        Time tiempo = Time.valueOf(tiempoFormato);
        LocalTime tiempoIntento=tiempo.toLocalTime();
        Partida partida = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
        int registro = partidaServices.insertar(partida);
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
