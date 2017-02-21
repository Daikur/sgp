package com.fpmislata.service;

import com.fpmislata.domain.Pedido;
import com.fpmislata.domain.Persona;
import com.fpmislata.repository.PedidoDaoImpLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PedidoService implements PedidoServiceLocal {
    
    @EJB
    private PedidoDaoImpLocal pedidoDao;

    @Override
    public void addPedido(Pedido pedido) {
        pedidoDao.addPedido(pedido);
    }
    
    @Override
    public void updatePedido(Pedido pedido) {
        pedidoDao.updatePedido(pedido);
    }
    
    @Override
    public void deletePedido(Pedido pedido) {
        pedidoDao.deletePedido(pedido);
    }
    
    @Override
    public List listPedidos() {
        return pedidoDao.listPedidos();
    }
    
    @Override
    public Pedido findPedidosById(Pedido pedido) {
        return pedidoDao.findPedidoById(pedido);
    }
    
}
