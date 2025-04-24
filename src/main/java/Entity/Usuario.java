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
    private int id;
    private String nombreUsuario;
    private String nombreReal;
    private String correo;
      private String clave;
          private int nivelAjedrez;
      
      public Usuario(String nombreUsuario){
          this.nombreUsuario = nombreUsuario;
          
      }
      
      public Usuario(int id, String nombreUsuario){
          this.id = id;
          this.nombreUsuario = nombreUsuario;
          
      }
      
      public Usuario(int id){
          this.id = id;
          
      }

    public Usuario(String nombreUsuario, String nombreReal, String correo, String clave, int nivelAjedrez) {
        this.nombreUsuario = nombreUsuario;
        this.nombreReal = nombreReal;
        this.correo = correo;
        this.clave = clave;
        this.nivelAjedrez = nivelAjedrez;
    }
      
      
          
          
          

    public Usuario(int id, String nombreUsuario, String nombreReal, String correo, String clave, int nivelAjedrez) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombreReal = nombreReal;
        this.correo = correo;
        this.clave = clave;
        this.nivelAjedrez = nivelAjedrez;
    }
  

    public void setId(int id) {
        this.id = id;
    }

    public void setNivelAjedrez(int nivelAjedrez) {
        this.nivelAjedrez = nivelAjedrez;
    }

    public int getId() {
        return id;
    }


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

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", nombreReal=" + nombreReal + ", correo=" + correo + ", clave=" + clave + ", nivelAjedrez=" + nivelAjedrez + '}';
    }

    public int getNivelAjedrez() {
        return nivelAjedrez;
    }

    
}
