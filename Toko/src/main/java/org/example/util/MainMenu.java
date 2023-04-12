package org.example.util;

import org.example.controller.BarangController;
import org.example.controller.IBarangController;

import java.util.Scanner;

public class MainMenu {
    private Scanner in = new Scanner(System.in);
    private IBarangController barangController;

    public MainMenu(IBarangController barangController){this.barangController = barangController;}

    public void menuUtama() throws Exception {
        boolean run = true;
        while (run){
            System.out.println("Main menu");
            System.out.println("1. Add Barang");
            System.out.println("2. Get all barang");
            System.out.println("3. Get barang by name");
            System.out.println("4. Delete barang by id");
            System.out.println("5. Exit ");

            var menu = in.next();

            if(!menu.matches("[1-5]")){
                System.out.println("Menu tidak tersedia");
//                break;
            }
            else{
                switch (menu){
                    case "1":
                        barangController.addBarang();
                        break;
                    case "2":
                        barangController.getAllBarang();
                        break;
                    case "3":
                        System.out.println("Masukkan nama barangnya");
                        var nama = in.next();
                        barangController.searchBarangByName(nama);
                        break;
                    case "4":
                        System.out.println("Masukkan id barangnya");
                        var id = in.nextInt();
                        barangController.deleteBarang(id);
                        break;
                    case "5":
                        System.out.println("Terimakasih sudah menggunakan aplikasi ini...");
                        run = false;
                        break;
                }

            }
        }

    }
}
