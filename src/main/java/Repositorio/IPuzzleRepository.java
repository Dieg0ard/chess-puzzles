/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorio;

import Entity.Puzzle;
import java.util.List;

/**
 *
 * @author JUAN JOSE
 */
public interface IPuzzleRepository {
    public List <Puzzle> consultar();
    public Puzzle consultarId(Puzzle puzzle);
    
}
