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

    
    private int id;
    private String nombre_perfil;
    private int nivelAjedrez;
    private int rating;
    private Stack<Partida> puzzlesResueltos;
    private Stack<Partida> puzzlesIntentados;
    private int idRating; //sirve cuando vamos a inserat por id del rating en la base de datos
    
 

    public Perfil(int id, String nombre_perfil, int nivelAjedrez, int rating, Stack<Partida> puzzlesResueltos, Stack<Partida> puzzlesIntentados, int idRating) {
        this.id = id;
        this.nombre_perfil = nombre_perfil;
        this.nivelAjedrez = nivelAjedrez;
        this.rating = rating;
        this.puzzlesResueltos = puzzlesResueltos;
        this.puzzlesIntentados = puzzlesIntentados;
        this.idRating = idRating;
    }

    
    
    public Perfil(int id, String nombre_perfil, int nivelAjedrez, int rating,int idRating) {
       this.id = id;
        this.nombre_perfil = nombre_perfil;
        this.nivelAjedrez = nivelAjedrez;
        this.rating = rating;
        this.idRating = idRating;
    }

    public Perfil(int id, int idRating) {
        this.id = id;
        this.idRating = idRating;
    }

    public Perfil(int id) {
        this.id = id;
    }
    
    

   

    // Getters and setters
    
    
    

    public int getIdRating() {
        return idRating;
    }
    
    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }
   

    public int getNivelAjedrez() {
        return nivelAjedrez;
    }

    public void setNivelAgéndez(int nivelAjedrez) {
        this.nivelAjedrez = nivelAjedrez;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Stack<Partida> getPuzzlesResueltos() {
        return puzzlesResueltos;
    }

    public void setpuzzlesResueltoss(Stack<Partida> puzzlesResueltos) {
        this.puzzlesResueltos = puzzlesResueltos;
    }

    public Stack<Partida> getPuzzlesIntentados() {
        return puzzlesIntentados;
    }

    public void setPuzzlesIntentados(Stack<Partida> puzzlesIntentados) {
        this.puzzlesIntentados = puzzlesIntentados;
    }
}
