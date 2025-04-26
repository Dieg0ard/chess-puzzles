/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Perfil;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IPerfilRepository {
    
    public List<Perfil> consultar();
    public Perfil consultarCodigo(Perfil perfil);
    public int insertar(Perfil perfil);
    public int eliminar(Perfil perfil);
    public int actualizar(Perfil perfil);
    
}
