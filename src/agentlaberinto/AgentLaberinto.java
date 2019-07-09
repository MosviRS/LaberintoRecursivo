/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentlaberinto;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mosvi
 */
public class AgentLaberinto {

    /**
     * @param args the command line arguments
     */
    public static String ruta_txt="laberinto1.txt";
    medidas ob= new medidas();
    public  static char[][] mat;
    public  static char[][] save;
    public static int limY;
      public static int limX;
           public static boolean hos=false;
    
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
    // ejemplo de editacion
        Pila okp=new Pila();
        tamano();
          mat= new char[limY][limX];
         save= new char[limY][limX];
        nodoar ar = new nodoar("INICIO", null);
        List ob = new List();
        lista ko = new lista();
        int filas=0,coumnas=0,filaaf=0,coumnasf=0;
       
    
        cargar_txt(mat);
            for (int i = 0; i < limY; i++) {
            for (int j = 0; j < limX; j++) {
                save[i][j]=mat[i][j];
             
            }
        }
//            Panel kot= new Panel();
//            JFrame jf= new JFrame();
//            jf.setTitle("Laberinto");
//            jf.setSize(900,700);
//            jf.setBounds(0,0,900,700);
//            jf.setLocationRelativeTo(null);
//            kot.setFocusable(true);
//            kot.add(prueba);
//            kot.dibujar(mat);
//            jf.setVisible(true);
//            jf.add(kot);
//            prueba.setLocation(555,400);
//            kot.updateUI();
            
//       
   for (int i = 0; i < limY; i++) {
              for (int j = 0; j < limX; j++) {
                 
                  if(i==0){
                      if(mat[i][j]=='B' || mat[i][j]=='E' || mat[i][j]=='F' || mat[i][j]=='1' || mat[i][j]=='3'|| mat[i][j]=='4') {
                          System.out.println(" salida "+i+" "+j);
                           filas=i;
                           coumnas=j;
                      }
                  }
                   if(i==(limY-1)){
                                if(mat[i][j]=='B' || mat[i][j]=='C' || mat[i][j]=='D' || mat[i][j]=='1'|| mat[i][j]=='2' || mat[i][j]=='3'){
                                    System.out.println(" salida "+i+" "+j);
                                  
                           filaaf=i;
                          coumnasf=j;
                            }
                      }
              }
        }
//          
         InterfLaberinto inte = new InterfLaberinto();
          inte.setVisible(true);
          inte.dibujar(mat);
          try{
                Thread.sleep(10000);
            }catch(Exception v){
                
            }
         
//         int filas=Integer.parseInt(inte.jTextFilas.getText());
//         int coumnas=Integer.parseInt(inte.jTextColumnas.getText());
//         int filaaf=Integer.parseInt(inte.jTextFilaf.getText());
//         int coumnasf=Integer.parseInt(inte.jTextColumnaf.getText());
         
