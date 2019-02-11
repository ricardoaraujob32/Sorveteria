/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sorveteria.controller;

import com.wordpress.ricardoanalistadesistemas.sorveteria.dao.GenericDAOException;
import com.wordpress.ricardoanalistadesistemas.sorveteria.dao.SorveteDAO;
import com.wordpress.ricardoanalistadesistemas.sorveteria.dao.SorveteDAOImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import com.wordpress.ricardoanalistadesistemas.sorveteria.model.Sorvete;

/**
 *
 * @author ricardobalduino
 */
@Named(value = "sorveteControllerMB")
@SessionScoped
@ManagedBean
public class SorveteControllerMB implements Serializable {
    private SorveteDAO dao;
    private Sorvete sorveteAtual;
    private List<Sorvete> listaSorvetes;
    
    /**
     * Creates a new instance of SorveteControllerMB
     */
    public SorveteControllerMB() {    
        sorveteAtual = new Sorvete();
        listaSorvetes = new ArrayList<>();
        
        try {
            dao = new SorveteDAOImpl();
        } catch (GenericDAOException ex) {
            Logger.getLogger( SorveteControllerMB.class.getName() ).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the sorveteAtual
     */
    public Sorvete getSorveteAtual() {
        return sorveteAtual;
    }

    /**
     * @param sorveteAtual the sorveteAtual to set
     */
    public void setSorveteAtual(Sorvete sorveteAtual) {
        this.sorveteAtual = sorveteAtual;
    }

    /**
     * @return the listaSorvetes
     */
    public List<Sorvete> getListaSorvetes() {
        return listaSorvetes;
    }

    /**
     * @param listaSorvetes the listaSorvetes to set
     */
    public void setListaSorvetes(List<Sorvete> listaSorvetes) {
        this.listaSorvetes = listaSorvetes;
    }
    
    public void adicionar(Sorvete s){
        FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Sorvete foi adicionado com sucesso", "");
        
        try {
            dao.adicionar(s);
        } catch (GenericDAOException ex) {
            Logger.getLogger(SorveteControllerMB.class.getName()).log(Level.SEVERE, null, ex);
            msg.setSummary("Erro ao acessar este sorvete");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void salvar(long id, Sorvete s){
        FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Sorvete foi adicionado com sucesso", "");
        
        try {
            dao.salvar(id, s);
        } catch (GenericDAOException ex) {
            Logger.getLogger(SorveteControllerMB.class.getName()).log(Level.SEVERE, null, ex);
            msg.setSummary("Erro ao acessar este sorvete");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void remover(long id){
        FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Sorvete foi adicionado com sucesso", "");
        
        try {
            dao.remover(id);
        } catch (GenericDAOException ex) {
            Logger.getLogger(SorveteControllerMB.class.getName()).log(Level.SEVERE, null, ex);
            msg.setSummary("Erro ao acessar este sorvete");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public List<Sorvete> pesquisarPorSabor(String sabor){
        List<Sorvete> lista = new ArrayList<>();
        FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Sorvete foi adicionado com sucesso", "");
        
        try {
            lista = dao.pesquisarPorSabor(sabor);
        } catch (GenericDAOException ex) {
            Logger.getLogger(SorveteControllerMB.class.getName()).log(Level.SEVERE, null, ex);
            msg.setSummary("Erro ao acessar este sorvete");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            return lista;
        }       
    }
    
    public Sorvete pesquisarPorId(long id){
        Sorvete s = new Sorvete();
        FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "Sorvete foi adicionado com sucesso", "");
        
        try {
            s = dao.pesquisarPorId(id);
        } catch (GenericDAOException ex) {
            Logger.getLogger(SorveteControllerMB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            return s;
        }
    }
}
