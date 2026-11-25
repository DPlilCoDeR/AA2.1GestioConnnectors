package model;

import exception.ProducteException;

import java.util.Objects;

public class Producte {

    private Integer id;
    private String nom;
    private double preu;
    private int stock;

    public Producte(Integer id, String nom, double preu, int stock) throws ProducteException {
        if(id != null){ this.id = id;}
        if (nom == null || preu <= 0 || stock <= 0){throw new ProducteException("Falta dades.");}
        this.nom = nom;
        this.preu = preu;
        this.stock = stock;
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

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producte producte)) return false;
        return Double.compare(preu, producte.preu) == 0 && stock == producte.stock && Objects.equals(id, producte.id) && Objects.equals(nom, producte.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, preu, stock);
    }

    @Override
    public String toString() {
        return "Producte{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", preu=" + preu +
                ", stock=" + stock +
                '}';
    }
}
