package org.example.service;

import org.example.model.Barang;
import org.example.repo.IBarangRepo;

public class BarangService implements IBarangService{

    private IBarangRepo barangRepo;

    public BarangService(IBarangRepo barangRepo) {
        this.barangRepo = barangRepo;
    }

    @Override
    public void getAll(){
        for(var barang :barangRepo.getAll()){
            System.out.println(barang);
        }
    }

    @Override
    public void searchByName(String name) {
        for(var barang : barangRepo.searchByName(name)){
            System.out.println(barang);
        }
    }

    @Override
    public void add(int id, String name, int stok) {
        Barang barang =new Barang(id,name,stok);
        barangRepo.add(barang);
    }

    @Override
    public void delete(int id) {
        try {
            barangRepo.delete(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
