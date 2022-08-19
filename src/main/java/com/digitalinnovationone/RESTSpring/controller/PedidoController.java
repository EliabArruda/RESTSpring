package com.digitalinnovationone.RESTSpring.controller;

import com.digitalinnovationone.RESTSpring.entity.Pedido;
import com.digitalinnovationone.RESTSpring.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    public PedidoService pedidoService;


    @PostMapping("/save")
    public ResponseEntity<Pedido> salvaPedido(@RequestBody Pedido pedido){

        pedido = pedidoService.save(pedido);

        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscaPedido(@PathVariable Long id){

       Pedido pedido = pedidoService.findById(id);

       return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("busca-todos")
    public ResponseEntity<List<Pedido>> buscaTodosPedidos(){

       List<Pedido> pedidos = pedidoService.findAll();

      return ResponseEntity.ok().body(pedidos);

    }
}
