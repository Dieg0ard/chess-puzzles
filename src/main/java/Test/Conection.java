/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Conection {
    public static void main (String [] args){
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "SELECT id, moves FROM puzzles";
            PreparedStatement sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            //Recorrer el resultado, dentro de get enviar el nombre exacto del dato
            while(resultado.next()){
                int id = resultado.getInt("id");
                String moves = resultado.getString("moves");
                System.out.println("ID: " + id + "-- Movimientos: " + moves);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
