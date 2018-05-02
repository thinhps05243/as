/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hv.dao;

import com.hv.entity.Demo;
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
public class DemoDAO {

    /**
     * Inject từ <bean class="...JdbcTemplate>
     */
    @Autowired
    protected JdbcTemplate jdbc;

    /**
     * Thêm mới 1 thực thể
     *
     * @param demo
     * @param entity là thực thể mới
     */
    public void insert(Demo stu) {
        String sql = "INSERT INTO Forums (Id, Name, Decription) VALUES (?,?,?)";
        jdbc.update(sql, stu.getId(), stu.getName(), stu.getDecription());
    }

    /**
     * Cập nhật thực thể
     *
     * @param entity là thực thể cần cập nhật
     */
    public void update(Demo stu) {
        String sql = "UPDATE Forums SET Name=?, Decription=? WHERE Id=?";
        jdbc.update(sql, stu.getName(), stu.getDecription(), stu.getId());
    }

    /**
     * Xóa thực thể theo mã
     *
     * @param id mã thực thể cần xóa
     */
    public void delete(Serializable id) {
        String sql = "DELETE FROM Forums WHERE Id=?";
        jdbc.update(sql, id);
    }

    /**
     * Truy vấn 1 thực thể theo mã
     *
     * @param id mã thực thể cần truy vấn
     * @return thực thể truy vấn được
     */
    public Demo getById(Serializable id) {
        String sql = "SELECT * FROM Forums WHERE Id=?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    /**
     * Truy vấn tất cả các thực thể
     *
     * @return danh sách thực thể truy vấn được
     */
    public List<Demo> getAll() {
        String sql = "SELECT * FROM Forums";
        return getBySql(sql);
    }

    /**
     * Truy vấn các thực thể theo câu lệnh sql
     *
     * @param sql câu lệnh truy vấn
     * @return danh sách thực thể truy vấn được
     */
    protected List<Demo> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    /**
     * Truy vấn thực thể theo tên
     *
     * @param name tên của thực thể cần truy vấn
     * @return danh sách thực thể truy vấn được
     */
    public List<Demo> getByName(String name) {
         String sql = "SELECT * FROM Forums WHERE Name LIKE ?";
        return jdbc.query(sql, getRowMapper(), "%" + name + "%");
    }

    /**
     * Ánh xạ cấu trúc bản ghi theo thuộc tính của bean
     *
     * @return ánh xạ bản ghi theo thuộc tính bean
     */
    private RowMapper<Demo> getRowMapper() {
        return new BeanPropertyRowMapper<Demo>(Demo.class);
    }

}
