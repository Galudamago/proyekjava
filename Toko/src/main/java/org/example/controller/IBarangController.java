package org.example.controller;

public interface IBarangController {
    void addBarang();

    void getAllBarang();

    void searchBarangByName(String name);

    void deleteBarang(int id);
}
