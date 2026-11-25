package model;

import exception.ClientException;

import java.util.Objects;

public class Client {

    private Integer id;
    private String nom = "";
    private String email = "";
    private String telefon = "";

    public Client(Integer id, String nom, String email, String telefon) throws ClientException {
        if (id != null){
            this.id = id;
        }
        if (nom == null || email == null || telefon == null){throw new ClientException("Falta dades.");}
        this.nom = nom;
        this.email = email;
        this.telefon = telefon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id) && Objects.equals(nom, client.nom) && Objects.equals(email, client.email) && Objects.equals(telefon, client.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, telefon);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
