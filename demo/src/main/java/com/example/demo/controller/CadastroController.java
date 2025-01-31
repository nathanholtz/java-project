package com.example.demo.controller;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.model.ClienteService;





@Controller
public class CadastroController {
    @Autowired
    ApplicationContext context;

    @GetMapping("/")
    public String homeListagem(Model model){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Cliente> clis = cs.obterCLientes();
        model.addAttribute("clientes", clis);
        return "home";
    }

    @GetMapping("/cadastroCliente")
    public String cadastroCliente(Model model){
        Cliente c = new Cliente();
        model.addAttribute("cliente", c);
        return "cadastroCliente";
    }

    @PostMapping("/cadastroCliente")
    public String cadastroCliente(@ModelAttribute Cliente c){

        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserirCliente(c);
        return "sucesso";
    }

    @GetMapping("/atualizar/{id}")
public String atualizar(Model model, @PathVariable("id") int id) {
    ClienteService cs = context.getBean(ClienteService.class);
    Cliente antigo = cs.pegarCliente(id); 
    model.addAttribute("cliente", antigo); 
    return "atualizar"; 
}

    @PostMapping("/atualizar/{id}") 
    public String atualizarCliente(@ModelAttribute Cliente cli, @PathVariable("id") int id){
        ClienteService cs = context.getBean(ClienteService.class);

        cs.atualizarCliente(id, cli);
        return "redirect:/";
    }

    @PostMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable("id") int id){

        ClienteService cs = context.getBean(ClienteService.class);

        cs.deletarCliente(id);

        return "redirect:/";
    }

}
