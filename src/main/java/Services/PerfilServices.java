/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Perfil;
import Repositorio.PerfilRepository;
import java.util.List;

/**
 *
 * @author Perfil
 */
public class PerfilServices {
    
     PerfilRepository perfilRepository = new PerfilRepository();
    
    public List<Perfil> consultar(){
        return perfilRepository.consultar();
    }
    
    public Perfil consultarId(Perfil Perfil){
        return perfilRepository.consultarId(Perfil);
    }
    
    public int insertar(Perfil Perfil){
        return perfilRepository.insertar(Perfil);
    }
    
    public int eliminar(Perfil Perfil){
        return perfilRepository.eliminar(Perfil);
    }
    
    public int actualizar(Perfil Perfil){
        return perfilRepository.actualizar(Perfil);
    }
    
}
