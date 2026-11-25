package model;

import exception.ComandaException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Comanda {

    private Integer id;
    private LocalDate data;
    private double total;
    private Client client;
    private List<Producte> productes;

    public Comanda(Integer id, LocalDate data, Client client, List<Producte> productes) {
        if(id != null){this.id = id;}
        this.data = data;
        if(client == null){throw new ComandaException("El client no pot ser null");}
        this.client = client;
        if(productes != null){
            for (Producte producte : productes) {
                this.total += producte.getPreu();
            }
            this.productes = productes;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Producte> getProductes() {
        return productes;
    }

    public void setProductes(List<Producte> productes) {
        this.productes = productes;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Comanda comanda)) return false;
        return Double.compare(total, comanda.total) == 0 && Objects.equals(id, comanda.id) && Objects.equals(data, comanda.data) && Objects.equals(client, comanda.client) && Objects.equals(productes, comanda.productes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, total, client, productes);
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", data=" + data +
                ", total=" + total +
                ", client=" + client +
                ", productes=" + productes +
                '}';
    }
}
