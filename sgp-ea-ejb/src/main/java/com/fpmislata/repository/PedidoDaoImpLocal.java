package com.fpmislata.repository;

import com.fpmislata.domain.Pedido;
import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidoDaoImpLocal {

    void addPedido(Pedido pedido);

    void updatePedido(Pedido pedido);

    Pedido findPedidoById(Pedido pedido);

    List findPedidosByIdPersona(Persona persona);

    void deletePedido(Pedido pedido);

    List listPedidos();

    
}
