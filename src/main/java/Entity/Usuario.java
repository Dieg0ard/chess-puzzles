/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Usuario
 */
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Usuario {

    private String nombreUsuario;
    private String nombreReal;
    private String correo;
    private String clave;
    private String nivelAjedrez;

    // Getters and setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNivelAgéndez() {
        return nivelAjedrez;
    }

    public void setNivelAgéndez(String nivelAgéndez) {
        this.nivelAjedrez = nivelAgéndez;
    }
}
