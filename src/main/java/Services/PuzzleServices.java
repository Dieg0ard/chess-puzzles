/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Puzzle;
import Repositorio.PuzzleRepository;
import java.util.List;

/**
 *
 * @author JUAN JOSE
 */
public class PuzzleServices {
    PuzzleRepository puzzleRepository= new PuzzleRepository();
    public List <Puzzle> consultar(){
        return puzzleRepository.consultar();
    }
    public Puzzle  consultarId(Puzzle puzzle){
        return puzzleRepository.consultarId(puzzle);
    }
    
}
