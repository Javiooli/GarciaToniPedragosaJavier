package prog2.model.abstracts;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.Serializable;

import prog2.model.Article;

public abstract class Comanda implements Serializable{
    protected Article article;
    protected Client client;
    protected int quantitat;
    protected Date data;
    protected boolean enviat;
    protected boolean rebuda;

    
    
    public Comanda() {}
    public Comanda(Article article, Client client, int quantitat) {
        this.article = article;
        this.client = client;
        this.quantitat = quantitat;
        this.data = new Date();
        this.enviat = false;
        this.rebuda = false;
    }
    
    //Getters and setters
    public Article getArticle() {
        return this.article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }
    
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public int getQuantitat() {
        return this.quantitat;
    }
    
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public abstract String tipusComanda();
    public abstract boolean comandaEnviada();
    public abstract boolean comandaRebuda();
    public abstract float preuEnviament();

    public float calcPreu() {
        return this.article.getPreu() * quantitat;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        return "Tipus = " + tipusComanda() + ", Article = " + article.getNom() + ", Client = " +
            client.getNom() + ", Quantitat = " + quantitat + ", Data de creacio = " +
            formatter.format(data) + ", Enviat = " + comandaEnviada() + ", Rebuda = " + comandaRebuda() + ", Preu Articles = "
            + calcPreu() + ", Preu Enviament = " + preuEnviament();
    }
}
