package agentlaberinto;

public class nodolisar {
    nodolisar siguiente;
    nodoar aq; 
    public nodolisar() {
        siguiente = null;
        aq = null;
    }

    public void ins(String dato, nodoar pad) {
        aq = new nodoar(dato, pad);
    }
    
}
