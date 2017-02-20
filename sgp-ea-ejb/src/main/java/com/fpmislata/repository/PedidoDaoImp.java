package com.fpmislata.repository;

import com.fpmislata.domain.Pedido;
import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PedidoDaoImp implements PedidoDaoImpLocal {

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addPedido(Pedido pedido) {
        em.persist(pedido);
    }

    @Override
    public void updatePedido(Pedido pedido) {
        em.merge(pedido);
    }

    @Override
    public Pedido findPedidoById(Pedido pedido) {
        return em.find(Pedido.class, pedido.getId());
    }

    @Override
    public List findPedidosByIdPersona(Persona persona) {
        List a = em.createNamedQuery("Pedidos.findByPerson").getResultList();
        return a;
    }

    @Override
    public void deletePedido(Pedido pedido) {
        em.remove(pedido);
    }

    @Override
    public List listPedidos() {
        List a = em.createNamedQuery("Pedidos.findAll").getResultList();
        return a;
    }

    

    
    

    
    
    
    
}
