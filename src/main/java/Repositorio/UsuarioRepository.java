/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Usuario;
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
public class UsuarioRepository {

    public List<Usuario> consultar() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "SELECT id, nombre_usuario,nombre_real,correo,clave,nivel_ajedrez FROM  usuario ";
            PreparedStatement sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombreUsuario = resultado.getString("nombre_usuario");
                String nombreReal = resultado.getString("nombre_real");
                String correo = resultado.getString("correo");
                String clave = resultado.getString("clave");
                int nivelAjedrez = resultado.getInt("nivel_ajedrez");
                Usuario usuario = new Usuario(id, nombreUsuario, nombreReal, correo, clave, nivelAjedrez);
                usuarios.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public Usuario consultarId(Usuario usuarioConsultar) {
        Usuario usuario = null;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "SELECT  id, nombre_usuario,nombre_real,correo,clave,nivel_ajedrez FROM usuario WHERE id = ? ";
            PreparedStatement sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, usuarioConsultar.getId());
            ResultSet resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String nombreUsuario = resultado.getString("nombre_usuario");
            String nombreReal = resultado.getString("nombre_real");
            String correo = resultado.getString("correo");
            String clave = resultado.getString("clave");
            int nivelAjedrez = resultado.getInt("nivel_ajedrez");
            usuario = new Usuario(id, nombreUsuario, nombreReal, correo, clave, nivelAjedrez);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;

    }

    public int insertar(Usuario usuarioInsertar) {
        int registro = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO usuario VALUES(?,?,?,?,?,null)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, usuarioInsertar.getNombreUsuario());
            sentencia.setString(2, usuarioInsertar.getNombreReal());
            sentencia.setString(3, usuarioInsertar.getCorreo());
            sentencia.setString(4, usuarioInsertar.getClave());
            sentencia.setInt(5, usuarioInsertar.getNivelAjedrez());

            registro = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;

    }

    public int eliminar(Usuario usuario) {
        int eliminado = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, usuario.getId());
            eliminado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    public int actualizar(Usuario usuario) {
        int actualizado = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "UPDATE usuario SET  nombre_usuario= ?  WHERE id = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, usuario.getNombreUsuario());
            sentencia.setInt(2, usuario.getId());
            actualizado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return actualizado;

    }

}
