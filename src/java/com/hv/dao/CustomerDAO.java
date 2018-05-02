/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hv.dao;

import com.hv.entity.Customer;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HoaiVu
 */
@Repository
public class CustomerDAO {

    /**
     * Inject từ <bean class="...JdbcTemplate>
     */
    @Autowired
    protected JdbcTemplate jdbc;

    /**
     * Truy vấn 1 thực thể theo mã
     *
     * @param id mã thực thể cần truy vấn
     * @return thực thể truy vấn được
     */
    public Customer getById(Serializable id) {
        String sql = "SELECT * FROM Login WHERE Id=?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }
    /**
     * Truy vấn tất cả các thực thể
     *
     * @return danh sách thực thể truy vấn được
     */
    public List<Customer> getAll() {
        String sql = "SELECT * FROM Login";
        return getBySql(sql);
    }

    /**
     * Truy vấn các thực thể theo câu lệnh sql
     *
     * @param sql câu lệnh truy vấn
     * @return danh sách thực thể truy vấn được
     */
    protected List<Customer> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    /**
     * Ánh xạ cấu trúc bản ghi theo thuộc tính của bean
     *
     * @return ánh xạ bản ghi theo thuộc tính bean
     */
    private RowMapper<Customer> getRowMapper() {
        return new BeanPropertyRowMapper<Customer>(Customer.class);
    }

}
