package prog2.model.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.MercatException;

public class Llista<T> implements Serializable {
      protected ArrayList<T> llista;

      public Llista() {        
            llista = new ArrayList<>();
      }

      public Llista(Llista<T> original) {
            llista = original.getArrayList();
      }

      public int getSize() {
            return llista.size();
      }

      //TODO: Excepció
      public void afegir(T t) throws MercatException {
            llista.add(t);
      }

      public void esborrar(T t) throws MercatException {
            if (isEmpty()) throw new MercatException("La llista està buida.");
            else{
                ArrayList<T> llistaNova = new ArrayList<T>();
                for (T obj : llista) {
                      if (!t.equals(obj)) llistaNova.add(obj);
                }
                this.llista = llistaNova;
            }
      }

      public T getAt(int position) {
            return llista.get(position);
      }

      public void clear() {
            llista.clear();
      }

      public boolean isEmpty() {
            return llista.isEmpty();
      }

      public ArrayList<T> getArrayList() {
            ArrayList<T> arrlist = new ArrayList<>(llista);
            return arrlist;
      }
}