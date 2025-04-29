/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Partida;
import Entity.Perfil;
import Entity.Puzzle;
import Entity.Partida;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PerfilRepository {

    public List<Perfil> consultar() {
        List<Perfil> perfiles = new ArrayList<>();
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "SELECT id_usuario, id_rating FROM  perfil ";
            PreparedStatement sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            
            while (resultado.next()) {    //las propiedades con las que se crea un perfil son el id del usuario (nombre y nivel ajedrez) junto al rating, puzzles resueltos e intentados se agregan luego
              
                int id_usuario = resultado.getInt("id_usuario");       //obtener nombre y nivel desde el id de la llave foranea
                String query = "SELECT nombre_usuario,nivel_ajedrez FROM  usuario WHERE id = ? ";
                PreparedStatement sentencia_segunda = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
                sentencia_segunda.setInt(1, id_usuario);
                ResultSet resultado_segundo = sentencia_segunda.executeQuery();
                resultado_segundo.absolute(1);
                int nivel_ajedrez = resultado_segundo.getInt("nivel_ajedrez");
                String nombreUsuario = resultado_segundo.getString("nombre_usuario");
                //a cada perfil, traer todos los puzzles que ha resuelto y los intentos , para intentos almazena en estructura tipo partida
                //para puzzle una estructura tipo puzzle
                
                int id_rating = resultado.getInt("id_rating");
                String query_segundo = "SELECT valor FROM  rating WHERE id = ? ";
                PreparedStatement sentencia_tercera = con.prepareStatement(query_segundo, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
                sentencia_tercera.setInt(1, id_rating);
                ResultSet resultado_tercero = sentencia_tercera.executeQuery();
                resultado_tercero.absolute(1);
                int rating = resultado_tercero.getInt("valor");
                //-----------------Consultar puzzles resueltos asociados-------------------------------
                Stack<Puzzle> puzzlesResueltos = new Stack<Puzzle>();
                String consultarResueltos = " SELECT id_puzzle FROM perfil_puzzles_resueltos WHERE id_perfil = ? ORDER BY fecha_intento DESC;";
                PreparedStatement sentencia_cuarta = con.prepareStatement(consultarResueltos);
                sentencia_cuarta.setInt(1, id_usuario);
                ResultSet resultadoResueltos = sentencia_cuarta.executeQuery();
                while (resultadoResueltos.next()) {
                    Puzzle puzzle = new Puzzle(resultadoResueltos.getInt("id_puzzle"));
                    puzzlesResueltos.add(puzzle);

                }
                  //-----------------Consultar puzzles intentados con fecha asociados---------------------------------------
                Stack<Partida> puzzlesIntentados = new Stack<Partida>();
                String consultarIntentados = " SELECT id_puzzle,fecha_intento FROM perfil_puzzles_intentados WHERE id_perfil = ? ORDER BY fecha_intento DESC;";
                PreparedStatement sentencia_quinta = con.prepareStatement(consultarIntentados);
                sentencia_quinta.setInt(1, id_usuario);
                ResultSet resultadoIntentados = sentencia_quinta.executeQuery();
                while (resultadoIntentados.next()) {
                    int idPuzzle = resultadoIntentados.getInt("id_puzzle");
                    Date fecha = resultadoIntentados.getDate("fecha_intento");
                    Partida partida = new Partida(idPuzzle,id_usuario, fecha);
                    puzzlesIntentados.add(partida);

                }

                Perfil perfil = new Perfil(id_usuario, nombreUsuario, nivel_ajedrez, rating, puzzlesResueltos, puzzlesIntentados, id_rating);
                perfiles.add(perfil);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perfiles;
    }

    public Perfil consultarId(Perfil perfilConsultar) {
        Perfil perfil = null;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "SELECT  id_usuario, id_rating FROM perfil WHERE id_usuario = ? ";
            PreparedStatement sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, perfilConsultar.getId());
            ResultSet resultado = sentencia.executeQuery();
            resultado.absolute(1);

            int id_usuario = resultado.getInt("id_usuario");       //obtener nombre y nivel desde el id de la llave foranea
            String query = "SELECT nombre_usuario,nivel_ajedrez FROM  usuario WHERE id = ? ";
            PreparedStatement sentencia_segunda = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia_segunda.setInt(1, id_usuario);
            ResultSet resultado_segundo = sentencia_segunda.executeQuery();
            resultado_segundo.absolute(1);
            int nivel_ajedrez = resultado_segundo.getInt("nivel_ajedrez");
            String nombreUsuario = resultado_segundo.getString("nombre_usuario");

            int id_rating = resultado.getInt("id_rating");
            String query_segundo = "SELECT valor FROM  rating WHERE id = ? ";
            PreparedStatement sentencia_tercera = con.prepareStatement(query_segundo, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia_tercera.setInt(1, id_rating);
            ResultSet resultado_tercero = sentencia_tercera.executeQuery();
            resultado_tercero.absolute(1);
            int rating = resultado_tercero.getInt("valor");
            
              //-----------------Consultar puzzles resueltos asociados-------------------------------
                Stack<Puzzle> puzzlesResueltos = new Stack<Puzzle>();
                String consultarResueltos = " SELECT id_puzzle FROM perfil_puzzles_resueltos WHERE id_perfil = ? ORDER BY fecha_intento DESC;";
                PreparedStatement sentencia_cuarta = con.prepareStatement(consultarResueltos);
                sentencia_cuarta.setInt(1, id_usuario);
                ResultSet resultadoResueltos = sentencia_cuarta.executeQuery();
                while (resultadoResueltos.next()) {
                    Puzzle puzzle = new Puzzle(resultadoResueltos.getInt("id_puzzle"));
                    puzzlesResueltos.add(puzzle);

                }
                  //-----------------Consultar puzzles intentados con fecha asociados---------------------------------------
                Stack<Partida> puzzlesIntentados = new Stack<Partida>();
                String consultarIntentados = " SELECT id_puzzle,fecha_intento FROM perfil_puzzles_intentados WHERE id_perfil = ? ORDER BY fecha_intento DESC;";
                PreparedStatement sentencia_quinta = con.prepareStatement(consultarIntentados);
                sentencia_quinta.setInt(1, id_usuario);
                ResultSet resultadoIntentados = sentencia_quinta.executeQuery();
                while (resultadoIntentados.next()) {
                    int idPuzzle = resultadoIntentados.getInt("id_puzzle");
                    Date fecha = resultadoIntentados.getDate("fecha_intento");
                    Partida partida = new Partida(idPuzzle,id_usuario, fecha);
                    puzzlesIntentados.add(partida);

                }

            
            perfil = new Perfil(id_usuario, nombreUsuario, nivel_ajedrez, rating, puzzlesResueltos, puzzlesIntentados, id_rating);

        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perfil;

    }

    public int insertar(Perfil perfilInsertar) {    //solo se incertan perfiles con sus caracteristicas iniciales, no tenf=dran partidads ganadas al inicio
        int registro = 0;                                            //se incerta con el id de algun usuario existente que no tenga perfil, o, se insertará al momento del registro de usuario mejor, junto al id de un rating existente
        try {                                                              //eso se manejará cuando haya implementacion del frontend,  registrando junto a la base de datos
            Connection con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO perfil VALUES(?,?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, perfilInsertar.getId());
            sentencia.setInt(2, perfilInsertar.getIdRating());

            registro = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;

    }

    public int eliminar(Perfil perfil) {
        int eliminado = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM perfil WHERE id_usuario = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, perfil.getId());
            eliminado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    public int actualizar(Perfil perfil) {
        int actualizado = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "UPDATE perfil SET  id_rating= ?  WHERE id_usuario = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, perfil.getIdRating());
            sentencia.setInt(2, perfil.getId());
            actualizado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return actualizado;

    }

}
