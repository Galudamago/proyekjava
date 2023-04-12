package org.example.repo;

import org.example.model.Barang;
import org.example.model.mapper.BarangMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BarangRepo implements IBarangRepo {

    private JdbcTemplate jdbcTemplate;

    private final String SQL_GET_ALL = "SELECT * FROM barang";

    private final String SQL_INSERT_BARANG = "INSERT INTO barang VALUES (?,?,?)";

//    private final String SQL_FIND_BY_ID = "SELECT * FROM barang WHERE barang_id";

    private final String SQL_DELETE_BY_ID = "DELETE FROM barang WHERE barang_id";

    private ArrayList<Barang> barangs = new ArrayList<>();

    Scanner inputRepo = new Scanner(System.in);

    public BarangRepo(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public void add(Barang barang) {
        try {
            int result = jdbcTemplate.update(SQL_INSERT_BARANG,barang.getId(),barang.getNama(),barang.getStock());
            if(result <= 0){
                System.out.println("Failed to add barang");
            }
            barangs.add(barang);
        }catch (DataAccessException e){
            System.out.println("Failed to add barang");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Barang> getAll(){
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new BarangMapper());
        }catch (DataAccessException e){
            System.out.println("Failed to get barang");
            System.out.println(e.getMessage());
        }
        return jdbcTemplate.query(SQL_GET_ALL, new BarangMapper());
    }

    @Override
    public ArrayList<Barang> searchByName(String name) {
        ArrayList<Barang> barangName = new ArrayList<>();
        for (Barang element : barangs) {
            if (element.getNama().equals(name)) {
                barangName.add(element);
            }
        }
        return barangName;
    }

    @Override
    public void delete(int id) {
        try{
            jdbcTemplate.update(SQL_DELETE_BY_ID,id);
        }catch (DataAccessException e){
            System.out.println("Failed to delete book");
            System.out.println(e.getMessage());
        }
    }
}
