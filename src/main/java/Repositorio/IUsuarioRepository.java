/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUsuarioRepository {
    
    public List<Usuario> consultar();
    public Usuario consultarCodigo(Usuario usuario);
    public int insertar(Usuario usuario);
    public int eliminar(Usuario usuario);
    public int actualizar(Usuario usuario);
    
}
