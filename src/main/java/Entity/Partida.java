/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Time;
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
    private Time tiempointento;

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
     * @return the tiempointento
     */
    public Time getTiempointento() {
        return tiempointento;
    }

    /**
     * @param tiempointento the tiempointento to set
     */
    public void setTiempointento(Time tiempointento) {
        this.tiempointento = tiempointento;
    }
    
   
    
}