                inte.posci(filas,coumnas);
                inte.repintar();
                imprimir(mat);
                mat[filas][coumnas]='*';
                creator(mat,filas,coumnas,ob,save, ar,"INICIO",ko,filaaf,coumnasf,inte,null,okp);
    }
    
       public static void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
       
    public static void imprimir(char mat[][]){
        
        for (int i = 0; i < limY; i++) {//filas
            for (int j = 0; j < limX; j++) {//columnas
                System.out.print("[ "+mat[i][j]+" ]");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void tamano(){
          File ruta = new File(ruta_txt);
        try{
            
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);
            
            
            String linea = null;
            linea = bu.readLine();
            
             
             StringTokenizer st = new StringTokenizer(linea, "x");
             limY=Integer.parseInt(st.nextToken());
             limX=Integer.parseInt(st.nextToken());
            
            bu.close();
        }catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    public static void cargar_txt(char mat[][]){
         String v1,v2,v3,v4;
         int i=0,j=0;
         
         //char largo
        File ruta = new File(ruta_txt);
        try{
            
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);
            
            
            String linea = null;
            
            linea = bu.readLine();
            
            while((linea = bu.readLine())!=null){
            
              StringTokenizer st = new StringTokenizer(linea, ",|");
               v1=st.nextToken();
               v2=st.nextToken();
               v3=st.nextToken();
               v4=st.nextToken();
               
                System.out.println(v1+v2+v3+v4);
             
               if(v1.equals("1") && v2.equals("2") && v3.equals("3") && v4.equals("4")){
                  mat[i][j]='A';
               }
                if(v1.equals("1") && v2.equals(" ") && v3.equals("3") && v4.equals(" ")){
                       mat[i][j]='B';
               }
                if(v1.equals("1") && v2.equals("2") && v3.equals(" ") && v4.equals(" ")){
                       mat[i][j]='C';
               }
                if(v1.equals(" ") && v2.equals("2") && v3.equals("3") && v4.equals(" ")){
                       mat[i][j]='D';
               }
                if(v1.equals("1") && v2.equals(" ") && v3.equals(" ") && v4.equals("4")){
                       mat[i][j]='E';
               }
                if(v1.equals(" ") && v2.equals(" ") && v3.equals("3") && v4.equals("4")){
                       mat[i][j]='F';
               }
                if(v1.equals(" ") && v2.equals("2") && v3.equals(" ") && v4.equals("4")){
                       mat[i][j]='G';
               }
                 if(v1.equals("1") && v2.equals("2") && v3.equals(" ") && v4.equals("4")){
                       mat[i][j]='H';
               }
                 if(v1.equals(" ") && v2.equals("2") && v3.equals("3") && v4.equals("4")){
                       mat[i][j]='I';
               }
                 if(v1.equals("1") && v2.equals("2") && v3.equals("3") && v4.equals(" ")){
                       mat[i][j]='J';
               }
                  if(v1.equals("1") && v2.equals(" ") && v3.equals("3") && v4.equals("4")){
                       mat[i][j]='K';
               }
                   if(v1.equals("0") && v2.equals("0") && v3.equals("0") && v4.equals("0")){
                       mat[i][j]='M';
               }
                    if(v1.equals("1") && v2.equals(" ") && v3.equals(" ") && v4.equals(" ")){
                       mat[i][j]='1';
               }
                 if(v1.equals(" ") && v2.equals("2") && v3.equals(" ") && v4.equals(" ")){
                       mat[i][j]='2';
               }
                  if(v1.equals(" ") && v2.equals(" ") && v3.equals("3") && v4.equals(" ")){
                       mat[i][j]='3';
               }
                   if(v1.equals(" ") && v2.equals(" ") && v3.equals(" ") && v4.equals("4")){
                       mat[i][j]='4';
               }
               j++;
                if(j==limX){
                    j=0;
                    i++;
                }
                
                
             
            }
            bu.close();
        }catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
        
    }
    public static void creator(char mat[][],int f, int c,List ob,char net[][], nodoar ar,  String estado,lista ko,int ff,int fc,InterfLaberinto inte,String mov,Pila okp) throws InterruptedException{
        
        char [][]aux=mat;
        boolean tr=false;
      
   
//           pil.insertar(mat[f][c]);
//           pil.pop();

        //if( net[f][c]=='M'){
            if(f==ff && c==fc){
          
           
            System.out.println("----------------------");
            System.out.println("Has llegado a la meta");
            System.out.println("----------------------");
            ko.in(estado,f,c);
            solucion(ar,ko);
            ko.mostlis(inte);
            System.out.println("Fin Arbol\n");
           // ob.mostrar();
            Thread.sleep(1800);   
            inte.movelabe2(mov,f,c);    
            Thread.sleep(1800); 
          System.exit(0);
        }else if((tr=memory(ob,mat))==true){
                System.out.println(tr);
                
               
            if (mat != null) {
             
              
            ob.agrinicio(mat);
            ko.in(estado,f,c);
            insert(ar, estado);
//            try{
//                Thread.sleep(800);
//            }catch(Exception v){
//                
//            }
                   mat=movDiagabjder(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
              
               // inte.movelabe(f+1,c+1);
               // inte.movelabe2("ABJDER");
                estado="ABJDER";
                creator(mat,f+1,c+1,ob,net,ar,estado,ko,ff,fc,inte,"ABJDER",okp);  
             }
          
                mat=movAb(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
                
                //inte.movelabe(f+1,c);
              //  inte.movelabe2("ABAJO");
//                System.out.println("Abajo"+f+c);
                estado="ABAJO";
                creator(mat,f+1,c,ob,net,ar,estado,ko,ff,fc,inte,"ABAJO",okp);
            }
            mat= movAr(aux,f,c,net,inte,ko);
            if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
                 
              //  inte.movelabe2("ARRIBA");
                estado="ARRIBA"; 
                
                //inte.movelabe(f-1,c);
                creator(mat,f-1,c,ob,net,ar,estado,ko,ff,fc,inte,"ARRIBA",okp);  
            }
             mat=movDer(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
               // inte.movelabe(f,c+1);
             
             //  inte.movelabe2("DERECHA");
                 System.out.println("mov albe derecha");
                estado="DERECHA";

                creator(mat,f,c+1,ob,net,ar,estado,ko,ff,fc,inte,"DERECHA",okp);  
             }
               
              mat=movDiagabjder(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
              
               // inte.movelabe(f+1,c+1);
               // inte.movelabe2("ABJDER");
                estado="ABJDER";
                creator(mat,f+1,c+1,ob,net,ar,estado,ko,ff,fc,inte,"ABJDER",okp);  
             }
           
            
             mat= movDiagabjizq(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true ){
                imprimir(mat);
                
                //inte.movelabe(f+1,c-1);
              //  inte.movelabe2("ABJIZQ");
                estado="ABJIZQ";
                creator(mat,f+1,c-1,ob,net,ar,estado,ko,ff,fc,inte,"ABJIZQ",okp);  
             }
             
               
          
            mat=movIzq(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
              
               // inte.movelabe(f,c-1);
             //  inte.movelabe2("IZQUIERDA");
                estado="IZQUIERDA";
                creator(mat,f,c-1,ob,net,ar,estado,ko,ff,fc,inte,"IZQUIERDA",okp);
             }
             
              
              mat=movDiagarrizq(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
             
              
               // inte.movelabe(f-1,c-1);
               //inte.movelabe2("ARBIZQ");
                estado="ARBIZQ";
                
                creator(mat,f-1,c-1,ob,net,ar,estado,ko,ff,fc,inte,"ARBIZQ",okp);  
             }
             
             mat=movDiagarrider(aux,f,c,net,inte,ko);
             if(mat!=null && (tr=memory(ob,mat))==true){
                imprimir(mat);
               // inte.movelabe(f-1,c-1);
               // inte.movelabe2("ARBDER");
                estado="ARBDER";
                creator(mat,f-1,c+1,ob,net,ar,estado,ko,ff,fc,inte,"ARBDER",okp);  
             }
             
            
            
             }else{
                
                System.out.println("no prmitido");
            
                   
            }
            ko.ultimo();
        }else{
            
            
            System.out.println("Ciclo");
                
        }
      
        
    }
    public static char[][] movAr(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
          System.out.println("entro ARR");
           char o;
//           if(mat[f][c]=='*'){
//            inte.posci(f, c);
//             sllepy();
//             inte.repintar();
//             ko.ult();
//          }
      if((o=busc(net,f,c))!='C' && (o=busc(net,f,c))!='D' && (o=busc(net,f,c))!='G'&& (o=busc(net,f,c))!='H'&& (o=busc(net,f,c))!='I' && (o=busc(net,f,c))!='J'){
          
      
        if(f!=0 && f>0 && (mat[f-1][c]!='A' && mat[f-1][c]!='G' &&  mat[f-1][c]!='F' && mat[f-1][c]!='E' && mat[f-1][c]!='K'&& mat[f-1][c]!='H' && mat[f-1][c]!='I' && mat[f-1][c]!='4') && mat[f-1][c]!='*' ){
           if(mat[f-1][c]=='M'){
            System.out.println("-------\nHas llegado a la meta\n-------\n");
           
            }
          
            mat[f-1][c]='*';
            System.out.println("Mover arriba con exito");
            return mat;
        }
        
      }else{
           return null;
      }
        return null;
    }
    public static char[][] movAb(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
          System.out.println("entro ABJ");
     char o;
//     if(mat[f][c]=='*'){
//              inte.posci(f, c);
//               sllepy();
//               inte.repintar();
//                ko.ult();
//               
//          }
      if((o=busc(net,f,c))!='F' && (o=busc(net,f,c))!='K' && (o=busc(net,f,c))!='E'&& (o=busc(net,f,c))!='G' && (o=busc(net,f,c))!='I' && (o=busc(net,f,c))!='H' ){
          System.out.println("0="+o);
      
        if(f<(limY-1) && (mat[f+1][c]!='A' && mat[f+1][c]!='G' &&  mat[f+1][c]!='C' && mat[f+1][c]!='D' && mat[f+1][c]!='H'&& mat[f+1][c]!='I'&& mat[f+1][c]!='J' && mat[f+1][c]!='2') && mat[f+1][c]!='*' ){
            
               if(mat[f+1][c]=='M'){
                       System.out.println("-------\nHas llegado a la meta\n-------\n");
           
                 }
            mat[f+1][c]='*';
            System.out.println("Mover abajo con exito");
            return mat;
        
           }
       
      }
        return null;
    }
    
     public static char[][] movIzq(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
         
          char o;
//     if(mat[f][c]=='*'){
//             inte.posci(f, c);
//              sllepy();
//              inte.repintar();
//               ko.ult();
//              
//          }
       if((o=busc(net,f,c))!='B'&& (o=busc(net,f,c))!='E' &&  (o=busc(net,f,c))!='C' && (o=busc(net,f,c))!='H' && (o=busc(net,f,c))!='K' && (o=busc(net,f,c))!='J'){
        if(c!=0 && c>0 && ( mat[f][c-1]!='3'&& mat[f][c-1]!='A'&& mat[f][c-1]!='I'  &&  mat[f][c-1]!='B' && mat[f][c-1]!='H' && mat[f][c-1]!='K'&& mat[f][c-1]!='J' && mat[f][c-1]!='F') && mat[f][c-1]!='*' ){
            if(mat[f][c-1]=='M'){
                       System.out.println("-------\nHas llegado a la meta\n-------\n");
           
        }
            mat[f][c-1]='*';
            System.out.println("Mover izquierda con exito");
            return mat;
        }
        
       }
        return null;
    }
      public static char[][] movDer(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
        
         System.out.println("entro DER");
         char o;
          System.out.println(mat[f][c]+" "+ f+" "+c);
//          if(mat[f][c]=='*'){
//              inte.posci(f, c);
//               sllepy();
//              inte.repintar();
//               ko.ult();
//          }
//             if(mat[f][c+1]=='*' || mat[f+1][c]=='*' || mat[f-1][c]=='*'){
//                   try{
//                Thread.sleep(800);
//            }catch(Exception v){
//                
//            }
//                 inte.movelabe2("der");
////                    tr=true;
////                    System.out.println(true);
//                }
//         if(c<(limX-1)){
//             if(mat[f][c+1]=='*'){
//             inte.movelabe2("der");
//         }
//         }
         
        if((o=busc(net,f,c))!='I'&& (o=busc(net,f,c))!='B' &&  (o=busc(net,f,c))!='D' && (o=busc(net,f,c))!='F' && (o=busc(net,f,c))!='K' && (o=busc(net,f,c))!='J'){
                if(c<(limX-1) && ( mat[f][c+1]!='1'&& mat[f][c+1]!='A'&&mat[f][c+1]!='B'  &&  mat[f][c+1]!='I' && mat[f][c+1]!='J' && mat[f][c+1]!='K' && mat[f][c+1]!='C') && mat[f][c+1]!='*' ){
                    if(mat[f][c+1]=='M'){
                    
                    System.out.println("-------\nHas llegado a la meta\n-------\n");

                    }
                 
                    mat[f][c+1]='*';
                    System.out.println("Mover dereha con exito");
                    return mat;
                }
        }
         
        
          System.out.println("entro derechjvcjh");
         
         return null;
    }
        public static char[][] movDiagarrizq(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
         
          char o;
         System.out.println("entro DIAGARRIZQ");
//         if(mat[f][c]=='*'){
//                inte.posci(f, c);
//                 sllepy();
//             inte.repintar();
//              ko.ult();
//             
//             
//          }
       if((o=busc(net,f,c))!='H' && (o=busc(net,f,c))!='I' && (o=busc(net,f,c))!='C' && (o=busc(net,f,c))!='D'&& (o=busc(net,f,c))!='G' && (o=busc(net,f,c))!='J'){
        if(c>0 &&f>0 && (mat[f-1][c-1]!='A'&& mat[f-1][c-1]!='2'&& mat[f-1][c-1]!='I'  &&  mat[f-1][c-1]!='B' && mat[f-1][c-1]!='K'&& mat[f-1][c-1]!='J' && mat[f-1][c-1]!='F' && mat[f-1][c-1]!='D') && mat[f-1][c-1]!='*' ){
          if(mat[f-1][c]=='D' || mat[f-1][c]=='3' || mat[f-1][c]=='2'){
              
          
            if(mat[f-1][c-1]=='M'){
                       System.out.println("-------\nHas llegado a la meta\n-------\n");
           
            }
            mat[f-1][c-1]='*';
            System.out.println("Mover Arriba izquierda con exito");
            return mat;
          }
        
        }
       }
        return null;
    }
          public static char[][] movDiagabjizq(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
         
          char o;
          
         System.out.println("entro DIAGABJIZQ");
//         if(mat[f][c]=='*'){
//               inte.posci(f, c);
//               sllepy();
//             inte.repintar();
//              ko.ult();
//            
//
//          }
              
       if((o=busc(net,f,c))!='H' && (o=busc(net,f,c))!='I' && (o=busc(net,f,c))!='G'&& (o=busc(net,f,c))!='E' && (o=busc(net,f,c))!='F' && (o=busc(net,f,c))!='K'){
          
        if(c>0 && f<(limY-1) && (mat[f+1][c-1]!='A'&& mat[f+1][c-1]!='I'  &&  mat[f+1][c-1]!='B' && mat[f+1][c-1]!='K'&& mat[f+1][c-1]!='J' && mat[f+1][c-1]!='F'  && mat[f+1][c-1]!='D') && mat[f+1][c-1]!='*' ){
            
          if(mat[f+1][c]=='F' || mat[f+1][c]=='3'|| mat[f+1][c]=='4'){
            if(mat[f+1][c-1]=='M'){
                       System.out.println("-------\nHas llegado a la meta\n-------\n");
           
            }
            mat[f+1][c-1]='*';
            System.out.println("Mover Abajo izquierda con exito");
              
            return mat;
         }
        }
       }
         
        return null;
    }
     public static char[][] movDiagabjder(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
         
          char o;
//         System.out.println("entro DIAGABJDER");
//         if(mat[f][c]=='*'){
//               inte.posci(f, c);
//               sllepy();
//             inte.repintar();
//              ko.ult();
//              
//
//          }
            
       if((o=busc(net,f,c))!='H' && (o=busc(net,f,c))!='I' && (o=busc(net,f,c))!='G'&& (o=busc(net,f,c))!='E' && (o=busc(net,f,c))!='F' && (o=busc(net,f,c))!='K'){
          
        if(c<(limX-1) && f<(limY-1) && (mat[f+1][c+1]!='A'&& mat[f+1][c+1]!='H'  &&  mat[f+1][c+1]!='B' && mat[f+1][c+1]!='C'&& mat[f+1][c+1]!='E' && mat[f+1][c+1]!='J'&& mat[f+1][c+1]!='K') && mat[f+1][c+1]!='*' ){
            
            if(mat[f+1][c]=='E' || mat[f+1][c]=='1'|| mat[f+1][c]=='4'  ){
            if(mat[f+1][c+1]=='M'){
                       System.out.println("-------\nHas llegado a la meta\n-------\n");
           
            }
            mat[f+1][c+1]='*';
            System.out.println("Mover Abajo derecha con exito");
              
            return mat;
            }
        }
       }
         
        return null;
    }
     
     public static char[][] movDiagarrider(char mat[][],int f,int c,char net[][],InterfLaberinto inte,lista ko){
         
          char o;
         System.out.println("entro DIAGARRDER");
//         if(mat[f][c]=='*'){
//            inte.posci(f, c);
//            sllepy();
//             inte.repintar();
//             ko.ult();
//             
//          }
       if((o=busc(net,f,c))!='H' && (o=busc(net,f,c))!='I' && (o=busc(net,f,c))!='C' && (o=busc(net,f,c))!='D'&& (o=busc(net,f,c))!='G' && (o=busc(net,f,c))!='J'){
          if(c<(limX-1) && f>0 && (mat[f-1][c+1]!='A'&& mat[f-1][c+1]!='H'  &&  mat[f-1][c+1]!='B' && mat[f-1][c+1]!='K'&& mat[f-1][c+1]!='J' && mat[f-1][c+1]!='C' && mat[f-1][c+1]!='E') && mat[f-1][c+1]!='*' ){
          if(mat[f-1][c]=='C' || mat[f-1][c]=='1'|| mat[f-1][c]=='2'){
              
          
            if(mat[f-1][c+1]=='M'){
                       System.out.println("-------\nHas llegado a la meta\n-------\n");
            }
            mat[f-1][c+1]='*';
            System.out.println("Mover Arriba derecha con exito");
            return mat;
          }
        
        }
       }
        return null;
    }
     
        public static boolean memory(List ob, char ed[][]) {
        Nodo aux = ob.inicio;
            System.out.println("memory");
//            System.out.println(aux.nombre);
        while (aux != null) {
            if (Arrays.equals(ob.cades,ed)) {
                
                return false;
            }
            aux = aux.siguiente;
        }
        return true;
    }
        public static char busc(char net[][],int f,int c){
       
           return net[f][c];
        }
       public static void insert(nodoar ar, String x) {
        ar.agrenodohijo(x, ar);
       
    }
     public static void solucion(nodoar a,lista ob) {
         
       
        nodoar aux = a;
        while (aux != null) {
            for (int i = 0; i < 4; i++) {
                System.out.print(aux.dato);
                   
                insert(a, aux.dato);   
            }
            System.out.println("");
           aux = aux.pad;
        }
        
        System.out.println("Arbol Final");
        
        
    
       
      }
     public static void libre(char mat[][]){
         for (int i = 0; i < 5; i++) {
             for (int j = 0; j < 5; j++) {
                 if(mat[i][j]!='A' && mat[i][j]!='*' ){
                     System.out.println("ósojcdionJW "+i+"  "+j);
                 }
             }
         }
     }
      public static void sllepy(){
            try{
                Thread.sleep(300);
            }catch(Exception v){
                
            }
      }
       
}
