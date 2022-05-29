package model;

import model.abstracts.Client;
import model.abstracts.Comanda;
import java.util.Date;

public class ComandaUrgent extends Comanda {
    
    public ComandaUrgent() {}
    public ComandaUrgent(Article article, Client client, int quantitat) {
        super(article, client, quantitat);
    }

    public String tipusComanda() {
        return "Urgent";
    }
    
    public boolean comandaEnviada() {
        Date now = new Date();
        long tempsTotalEnviament = (long)article.getTemps()*60*1000/2; 
        if (tempsTotalEnviament <= now.getTime()-this.data.getTime()) this.enviat = true;
        return this.enviat;
    }
    public boolean comandaRebuda() {
        Date now = new Date();
        long tempsTotalRecepcio = (long)article.getTemps()*60*1000 + 1000*60*60*24; //temps fins enviament en minuts a milisegons + 1 dia en milisegons.
        if (tempsTotalRecepcio <= now.getTime() - this.data.getTime()) this.rebuda = true;
        return this.rebuda;
    }

    public float preuEnviament() {
        if (this.client.tipusClient().equalsIgnoreCase("premium")) return calcPreu() + 4 - (this.client.descompteEnv()/100)*4;
        else return calcPreu() + 4;
    }

}
