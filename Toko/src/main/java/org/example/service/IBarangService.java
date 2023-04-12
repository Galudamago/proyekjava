package org.example.service;

import org.example.model.Barang;

import java.util.List;

public interface IBarangService {

    void getAll();

    void searchByName(String name);

    void add(int id, String name, int stok);

    void delete(int id);

}
