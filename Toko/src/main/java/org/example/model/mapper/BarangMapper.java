package org.example.model.mapper;

import org.example.model.Barang;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BarangMapper implements RowMapper<Barang> {

    @Override
    public Barang mapRow(ResultSet rs, int rowNum) throws SQLException {
        Barang barang = new Barang();

        barang.setId(rs.getInt("id"));
        barang.setNama(rs.getString("nama"));
        barang.setStock(rs.getInt("stok"));

        return barang;
    }
}
