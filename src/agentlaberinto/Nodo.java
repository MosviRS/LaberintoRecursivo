/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentlaberinto;

/**
 *
 * @author mosvi
 */
public class Nodo {
    public char [][] nombre;
    public int cantidad;
    public double precio;
    
    public Nodo siguiente;
    
    public Nodo(char [][]d/*, int c, double p*/){
        this.nombre=d;
        /*this.cantidad= c;
        this.precio= p;*/
        
    }
    //constructor para inicio
    public Nodo(char [][]d/*, int c, double p*/, Nodo n){
        nombre=d;
        /*cantidad= c;
        precio= p;*/
        siguiente=n;
    }
}
