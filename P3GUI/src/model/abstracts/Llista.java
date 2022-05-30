package model.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import vista.MercatException;

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

      public void esborrar(int position) throws MercatException {
            if (isEmpty()) throw new MercatException("La llista està buida.");
            else{
                llista.remove(position);
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
