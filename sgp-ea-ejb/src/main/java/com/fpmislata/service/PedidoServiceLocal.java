/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Pedido;
import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface PedidoServiceLocal {

    void addPedido(Pedido pedido);

    void updatePedido(Pedido pedido);

    void deletePedido(Pedido pedido);

    List listPedidos();

    Pedido findPedidosById(Pedido pedido);
 
}
