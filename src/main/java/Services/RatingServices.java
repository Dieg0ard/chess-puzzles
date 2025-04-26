/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Rating;
import Repositorio.RatingRepository;
import java.util.List;

/**
 *
 * @author Rating
 */
public class RatingServices {
     RatingRepository RatingRepository = new RatingRepository();
    
    public List<Rating> consultar(){
        return RatingRepository.consultar();
    }
    
    public Rating consultarId(Rating rating){
        return RatingRepository.consultarId(rating);
    }
    
    public int insertar(Rating rating){
        return RatingRepository.insertar(rating);
    }
    
    public int eliminar(Rating rating){
        return RatingRepository.eliminar(rating);
    }
    
    public int actualizar(Rating rating){
        return RatingRepository.actualizar(rating);
    }
    
}
