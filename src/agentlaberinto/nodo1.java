package agentlaberinto;

public class nodo1 {

    String dato;
    int f, c;
    nodo1 siguiente;
    int nhi; 
    public nodo1() {
        siguiente = null;
        dato = null;
        f=0;
        c=0;
        nhi=0;
    }

    public void in(String dato,int f,int c) {
        this.dato = dato;
        this.f=f;
        this.c=c;
    }

    public String obt() {
        return dato;
    }
  
     public int fil() {
        return f;
    }
  
      public int col() {
        return c;
    }
  

}
