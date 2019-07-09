package agentlaberinto;
/**
 * @author CharlyValliere
 */
public class listanodoar {
    nodolisar inicio;
    int cont;
    listanodoar() {
        inicio = null;
        cont = 0;
    }
    

    public  nodolisar inhi(String x, nodoar pad) {
        
        nodolisar nuevo = new nodolisar();
        if (inicio == null) {
            inicio = new nodolisar();
            inicio.ins(x, pad);
        } else {
            nodolisar tmp;
            tmp = inicio;
            while (tmp.siguiente != null) {
                tmp = tmp.siguiente;
            }
            tmp.siguiente = nuevo;
            tmp.siguiente.ins(x, pad);
        }
        return inicio;
    }

     public nodoar most(nodolisar  mst){
        mst=inicio;
        if (mst.siguiente != null) {
            while (mst.siguiente != null) {
                System.out.println(mst);
                mst = mst.siguiente;
            }
        }
        return mst.aq;
    }
    
    public nodoar buscando(){
        nodolisar mst;
        mst=inicio;
        if (mst.siguiente != null) {
            while (mst.siguiente != null) {
                mst = mst.siguiente;
            }
        }
        return mst.aq;
    }
    
}
