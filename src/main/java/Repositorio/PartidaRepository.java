/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Partida;
import Red.BaseDeDatos;
import Test.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN JOSE
 */
public class PartidaRepository implements IPartidaRepository {

    @Override
    public List<Partida> consultar() {
        List<Partida> partidas = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT puzzle_id, perfil_id, puzzle_resuelto, fecha_intento, tiempo_intento FROM partida";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int puzzleId = resultado.getInt("puzzle_id");
                int perfilId = resultado.getInt("perfil_id");
                boolean puzzleResuelto = resultado.getBoolean("puzzle_resuelto");
                Date fechaIntento = resultado.getDate("fecha_intento");
                Time tiempo = resultado.getTime("tiempo_intento");
                LocalTime tiempoIntento = tiempo.toLocalTime();
                Partida partida = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
                partidas.add(partida);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return partidas;
    }

    @Override
    public List<Partida> consultarResueltos() {
        List<Partida> partidas = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id_perfil, id_puzzle, fecha_intento, tiempo_intento FROM perfil_puzzles_resueltos";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int puzzleId = resultado.getInt("id_puzzle");
                int perfilId = resultado.getInt("id_perfil");
                boolean puzzleResuelto = true;
                Date fechaIntento = resultado.getDate("fecha_intento");
                Time tiempo = resultado.getTime("tiempo_intento");
                LocalTime tiempoIntento = tiempo.toLocalTime();
                Partida partida = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
                partidas.add(partida);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return partidas;
    }

    @Override
    public List<Partida> consultarIntentados() {
        List<Partida> partidas = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id_perfil, id_puzzle, fecha_intento, tiempo_intento, resuelto FROM perfil_puzzles_intentados";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int puzzleId = resultado.getInt("id_puzzle");
                int perfilId = resultado.getInt("id_perfil");
                boolean puzzleResuelto = resultado.getBoolean("resuelto");
                Date fechaIntento = resultado.getDate("fecha_intento");
                Time tiempo = resultado.getTime("tiempo_intento");
                LocalTime tiempoIntento = tiempo.toLocalTime();
                Partida partida = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
                partidas.add(partida);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return partidas;
    }

    @Override
    public List<Partida> consultarPartida(Partida partida) {
        List<Partida> partidas = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT puzzle_id, perfil_id, puzzle_resuelto, fecha_intento, tiempo_intento FROM partida WHERE perfil_id=? ";
            sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, partida.getPerfilId());
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int puzzleId = resultado.getInt("puzzle_id");
                int perfilId = resultado.getInt("perfil_id");
                boolean puzzleResuelto = resultado.getBoolean("puzzle_resuelto");
                Date fechaIntento = resultado.getDate("fecha_intento");
                Time tiempo = resultado.getTime("tiempo_intento");
                LocalTime tiempoIntento = tiempo.toLocalTime();
                Partida partida2 = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
                partidas.add(partida2);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return partidas;
    }

    @Override
    public List<Partida> consultarResueltosPerfil(Partida partida) {
        List<Partida> partidas = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id_perfil, id_puzzle, fecha_intento, tiempo_intento FROM perfil_puzzles_resueltos WHERE id_perfil=? ";
            sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, partida.getPerfilId());
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int puzzleId = resultado.getInt("id_puzzle");
                int perfilId = resultado.getInt("id_perfil");
                boolean puzzleResuelto = true;
                Date fechaIntento = resultado.getDate("fecha_intento");
                Time tiempo = resultado.getTime("tiempo_intento");
                LocalTime tiempoIntento = tiempo.toLocalTime();
                Partida partida2 = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
                partidas.add(partida2);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return partidas;
    }

    @Override
    public List<Partida> consultarIntentadosPerfil(Partida partida) {
        List<Partida> partidas = new ArrayList<>();
        ResultSet resultado = null;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id_perfil, id_puzzle, fecha_intento, tiempo_intento,resuelto FROM perfil_puzzles_intentados WHERE id_perfil=? ";
            sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, partida.getPerfilId());
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int puzzleId = resultado.getInt("id_puzzle");
                int perfilId = resultado.getInt("id_perfil");
                boolean puzzleResuelto = resultado.getBoolean("resuelto");
                Date fechaIntento = resultado.getDate("fecha_intento");
                Time tiempo = resultado.getTime("tiempo_intento");
                LocalTime tiempoIntento = tiempo.toLocalTime();
                Partida partida2 = new Partida(puzzleId, perfilId, puzzleResuelto, fechaIntento, tiempoIntento);
                partidas.add(partida2);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return partidas;
    }

    @Override
    public int insertar(Partida partida) {
        int registro = 0;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO partida(puzzle_id, perfil_id, puzzle_resuelto, fecha_intento, tiempo_intento) Values(?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, partida.getPuzzleId());
            sentencia.setInt(2, partida.getPerfilId());
            sentencia.setBoolean(3, partida.isPuzzleResuelto());
            java.sql.Date fechaSQL = new java.sql.Date(partida.getFechaIntento().getTime());
            sentencia.setDate(4, fechaSQL);
            java.sql.Time tiempoSQL = Time.valueOf(partida.getTiempoIntento());
            sentencia.setTime(5, tiempoSQL);
            if (partida.isPuzzleResuelto()) {
                insertarResuelto(partida);
            } else {
                insertarIntentado(partida);
            }
            registro = sentencia.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    public int insertarIntentado(Partida partida) {
        int registro = 0;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO perfil_puzzles_intentados(id_perfil, id_puzzle,fecha_intento, tiempo_intento, resuelto) Values(?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, partida.getPerfilId());
            sentencia.setInt(2, partida.getPuzzleId());
            java.sql.Date fechaSQL = new java.sql.Date(partida.getFechaIntento().getTime());
            sentencia.setDate(3, fechaSQL);
            java.sql.Time tiempoSQL = Time.valueOf(partida.getTiempoIntento());
            sentencia.setTime(4, tiempoSQL);
            sentencia.setBoolean(5, partida.isPuzzleResuelto());
            registro = sentencia.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    public int insertarResuelto(Partida partida) {
        int registro = 0;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO perfil_puzzles_resueltos(id_perfil, id_puzzle,fecha_intento, tiempo_intento) Values(?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, partida.getPerfilId());
            sentencia.setInt(2, partida.getPuzzleId());
            java.sql.Date fechaSQL = new java.sql.Date(partida.getFechaIntento().getTime());
            sentencia.setDate(3, fechaSQL);
            java.sql.Time tiempoSQL = Time.valueOf(partida.getTiempoIntento());
            sentencia.setTime(4, tiempoSQL);
            registro = sentencia.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    @Override
    public int eliminar(Partida partida) {
        int registro = 0;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM partida WHERE perfil_id = ?";
            sentencia = con.prepareStatement(sql);
            eliminarIntentadosPerfil(partida);
            eliminarResueltosPerfil(partida);
            sentencia.setInt(1, partida.getPerfilId());
            registro = sentencia.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    public int eliminarIntentadosPerfil(Partida partida) {
        int registro = 0;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM perfil_puzzles_intentados WHERE id_perfil= ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, partida.getPerfilId());
            registro = sentencia.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    public int eliminarResueltosPerfil(Partida partida) {
        int registro = 0;
        PreparedStatement sentencia = null;
        Connection con = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM perfil_puzzles_resueltos WHERE id_perfil= ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, partida.getPerfilId());
            registro = sentencia.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PartidaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

}
