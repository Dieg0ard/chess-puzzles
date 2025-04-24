/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Usuario;
import Repositorio.UsuarioRepository;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioServices {
    
    UsuarioRepository usuarioRepository = new UsuarioRepository();
    
    public List<Usuario> consultar(){
        return usuarioRepository.consultar();
    }
    
    public Usuario consultarId(Usuario usuario){
        return usuarioRepository.consultarId(usuario);
    }
    
    public int insertar(Usuario usuario){
        return usuarioRepository.insertar(usuario);
    }
    
    public int eliminar(Usuario usuario){
        return usuarioRepository.eliminar(usuario);
    }
    
    public int actualizar(Usuario usuario){
        return usuarioRepository.actualizar(usuario);
    }
    
}
