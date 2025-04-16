/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Puzzle {
    
    private int puzzleId;
    private int rating;
    private int ratingDevitation;
    private int popularidad;
    private String clasifiacion;
    private String FEN;
    private Stack <String> movimientos;
    private String apertura;

    /**
     * @return the puzzleId
     */
    public int getPuzzleId() {
        return puzzleId;
    }

    /**
     * @param puzzleId the puzzleId to set
     */
    public void setPuzzleId(int puzzleId) {
        this.puzzleId = puzzleId;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the ratingDevitation
     */
    public int getRatingDevitation() {
        return ratingDevitation;
    }

    /**
     * @param ratingDevitation the ratingDevitation to set
     */
    public void setRatingDevitation(int ratingDevitation) {
        this.ratingDevitation = ratingDevitation;
    }

    /**
     * @return the popularidad
     */
    public int getPopularidad() {
        return popularidad;
    }

    /**
     * @param popularidad the popularidad to set
     */
    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    /**
     * @return the clasifiacion
     */
    public String getClasifiacion() {
        return clasifiacion;
    }

    /**
     * @param clasifiacion the clasifiacion to set
     */
    public void setClasifiacion(String clasifiacion) {
        this.clasifiacion = clasifiacion;
    }

    /**
     * @return the FEN
     */
    public String getFEN() {
        return FEN;
    }

    /**
     * @param FEN the FEN to set
     */
    public void setFEN(String FEN) {
        this.FEN = FEN;
    }

    /**
     * @return the movimientos
     */
    public Stack <String> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(Stack <String> movimientos) {
        this.movimientos = movimientos;
    }

    /**
     * @return the apertura
     */
    public String getApertura() {
        return apertura;
    }

    /**
     * @param apertura the apertura to set
     */
    public void setApertura(String apertura) {
        this.apertura = apertura;
    }
   
  
    
}
