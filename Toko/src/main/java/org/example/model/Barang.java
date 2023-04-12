package org.example.model;

public class Barang {

    int id;

    String nama;

    int stock;

    public Barang(int id, String nama, int stock) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
    }

    public Barang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", stock=" + stock +
                '}';
    }
}
