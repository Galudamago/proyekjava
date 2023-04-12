package org.example.controller;

import org.example.service.IBarangService;

import java.util.Scanner;

public class BarangController implements IBarangController{

    private IBarangService barangService;

    Scanner in = new Scanner(System.in);

    public BarangController(IBarangService barangService){this.barangService = barangService;}

//    public void mainMenu(){
//        boolean run = true;
//        while (run){
//        System.out.println("Main menu");
//        System.out.println("1. Add Barang");
//        System.out.println("2. Get all barang");
//        System.out.println("3. Get barang by name");
//        System.out.println("4. Delete barang by id");
//        System.out.println("5. Exit ");
//
//        var menu = in.next();
//
//        if(!menu.matches("[1-5]")){
//            System.out.println("Menu tidak tersedia");
////                break;
//        }
//        else{
//            switch (menu){
//                case "1":
//                    addBarang();
//                    break;
//                case "2":
//                    getAllBarang();
//                    break;
//                case "3":
//                    System.out.println("Masukkan nama barangnya");
//                    var nama = in.next();
//                    searchBarangByName(nama);
//                    break;
//                case "4":
//                    System.out.println("Masukkan id barangnya");
//                    var id = in.nextInt();
//                    deleteBarang(id);
//                    break;
//                case "5":
//                    System.out.println("Terimakasih sudah menggunakan aplikasi ini...");
//                    run = false;
//                    break;
//            }
//
//        }
//    }
//    }

    @Override
    public void addBarang() {
        System.out.println("Silahkan masukkan kode barang");

        int barangId = in.nextInt();

        System.out.println("Silahkan masukkan nama barang");

        String barangName = in.next();

        System.out.println("Silahkan masukkan stok barang");

        int barangStok = in.nextInt();
        System.out.println(barangId);
        System.out.println(barangName);
        System.out.println(barangStok);
        barangService.add(barangId,barangName,barangStok);
    }

    @Override
    public void getAllBarang() {
        barangService.getAll();
    }

    @Override
    public void searchBarangByName(String name) {
        barangService.searchByName(name);
    }

    @Override
    public void deleteBarang(int id) {
        System.out.println("Masukkan id barang yang ingin dihapus");
        barangService.delete(id);
    }
}
