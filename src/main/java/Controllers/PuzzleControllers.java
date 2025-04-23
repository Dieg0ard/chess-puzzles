/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entity.Puzzle;
import Services.PuzzleServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author JUAN JOSE
 */
@Path("puzzles")
public class PuzzleControllers {
    PuzzleServices puzzleServices = new PuzzleServices();
//http://localhost:8080/chess-puzzles/resources/puzzles/todospuzzles Link para consultar todos los puzzles
    @GET
    @Path("todospuzzles")
    public Response consultar() {
        List<Puzzle> puzzles = puzzleServices.consultar();
        return Response
                .ok(puzzles)
                .build();
    }
//http://localhost:8080/chess-puzzles/resources/puzzles/puzzleid/{id} Link para consultar por id
    @GET
    @Path("puzzleid/{id}")
    public Response consultarID(@PathParam("id") int id) {
        Puzzle puzzle = new Puzzle(id);
        return Response
                .ok()
                .entity(puzzleServices.consultarId(puzzle))
                .build();

    }
}
