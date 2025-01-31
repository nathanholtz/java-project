package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired 
    ClienteDAO cdao;
    public void inserirCliente(Cliente c){
        cdao.inserirCliente(c);
    }  

    public List<Cliente> obterCLientes(){
        return cdao.obterCLientes();
    }

    public Cliente pegarCliente(int id){
        return cdao.pegarCliente(id);
    }

    public void atualizarCliente(int id, Cliente novo){
        cdao.atualizarCliente(id, novo);
    }

    public void deletarCliente(int id){
        cdao.deletarCliente(id);
    }
}
