/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MetodosMigracion;
import modelo.Migracion;
import vista.FRM_Migracion;

/**
 *
 * @author admin2
 */
public class Controlador_FRM_Migracion implements ActionListener{
    
    FRM_Migracion frm;
    MetodosMigracion metodos;
    Migracion migra;
    
    
    public Controlador_FRM_Migracion(FRM_Migracion frm)
    {
        this.frm=frm;
        metodos= new MetodosMigracion();
    }
    public void actionPerformed(ActionEvent e)
    {
       if(e.getActionCommand().equals("Registrar"))
       {
           String datos[]= frm.retornarInformacion();
           
           migra= new Migracion(datos[0], datos[1], datos[2], datos [3]);
           metodos.registrar(migra);
           System.out.println("registro");
           frm.asiganarTexto(metodos.mostrarCola());
           frm.resetGUI();
       }//fin if registar
       
       if(e.getActionCommand().equals("Atender"))
       {
   
           frm.asiganarTexto(metodos.atender());
       }//fin if atender
       
       if(e.getActionCommand().equals("Cancelar"))
       {
           metodos.cancelar(frm.retornarCedula());
           frm.asiganarTexto(metodos.mostrarCola());
       }
       
       if(e.getActionCommand().equals("Modificar"))
       {
           if(buscar()==true)
           {
               buscar();
               metodos.modificar(frm.retornarInformacion());
               System.out.println("modificado");
           }
           
       }//fin if modificar
       
       if(e.getActionCommand().equals("<"))
       {
           metodos.ordenar_menor_a_mayor();
           frm.asiganarTexto(metodos.mostrarCola());
       }
       
       if(e.getActionCommand().equals(">"))
       {
           metodos.ordenar_mayor_a_menor();
           frm.asiganarTexto(metodos.mostrarCola());
       }
       
       if(e.getActionCommand().equals("Cantidad")){
          
           frm.asiganarTexto(""+metodos.tamannoCola());
       
       }
       
       if(e.getActionCommand().equals("Informacion"))
       {
           frm.asiganarTexto(metodos.mostrarCola());
       }
       
       if(e.getActionCommand().equals("Promedio"))
       {
           frm.asiganarTexto(""+metodos.promedio());
       }
    }
    
    public boolean buscar()
    {
        boolean consulta=false;
        if(metodos.consultarUsuario(frm.retornarCedula())==true)
        {
            frm.editar();
            consulta=true;
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
            frm.editar();
            frm.deshabilitarCedula();
        }
        
        return consulta;
                
    }
}
