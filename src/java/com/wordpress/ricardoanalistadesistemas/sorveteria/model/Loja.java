/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sorveteria.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author ricardobalduino
 */
@Entity
public class Loja implements Serializable {
	
	private long id;
	private String nome;
	private Set<Sorvete> sorvetes = new HashSet<>();
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToMany
	public Set<Sorvete> getSorvetes() {
		return sorvetes;
	}
	public void setSorvetes(Set<Sorvete> sorvetes) {
		this.sorvetes = sorvetes;
	}
}
