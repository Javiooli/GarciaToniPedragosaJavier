package main.java.prog2.model;
import prog2.model.abstracts.Llista;

public class LlistaArticles extends Llista<Article> implements Serializable {
    
    @Override
    public void afegir(Article article) throws MercatException {
        for (Article art : llista) {
            if (art.getID() == article.getID()) throw new MercatException("Ja existeix un article amb el mateix identificador.");
        }
        llista.add(article);
    }
}
