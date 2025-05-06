/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Partida;
import Repositorio.PartidaRepository;
import java.util.List;

/**
 *
 * @author JUAN JOSE
 */
public class PartidaServices {
    PartidaRepository partidaRepository = new PartidaRepository();
    
    public List<Partida> consultar(){
        return partidaRepository.consultar();
    }
    public List<Partida> consultarResueltos(){
        return partidaRepository.consultarResueltos();
    }
    public List<Partida> consultarIntentados(){
        return partidaRepository.consultarIntentados();
    }
    
    public List<Partida> consultarPartida(Partida partida){
        return partidaRepository.consultarPartida(partida);
    }
    public List<Partida> consultarResueltosPerfil(Partida partida){
        return partidaRepository.consultarResueltosPerfil(partida);
    }
    public List<Partida> consultarIntentadosPerfil(Partida partida){
        return partidaRepository.consultarIntentadosPerfil(partida);
    }
    
    public int insertar(Partida partida){
        return partidaRepository.insertar(partida);
    }
    
    public int eliminar(Partida partida){
        return partidaRepository.eliminar(partida);
    }
    
}
