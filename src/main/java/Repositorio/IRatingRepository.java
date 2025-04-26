/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Entity.Rating;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IRatingRepository {
    
     public List<Rating> consultar();
    public Rating consultarCodigo(Rating rating);
    public int insertar(Rating rating);
    public int eliminar(Rating rating);
    public int actualizar(Rating rating);
    
}
