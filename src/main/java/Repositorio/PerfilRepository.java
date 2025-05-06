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
import java.time.LocalTime;
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
            String sql = "SELECT p.id_usuario, u.nombre_usuario, u.nivel_ajedrez, r.valor, p.id_rating"
                    + " FROM perfil p,usuario u, rating r "
                    + "WHERE p.id_usuario = u.id AND p.id_rating = r.id ";
            PreparedStatement sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {    //las propiedades con las que se crea un perfil son el id del usuario (nombre y nivel ajedrez) junto al rating, puzzles resueltos e intentados s

                int id_usuario = resultado.getInt("p.id_usuario");
                int nivel_ajedrez = resultado.getInt("u.nivel_ajedrez");
                String nombreUsuario = resultado.getString("u.nombre_usuario");
                int id_rating = resultado.getInt("p.id_rating");
                int rating = resultado.getInt("r.valor");
                Stack<Partida> puzzlesIntentados = puzzlesIntentados(con, id_usuario);
                Stack<Partida> puzzlesResueltos = puzzlesResueltos(con, id_usuario);   //-----------------Consultar puzzles resueltos asociados-------------------------------

                //a cada perfil, traer todos los puzzles que ha resuelto y los intentos , para intentos almazena en estructura tipo partida
                //para puzzle una estructura tipo puzzle
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
            String sql = "SELECT p.id_usuario, u.nombre_usuario, u.nivel_ajedrez, r.valor, p.id_rating"
                    + " FROM perfil p,usuario u, rating r "
                    + "WHERE p.id_usuario = ? AND  p.id_usuario = u.id AND p.id_rating = r.id ";
            PreparedStatement sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, perfilConsultar.getId());
            ResultSet resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id_usuario = resultado.getInt("p.id_usuario");
            int nivel_ajedrez = resultado.getInt("u.nivel_ajedrez");
            String nombreUsuario = resultado.getString("u.nombre_usuario");
            int id_rating = resultado.getInt("p.id_rating");
            int rating = resultado.getInt("r.valor");

            //-----------------Consultar puzzles resueltos asociados-------------------------------
            //-----------------Consultar puzzles intentados con fecha asociados---------------------------------------
            Stack<Partida> puzzlesIntentados = puzzlesIntentados(con,id_usuario); 
             Stack<Partida> puzzlesResueltos = puzzlesResueltos(con,id_usuario); 
           

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

    public Stack<Partida> puzzlesIntentados(Connection con, int id_usuario) {
        Stack<Partida> puzzlesIntentados = new Stack<Partida>();
        try {

            String consultarIntentados = " SELECT id_puzzle,fecha_intento, tiempo_intento FROM perfil_puzzles_intentados WHERE id_perfil = ? ORDER BY fecha_intento DESC;";
            PreparedStatement sentencia_quinta = con.prepareStatement(consultarIntentados);
            sentencia_quinta.setInt(1, id_usuario);
            ResultSet resultadoIntentados = sentencia_quinta.executeQuery();
            while (resultadoIntentados.next()) {
                int idPuzzle = resultadoIntentados.getInt("id_puzzle");
                Date fecha = resultadoIntentados.getDate("fecha_intento");
               LocalTime tiempoIntento = resultadoIntentados.getTime("tiempo_intento").toLocalTime();
                Partida partida = new Partida(idPuzzle, id_usuario, fecha,tiempoIntento,false);
               
                puzzlesIntentados.add(partida);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puzzlesIntentados;
    }

    public Stack<Partida> puzzlesResueltos(Connection con, int id_usuario) {
        Stack<Partida> puzzlesResueltos = new Stack<Partida>();
        try {

            String consultarResueltos = " SELECT id_puzzle,fecha_intento, tiempo_intento FROM perfil_puzzles_resueltos WHERE id_perfil = ? ORDER BY fecha_intento DESC;";
            PreparedStatement sentencia = con.prepareStatement(consultarResueltos);
            sentencia.setInt(1, id_usuario);
            ResultSet resultadoResueltos = sentencia.executeQuery();
            while (resultadoResueltos.next()) {
                 int idPuzzle = resultadoResueltos.getInt("id_puzzle");
                Date fecha = resultadoResueltos.getDate("fecha_intento");
                LocalTime tiempoIntento = resultadoResueltos.getTime("tiempo_intento").toLocalTime();
                Partida partida = new Partida(idPuzzle, id_usuario, fecha,tiempoIntento,true);
                puzzlesResueltos.add(partida);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return puzzlesResueltos;

    }

}
