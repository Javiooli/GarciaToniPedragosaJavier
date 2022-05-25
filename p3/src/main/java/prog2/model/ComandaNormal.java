package prog2.model;

import prog2.model.abstracts.Client;
import prog2.model.abstracts.Comanda;
import java.util.Date;

public class ComandaNormal extends Comanda {
    
    public ComandaNormal() {}
    public ComandaNormal(Article article, Client client, int quantitat) {
        super(article, client, quantitat);
    }

    public String tipusComanda() {
        return "Normal";
    }
    public boolean comandaEnviada() {        
        Date now = new Date();
        long tempsTotalEnviament = (long)article.getTemps()*60*1000; 
        if (tempsTotalEnviament <= now.getTime()-this.data.getTime()) this.enviat = true;
        return this.enviat;
    }
    public boolean comandaRebuda() {
        Date now = new Date();
        long tempsTotalRecepcio = (long)article.getTemps()*60*1000 + 1000*60*60*24*4; //temps fins enviament en minuts a milisegons + 4 dies en milisegons.
        if (tempsTotalRecepcio <= now.getTime() - this.data.getTime()) this.rebuda = true;
        return this.rebuda;
    }

    public float preuEnviament() {
        if (this.client.tipusClient().equalsIgnoreCase("premium")) return calcPreu() + 1-this.client.descompteEnv()/100;
        else return calcPreu() + 1;
    }

}
