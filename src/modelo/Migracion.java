/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author admin2
 */
public class Migracion {

    /**
     * @param args the command line arguments
     */
   private String cedula;
   private String nombre;
   private String edad;
   private String priori;
   private Migracion enlace;

    public Migracion(String cedula, String nombre, String edad, String priori) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.priori = priori;
    }

    public Migracion getEnlace() {
        return enlace;
    }

    public void setEnlace(Migracion enlace) {
        this.enlace = enlace;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPriori() {
        return priori;
    }

    public void setPriori(String priori) {
        this.priori = priori;
    }
    
    public String getInformacion()
    {
        return "Nombre: " +getNombre()+ "\n Cedula: " +getCedula()+ "\n Edad: " +getEdad()+ "\n Prioridad: " +getPriori();
    }
   
   
    
}
