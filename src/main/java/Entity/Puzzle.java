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
    private int id;
    private String puzzleId;
    private String FEN;
    private Stack <String> movimientos;
    private int rating;
    private int ratingDevitation;
    private int popularidad;
    private int nbPlays;
    private String themes;
    private String gameUrl;
    private String apertura;

    public Puzzle() {
    }

    public Puzzle(int id) {
        this.id = id;
    }
    

    public Puzzle(int id, String puzzleId, String FEN, Stack<String> movimientos, int rating, int ratingDevitation, int popularidad, int nbPlays, String themes, String gameUrl, String apertura) {
        this.id = id;
        this.puzzleId = puzzleId;
        this.FEN = FEN;
        this.movimientos = movimientos;
        this.rating = rating;
        this.ratingDevitation = ratingDevitation;
        this.popularidad = popularidad;
        this.nbPlays = nbPlays;
        this.themes = themes;
        this.gameUrl = gameUrl;
        this.apertura = apertura;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuzzleId() {
        return puzzleId;
    }

    public void setPuzzleId(String puzzleId) {
        this.puzzleId = puzzleId;
    }

    public String getFEN() {
        return FEN;
    }

    public void setFEN(String FEN) {
        this.FEN = FEN;
    }

    public Stack<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Stack<String> movimientos) {
        this.movimientos = movimientos;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRatingDevitation() {
        return ratingDevitation;
    }

    public void setRatingDevitation(int ratingDevitation) {
        this.ratingDevitation = ratingDevitation;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public int getNbPlays() {
        return nbPlays;
    }

    public void setNbPlays(int nbPlays) {
        this.nbPlays = nbPlays;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

       
}
