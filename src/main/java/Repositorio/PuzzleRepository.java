/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Puzzle;
import Red.BaseDeDatos;
import Test.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN JOSE
 */
public class PuzzleRepository implements IPuzzleRepository {

    @Override
    public List<Puzzle> consultar() {
        List<Puzzle> puzzles = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id, puzzle_id, fen, moves, rating, rating_deviation, popularity, nb_plays, themes, game_url, opening_tags FROM puzzles";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String puzzleId = resultado.getString("puzzle_id");
                String fen = resultado.getString("fen");
                Stack<String> moves = new Stack();
                String allMoves = resultado.getString("moves");
                StringBuilder current = new StringBuilder();
                for (int i = 0; i < allMoves.length(); i++) {
                    char c = allMoves.charAt(i);
                    if (c == ' ') {
                        moves.push(current.toString());
                        current.setLength(0);
                    } else {
                        current.append(c);
                    }
                }
                moves.push(current.toString());
                int rating = resultado.getInt("rating");
                int ratingDeviation = resultado.getInt("rating_deviation");
                int popularity = resultado.getInt("popularity");
                int nbPlays = resultado.getInt("nb_plays");
                String themes = resultado.getString("themes");
                String gameUrl = resultado.getString("game_url");
                String openingTags = resultado.getString("opening_tags");
                Puzzle puzzle = new Puzzle(id, puzzleId, fen, moves, rating, ratingDeviation, popularity, nbPlays, themes, gameUrl, openingTags);
                puzzles.add(puzzle);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PuzzleRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return puzzles;
    }

    @Override
    public Puzzle consultarId(Puzzle puzzle) {
        Puzzle r = null;
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id, puzzle_id, fen, moves, rating, rating_deviation, popularity, nb_plays, themes, game_url, opening_tags FROM puzzles WHERE id= ?";
            sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, puzzle.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String puzzleId = resultado.getString("puzzle_id");
            String fen = resultado.getString("fen");
            Stack<String> moves = new Stack();
            String allMoves = resultado.getString("moves");
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < allMoves.length(); i++) {
                char c = allMoves.charAt(i);
                if (c == ' ') {
                    moves.push(current.toString());
                    current.setLength(0);
                } else {
                    current.append(c);
                }
            }
            moves.push(current.toString());
            int rating = resultado.getInt("rating");
            int ratingDeviation = resultado.getInt("rating_deviation");
            int popularity = resultado.getInt("popularity");
            int nbPlays = resultado.getInt("nb_plays");
            String themes = resultado.getString("themes");
            String gameUrl = resultado.getString("game_url");
            String openingTags = resultado.getString("opening_tags");
            r = new Puzzle(id, puzzleId, fen, moves, rating, ratingDeviation, popularity, nbPlays, themes, gameUrl, openingTags);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PuzzleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PuzzleRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }

}
