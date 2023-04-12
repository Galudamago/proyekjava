package org.example.repo;

import org.example.model.Barang;

import java.util.ArrayList;
import java.util.List;

public interface IBarangRepo {

    void add(Barang barang);

    List<Barang> getAll();

    ArrayList<Barang> searchByName(String name);

    void delete(int id);

}
