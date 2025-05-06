/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Partida {
    
    private int puzzleId;
    private int perfilId;
    private boolean puzzleResuelto;
    private Date fechaIntento;
    private LocalTime tiempoIntento;

    public Partida( int perfilId) {
        this.perfilId = perfilId;
    }

    public Partida(int puzzleId, int perfilId, Date fechaIntento, LocalTime tiempoIntento,boolean puzzleResuelto) {
        this.puzzleId = puzzleId;
        this.perfilId = perfilId;
        this.fechaIntento = fechaIntento;
        this.tiempoIntento = tiempoIntento;
        this.puzzleResuelto =puzzleResuelto;
    }
    

    public Partida(int puzzleId, int perfilId, boolean puzzleResuelto, Date fechaIntento, LocalTime tiempointento) {
        this.puzzleId = puzzleId;
        this.perfilId = perfilId;
        this.puzzleResuelto = puzzleResuelto;
        this.fechaIntento = fechaIntento;
        this.tiempoIntento = tiempointento;
    }

    public Partida(int puzzleId, int perfilId, Date fechaIntento) {
        this.puzzleId = puzzleId;
        this.perfilId = perfilId;
        this.fechaIntento = fechaIntento;
    }

    public Partida(int puzzleId, Date fechaIntento) {
        this.puzzleId = puzzleId;
        this.fechaIntento = fechaIntento;
    }

    public Partida(int puzzleId, int perfilId, boolean puzzleResuelto, Date fechaIntento) {
        this.puzzleId = puzzleId;
        this.perfilId = perfilId;
        this.puzzleResuelto = puzzleResuelto;
        this.fechaIntento = fechaIntento;
    }
    
    
    
    
    
    

   

    
    
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
     * @return the perfilId
     */
    public int getPerfilId() {
        return perfilId;
    }

    /**
     * @param perfilId the perfilId to set
     */
    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    /**
     * @return the puzzleResuelto
     */
    public boolean isPuzzleResuelto() {
        return puzzleResuelto;
    }

    /**
     * @param puzzleResuelto the puzzleResuelto to set
     */
    public void setPuzzleResuelto(boolean puzzleResuelto) {
        this.puzzleResuelto = puzzleResuelto;
    }

    /**
     * @return the fechaIntento
     */
    public Date getFechaIntento() {
        return fechaIntento;
    }

    /**
     * @param fechaIntento the fechaIntento to set
     */
    public void setFechaIntento(Date fechaIntento) {
        this.fechaIntento = fechaIntento;
    }
    /**
     * @return the tiempoIntento as a String
     */
    public String getTiempoIntentoString() {
        return tiempoIntento != null ? tiempoIntento.toString() : null;
    }
    /**
     * @return the tiempointento
     */
    public LocalTime getTiempoIntento() {
        return tiempoIntento;
    }

    /**
     * @param tiempoIntento
     */
    public void setTiempoIntento(LocalTime tiempoIntento) {
        this.tiempoIntento = tiempoIntento;
    }
    
   
    
}
