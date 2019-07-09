/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentlaberinto;

/**
 *
 * @author mosvi
// */
public class Pila {
    Nodopilas primero;
   
    public char reten=0;
    public int mano=0;
    public char varse[]= new char[2];
    
    public void insertar(String var){
       Nodopilas nuevo= new Nodopilas(var);
//        System.out.println("nuevo.siguinet= "+nuevo.siguiente);
//        System.out.println("pimero= "+primero);
//        System.out.println("nuevo= "+nuevo);
//        System.out.println("\n");
       nuevo.var=var;
       if(primero==null){
           nuevo.siguiente=null;
           primero=nuevo;

       }else{
           nuevo.siguiente=primero;
           primero=nuevo;
           
       }
       
//            System.out.println("nuevo.siguinet= "+nuevo.siguiente);
//            System.out.println("pimero= "+primero);
//            System.out.println("nuevo= "+nuevo);
//            System.out.println("\n");
    }
    public String extraer(){
       Nodopilas aux=primero;
       primero=primero.siguiente;
        String rest=aux.var;
       aux.siguiente=null;
      
       aux=null;
        System.out.println("sacando priemero "+rest);
        return rest;
       
    }
    
    public void pop(){
     int c=0;
        
        Nodopilas actual ;
        actual=primero;
        while(actual!=null){
            System.out.println("Valores pila = "+c+actual.var);
            System.out.println(" ");
        
            actual=actual.siguiente;
            c++;
                   }
       
    }
    public boolean esatvacia(){
        boolean tr=false;
        if(primero!=null){
            tr=true;
        }else{
            tr=false;
        }
        return tr;
    }
    public boolean buscarNodo(String var){
        boolean acces=false;
        Nodopilas actual ;
        actual=primero;
        if(primero!=null){
            while(actual!=null){
                if(actual.var==var){
                    System.out.println("Nodo "+var+"encontrado \n");
                    acces= true;
                }
                 actual=actual.siguiente;
            }
            if(acces==false){
                System.out.println("dato no encontrado");
                 acces=false;
            }
        }else{
            System.out.println("lista vacia");
            acces=false;
        }
        return acces;
   
    }
//    public int sacar(){
//        Nodopilas actual ;
//        actual=primero;
//        boolean save=false;
//        int c=0;
//        while(actual!=null && actual.var!='('){
//           
//          c++;
//          actual=actual.siguiente;
//        }
//
//        return c;
//   }
//    public boolean busacdorpar(){
//         Nodopilas actual ;
//        actual=primero;
//        boolean save=false;
//        int c=0;
//        while(actual!=null){
//            System.out.println("Valores pila = "+actual.var);
//            System.out.println(" ");
//            if(actual.var=='(' && c==0 ){
//                save=true;
//            }
//            c++;
//            actual=actual.siguiente;
//        }
//
//        return save;
//    }
//     public boolean busacdorcaracter(){
//        Nodopilas actual ;
//        actual=primero;
//        boolean save=false;
//        int c=0;
//        while(actual!=null){
//            System.out.println("Valores pila = "+actual.var);
//            System.out.println(" ");
//            if((actual.var=='+' || actual.var=='-')  && c==0 ){
//                save=true;
//            }
//            c++;
//            actual=actual.siguiente;
//        }
//
//        return save;
//    }
//      public int busacdormult(){
//        Nodopilas actual ;
//        actual=primero;
//    
//        int c=0,cont=0;
//        while(actual!=null){
//            System.out.println("Valores pila = "+actual.var);
//            System.out.println(" ");
//            if((actual.var=='*' || actual.var=='/')  && ( c==0 || c==1)){
//               varse[cont]=actual.var;
//               c++;
//            }
//           cont++;
//            actual=actual.siguiente;
//        }
//
//        return c;
//    }
        public boolean noesatvaciaagregar(){
        boolean tr=false;
        if(primero!=null){
//            char guard=extraer();
//           
//            Expresions.jTextsalida.setText(Expresions.jTextsalida.getText()+Character.toString(guard));
            tr=true;
        }else{
            
            tr=false;
        }
        return tr;
    }
//     public int busacdormult(){
//         Nodopilas actual ;
//        int c=0;
//        boolean save=false;
//        actual=primero;
//               
//
//        if(primero!=null){
//            while(c<2){
//
//                   if(actual.var=='*' || actual.var=='/' ){
//                    
//                       save=true;
//                       c++;
//                       actual=actual.siguiente;
//                   }
//        
//                 
//                 actual=null;
//            }
//
//        }
//
//        return c;
//    }
    
}
