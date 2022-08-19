package com.digitalinnovationone.RESTSpring.controller;


import com.digitalinnovationone.RESTSpring.entity.Produto;
import com.digitalinnovationone.RESTSpring.exception.ProductNullException;
import com.digitalinnovationone.RESTSpring.exception.ProductPriceException;
import com.digitalinnovationone.RESTSpring.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;



    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {

        if(produto.getNome() == null || produto.getPreco() == null)
            throw new ProductNullException();

        if(produto.getPreco() < 0)
            throw new ProductPriceException();


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
