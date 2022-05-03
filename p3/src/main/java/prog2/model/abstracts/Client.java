package main.java.prog2.model.abstracts;

public abstract class Client {
    
    private String email;
    private String nom;
    private String adreca;

    
    public Client() {}
    public Client(String email, String nom, String adreca) {
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
    }
    
    //Getters and setters
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getAdreca() {
        return this.adreca;
    }
    
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public abstract String tipusClient();
    public abstract float calcMensual();
    public abstract float descompteEnv();

    public String toString() {
        return "Tipus=" + tipusClient() + ", Email=" + email +
            ", Nom=" + nom + ", Adreça=" + adreca + ", Descompte Enviament="
            + descompteEnv() + ", Mensualitat=" + calcMensual();
    }
}
