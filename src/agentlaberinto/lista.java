package agentlaberinto;

import java.util.Arrays;

/**
 * @author CharlyValliere
 */
public class lista {

    nodo1 inicio;

    lista() {
        inicio = null;
    }

    public void in(String x,int f, int c) {
        nodo1 nuevo = new nodo1();
        nuevo.in(x,f,c);
        if (inicio == null) {
            inicio = new nodo1();
            inicio.in(x,f,c);
        } else {
            nodo1 tmp;
            tmp = inicio;
            while (tmp.siguiente != null) {
                tmp = tmp.siguiente;
            }
            tmp.siguiente = nuevo;
            tmp.siguiente.in(x,f,c);
        }
    }

    public void mostlis(InterfLaberinto inte) {
        nodo1 mst;
        mst = inicio;

        if (inicio != null) {
            while (mst.siguiente != null) {
                System.out.println(mst.obt());
                        try{
                      Thread.sleep(800);
                  }catch(Exception v){

                  }
                inte.movelabe2(mst.obt(),mst.fil(),mst.col());
                mst = mst.siguiente;
            }
            System.out.println(mst.obt());
        }
    }

    public void ult() {
        nodo1 mst;
        mst = inicio;
        if (mst.siguiente != null) {
            while (mst.siguiente != null) {
                mst = mst.siguiente;
            }
            System.out.println(mst.obt());
        }
    }
   public void ultimo() {
        nodo1 mst,T=null;
        mst = inicio;
          while(mst.siguiente!=null){
              T=mst;
              mst=mst.siguiente;
          }
          T.siguiente=null;
    }
    public String ultre() {
        nodo1 mst;
        mst = inicio;
        while (mst.siguiente != null) {
            mst = mst.siguiente;
        }
        return mst.obt();
    }
}
