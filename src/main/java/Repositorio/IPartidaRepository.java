/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorio;

import Entity.Partida;
import java.util.List;

/**
 *
 * @author JUAN JOSE
 */
public interface IPartidaRepository {
    public List<Partida> consultar();
    public List<Partida> consultarResueltos();
    public List<Partida> consultarIntentados();
    public List<Partida> consultarPartida(Partida partida);
    public List<Partida> consultarResueltosPerfil(Partida partida);
    public List<Partida> consultarIntentadosPerfil(Partida partida);
    public int insertar(Partida partida);
    public int eliminar(Partida partida);
 }
