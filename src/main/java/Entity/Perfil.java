/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Usuario
 */
import java.util.Stack;


public class Perfil {

    private String nombreUsuario;
    private String nivelAjedrez;
    private Rating rating;
    private Stack<Puzzle> puzzlesResueltos;
    private Stack<Partida> puzzlesIntentados;

    // Getters and setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNivelAgéndez() {
        return nivelAjedrez;
    }

    public void setNivelAgéndez(String nivelAjedrez) {
        this.nivelAjedrez = nivelAjedrez;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Stack<Puzzle> getPuzzlesResueltos() {
        return puzzlesResueltos;
    }

    public void setpuzzlesResueltoss(Stack<Puzzle> puzzlesResueltos) {
        this.puzzlesResueltos = puzzlesResueltos;
    }

    public Stack<Partida> getPuzzlesIntentados() {
        return puzzlesIntentados;
    }

    public void setPuzzlesIntentados(Stack<Partida> puzzlesIntentados) {
        this.puzzlesIntentados = puzzlesIntentados;
    }
}
