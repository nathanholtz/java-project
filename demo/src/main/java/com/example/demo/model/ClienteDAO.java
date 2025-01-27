package com.example.demo.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
   @Autowired
   DataSource dataSource;
   JdbcTemplate jbdc;
   
   @PostConstruct
   private void initialize(){
    jbdc = new JdbcTemplate(dataSource);
   }

   public void inserirCliente(Cliente c) {
    String sql = "INSERT INTO cliente(nome,email) VALUES(?, ?)";
    jbdc.update(sql, c.getNome(), c.getEmail());
   }
}
