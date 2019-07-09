package agentlaberinto;
/**
 * @author CharlyValliere
 */
public class nodoar {
    listanodoar nodos;
    String dato;
    
    int niv;
    nodoar pad;
    
    nodoar(String d, nodoar pa) {
        dato = d;
        pad=pa;
        nodos = new listanodoar();
    }
    public void agrenodohijo(String x, nodoar pad) {
        nodolisar po=null;
        po=nodos.inhi(x,pad);
//        System.out.println("Nodoss lista");
//        System.out.println(pad);
       
        
    }
    public  void most(nodoar a){
         nodoar au = a;
        //int cont=1;
        if (au!=null) {
            while(au!=null){
                System.out.println(a.dato);
                au=au.pad;
            }
        }
    }
    
    public void ult(nodoar a){
        nodoar au = a;
        int cont=1;
        if (a!=null) {
            while(a!=null){
                a = nodos.buscando();
            }
        }
    }
}
