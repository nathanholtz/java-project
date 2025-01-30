package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

   public static Cliente converter(Map<String, Object> reg) {
      Cliente cliente = new Cliente();
      cliente.setId((Integer) reg.get("id"));
      cliente.setNome((String) reg.get("nome"));
      cliente.setEmail((String) reg.get("email"));
      return cliente;
  }

   public void inserirCliente(Cliente c) {
    String sql = "INSERT INTO cliente(nome,email) VALUES(?, ?)";
    jbdc.update(sql, c.getNome(), c.getEmail());
   }

   public  List<Cliente> obterCLientes(){
      String sql = "SELECT * FROM cliente;";

      List<Map<String,Object>> registros = jbdc.queryForList(sql); 

      ArrayList<Cliente> aux = new ArrayList<Cliente>();

      for(Map<String,Object> reg : registros){
         aux.add(converter(reg));
      }
      return aux;
   }


   @SuppressWarnings("deprecation")
   public Cliente pegarCliente(int id) {
    String sql = "SELECT * FROM cliente WHERE id = ?";

    try {
        return jbdc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            return cliente;
        });
    } catch (EmptyResultDataAccessException e) {
        
        return null; 
    }
}

   public void atualizarCliente(int id, Cliente novo){
      String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";

      jbdc.update(sql, novo.getNome(), novo.getEmail(), id);
   }
}
