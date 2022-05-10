package prog2.model;

import java.io.Serializable;
import prog2.model.abstracts.Llista;
import prog2.vista.MercatException;

public class LlistaArticles extends Llista<Article> implements Serializable {
    
    @Override
    public void afegir(Article article) throws MercatException {
        for (Article art : llista) {
            if (art.getID() == article.getID()) throw new MercatException("Ja existeix un article amb el mateix identificador.");
        }
        llista.add(article);
    }
    @Override
    public String toString(){
        String result = "";
        int index = 1;
        for (Article article : llista) {
            result = result + index +". "+ article.toString() +"\n";
            index++;
        }
        return result;
    }
}
