package model;

import java.io.Serializable;
import model.abstracts.Llista;
import vista.MercatException;

public class LlistaArticles extends Llista<Article> implements Serializable {
    
    @Override
    public void afegir(Article article) throws MercatException {
        for (Article art : llista) {
            if (art.getID() == article.getID()) throw new MercatException("Ja existeix un article amb el mateix identificador.");
        }
        llista.add(article);
    }
    
    public String toStringWIndex(){
        String result = "";
        int index = 1;
        for (Article article : llista) {
            result = result + index +". "+ article.toString() +"\n";
            index++;
        }
        return result;
    }

    public String toString(){
        String result = "";
        for (Article article : llista) {
            result = result + article.toString() +"\n";
        }
        return result;
    }
}
