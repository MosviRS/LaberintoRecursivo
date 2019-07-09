/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentlaberinto;

import javax.swing.JOptionPane;

/**
 *
 * @author mosvi
 */
public class List {
    
    protected Nodo inicio,fin;
    public Nodo siguiente;
    public char[][] cades;
     public List(){
         inicio=null;
         fin=null;
     }
     public List(char cad[][]){
         this.cades=cad;
         this.siguiente=null;
     }
    public void agrinicio(char lemen[][]){
        inicio= new Nodo(lemen,inicio);
        if(fin==null){
            fin=inicio;
        }
        
    }
    public void mostrar(){
        Nodo recorrer=inicio;
        while(recorrer!=null){
               correr(recorrer.nombre);
            
               recorrer=recorrer.siguiente;
        }
        
        
    }
//    public int memoria(String []det){
//          Nodo recorrer=inicio;
//          int acc=0;
//          System.out.println("menoria");
//        while(recorrer.siguiente!=null){
//                 
//               acc=correr(det,recorrer.nombre);
//               
//                if(acc==4){
//                    break;
//                }
//               recorrer=recorrer.siguiente;
//               
//        }
//        System.out.println(acc);
//        return acc; 
//    }
    public void correr(char[][] det){
     for (int i = 0; i < 4; i++) {//filas
            for (int j = 0; j < 4; j++) {//columnas
                System.out.print("[ "+det[i][j]+" ]");
            }
            System.out.println("");
        }
        System.out.println("");
       
          
    }

// 
//    public boolean estavacia(){
//        if(inicio==null){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public void finalE(String[] cad){
//        if(estavacia()){
//            fin.siguiente= new Nodo(cad);
//            fin=fin.siguiente;
//        }else{
//            inicio=new Nodo(cad);
//            fin=new Nodo(cad);
//        }
//    }
//    public void editar(String[] cad){
//        Nodo temporal;
//        temporal=inicio;
//        while(temporal!=null ){
//            if(temporal.nombre.equals(cad)){
//                //temporal.nombre=JOptionPane.showInputDialog(null,"ingrese el dato para el nodo");
//
//            }
//            temporal=temporal.siguiente;
//
//        }
//        
//    }
//       public boolean buscar(String cad){
//          Nodo temporal;
//          temporal=inicio;
//        
//                while(temporal!=null && !temporal.nombre.equals(cad) ){
//                
//                    temporal=temporal.siguiente;
//                }
//                return temporal!=null;
//    }
//    public void eliminar(String cad){
//        if(!estavacia()){
//            if(inicio==fin && cad.equals(inicio.nombre)){
//                inicio=fin=null;
//            }else if(cad.equals(inicio.nombre)){
//                inicio=inicio.siguiente;  
//            }else{
//                Nodo anterior,temporal;
//                anterior=inicio;
//                temporal=inicio.siguiente;
//                verificar(cad,anterior, temporal);
//                     
//                if(temporal!=null){
//                    anterior.siguiente=temporal.siguiente;
//                    if(temporal==fin){
//                        fin=anterior;
//                    }
//                }
//            }
//        }
//            
//        
//    }
//    public void verificar(String cad,Nodo anterior,Nodo temporal){
//        if(temporal==null && !temporal.nombre.equals(cad)){
//            verificar(cad,anterior,temporal);
//        
//    }else{
//             anterior=anterior.siguiente;
//                            temporal=temporal.siguiente;
//        }
//    }
//}
}