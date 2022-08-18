package com.digitalinnovationone.RESTSpring.controller;


import com.digitalinnovationone.RESTSpring.entity.Produto;
import com.digitalinnovationone.RESTSpring.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;



    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {

        produto = produtoService.save(produto);

        return ResponseEntity.ok().body(produto);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){

        Produto produto = produtoService.findById(id);

        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos(){

        List<Produto> produtos = produtoService.findAll();

        return ResponseEntity.ok().body(produtos);
    }

}
