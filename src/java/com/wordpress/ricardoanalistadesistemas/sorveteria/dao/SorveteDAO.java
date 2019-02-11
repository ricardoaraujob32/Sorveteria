/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sorveteria.dao;

import java.util.List;
import com.wordpress.ricardoanalistadesistemas.sorveteria.model.Sorvete;

/**
 *
 * @author ricardobalduino
 */
public interface SorveteDAO {
    public void adicionar(Sorvete s) throws GenericDAOException;

    public List<Sorvete> pesquisarPorSabor(String sabor) throws GenericDAOException;

    public void remover(long id) throws GenericDAOException;

    public Sorvete pesquisarPorId(long id) throws GenericDAOException;

    public void salvar(long id, Sorvete s) throws GenericDAOException;
}
