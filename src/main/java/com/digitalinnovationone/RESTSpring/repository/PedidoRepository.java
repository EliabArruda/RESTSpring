package com.digitalinnovationone.RESTSpring.repository;

import com.digitalinnovationone.RESTSpring.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
