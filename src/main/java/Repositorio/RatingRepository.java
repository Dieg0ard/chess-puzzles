/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Rating;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class RatingRepository {

    public List<Rating> consultar() {
        List<Rating> ratings = new ArrayList<>();
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id, valor FROM  rating ";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int valor = resultado.getInt("valor");

                Rating rating = new Rating(id, valor);
                ratings.add(rating);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ratings;
    }

    public Rating consultarId(Rating ratingConsultar) {
        Rating rating = null;
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT  id, valor FROM rating WHERE id = ? ";
            sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, ratingConsultar.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            int valor = resultado.getInt("valor");

            rating = new Rating(id, valor);

        } catch (SQLException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return rating;

    }

    public int insertar(Rating ratingInsertar) {
        int registro = 0;
        Connection con = null;
        PreparedStatement sentencia = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO rating VALUES(null,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, ratingInsertar.getValor());

            registro = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return registro;

    }

    public int eliminar(Rating rating) {
        int eliminado = 0;
        Connection con = null;
        PreparedStatement sentencia = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM rating WHERE id = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, rating.getId());
            eliminado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
        }
        return eliminado;
    }

    public int actualizar(Rating rating) {
        int actualizado = 0;
        Connection con = null;
        PreparedStatement sentencia = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "UPDATE rating SET  valor= ?  WHERE id = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, rating.getValor());
            sentencia.setInt(2, rating.getId());
            actualizado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                BaseDeDatos.close(sentencia);
                 BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(RatingRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

        return actualizado;

    }

}
