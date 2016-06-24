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
public class MetodosMigracion {
    
    private Migracion primero;
    private Migracion ultimo;
    private int ficha;
    
    
    public MetodosMigracion()
    {
     primero=ultimo=null;   
    }
    
    public void registrar(Migracion migra)
    {
     
      //si no hay
      if(primero== null){
          
        primero=ultimo=migra;  
      }  
      
      else
      {
          
          if(migra.getPriori().equalsIgnoreCase("7600"))
          {
             Migracion aux= primero;
             Migracion anterior= null;
             
             
             while(aux.getPriori().equalsIgnoreCase("7600")){
                 
                 anterior=aux;
                 aux=aux.getEnlace();
             }//fin while
             
             if(aux==primero)
             {
                 migra.setEnlace(anterior.getEnlace());
                 anterior.setEnlace(aux);
                 
             }//fin if
             
             else
             {
                 migra.setEnlace(primero);
                 anterior.setEnlace(migra);
             }//fin else
             
          }//fin if
          
          else
          {
              ultimo.setEnlace(migra);
              ultimo= migra;
          }//fin else
          
      }//fin else
      
    }//fin registrar
    
    public void modificar(String [] dato){
        Migracion aux=primero;
        String datos[]=dato;
        
        while(aux!=null)
        {
            
            if(aux.getCedula().equals(datos[0]))
            {
                aux.setNombre(datos[1]);
                aux.setEdad(datos[2]);
                aux.setPriori(datos[3]);
            }
            
            aux=aux.getEnlace();
        }
    }
    
    public int tamannoCola()
    {
        Migracion aux=primero;
        
        int contador=0;
        
        if(aux!=null)
        {
            aux=aux.getEnlace();
            contador++;
        }
        return contador;
    }
    
    public String mostrarCola()
    {
        
        Migracion aux=primero;
        String valores="";
        
        while(aux.getEnlace()!=null)
        {
            valores+= aux.getInformacion()+ "\n";
            aux=aux.getEnlace();
        }//fin del while
        
        valores+= aux.getInformacion()+ "\n";
        
        return valores;
        
    }//fin mostrar
    
    public int promedio()
    {
       Migracion aux=primero;
       int edad=0;
       int promedio=0;
       
       while(aux!=null)
       {
           edad+= Integer.parseInt(aux.getEdad());
           
           aux=aux.getEnlace();
       }
       
       promedio= (edad/tamannoCola());
     
       return promedio;
    }
    public String atender()
    {
        Migracion aux=primero;
        Migracion anterior=null;
        String mostrar="";
        
        if(aux!=null){
            mostrar= aux.getInformacion();
            anterior=primero;
            primero=primero.getEnlace();
            
        }
        
        return mostrar;
    }//fin atender
    
    public void cancelar(String cedula)
    {
        Migracion aux=primero;
        
        if(primero!=null)
        {
            if(primero.getCedula().equals(cedula))
            {
                primero=primero.getEnlace();
            }
        }
            
    }
    
    public boolean consultarUsuario(String cedula)
    {
        boolean existe=false;
        
        Migracion aux=primero;
        
        while(aux!=null)
        {
            if(aux.getCedula().equals(cedula))
            {
                
                existe=true;
            }
        
        }
        return existe;
    }
    
     public void ordenar_mayor_a_menor()
    {
        int tamanioLista = tamannoCola();
        
        
        String nombreTemporal;
        int edadTemporal;
        String cedula;
        String prioridadTemporal;
        
        Migracion temporal;
        
        for(int contador=0; contador<tamanioLista; contador++)
        {
            temporal = primero;
            
            while(temporal.getEnlace() != null)
            {
                if(temporal.getEdad().equals(temporal.getEnlace().getEdad()))
                {
                    
                    
                    nombreTemporal = temporal.getNombre();
                    edadTemporal = Integer.parseInt(temporal.getEdad());
                    cedula=temporal.getCedula();
                    prioridadTemporal = temporal.getPriori();
                    
                    //Intercambia los datos
                    
                    temporal.setCedula(temporal.getEnlace().getCedula());
                    temporal.setNombre(temporal.getEnlace().getNombre());
                    temporal.setEdad(temporal.getEnlace().getEdad());
                    temporal.setPriori(temporal.getEnlace().getPriori());
                    
                    //Cambia los datos temporales en el objeto siguiente.
                   
                    temporal.getEnlace().setNombre(nombreTemporal);
                    temporal.getEnlace().setEdad(""+edadTemporal);
                    temporal.getEnlace().setCedula(cedula);
                    temporal.getEnlace().setPriori(prioridadTemporal);
                    
                }
                temporal = temporal.getEnlace();
            }
        }
    }//Fin del metodo ordenar_mayor_a_menor.
    
    public void ordenar_menor_a_mayor()
    {
        int tamanioLista = tamannoCola();
        
        String fichaTemporal;
        String nombreTemporal;
        int edadTemporal;
        String tipoTemporal;
        String prioridadTemporal;
        
        Migracion temporal;
        
        for(int contador=0; contador<tamanioLista; contador++)
        {
            temporal = primero;
            
            while(temporal.getEnlace() != null)
            {
                if(temporal.getEdad().equals(temporal.getEnlace().getEdad()))
                {
                    //Almacena los datos del objeto en un lugar temporal
                    
                    nombreTemporal = temporal.getNombre();
                    edadTemporal = Integer.parseInt(temporal.getEdad());
                    tipoTemporal = temporal.getCedula();
                    prioridadTemporal = temporal.getPriori();
                    
                    //Intercambia los datos
                    
                    temporal.setNombre(temporal.getEnlace().getNombre());
                    temporal.setEdad(temporal.getEnlace().getEdad());
                    temporal.setCedula(temporal.getEnlace().getCedula());
                    temporal.setPriori(temporal.getEnlace().getPriori());
                    
                    //Cambia los datos temporales en el objeto siguiente.
                    
                    temporal.getEnlace().setNombre(nombreTemporal);
                    temporal.getEnlace().setEdad(""+edadTemporal);
                    temporal.getEnlace().setCedula(tipoTemporal);
                    temporal.getEnlace().setPriori(prioridadTemporal);
                    
                }
                temporal = temporal.getEnlace();
            }
        }
    }//Fin del metodo ordenar_menor_a_mayor.
    
}//fin dela clase
