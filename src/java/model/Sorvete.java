/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ricardobalduino
 */
@Entity
public class Sorvete implements Serializable {
    private static final long serialVersionUID = 6295997158682583939L;
	
	private long id;
	private String sabor = "";
	private float preco;
	private String tipo = "";
	private String cobertura = "";
	private String imagem = "";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=30)
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	@Column(length=30)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Column(length=30)
	public String getCobertura() {
		return cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	
	@Column(length=255)
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String toString() { 
		StringBuffer s = new StringBuffer();
		s.append("Id:");
		s.append(this.getId());
		s.append("\tSabor:");
		s.append(this.getSabor());
		s.append("\tTipo:");
		s.append(this.getTipo());
		return s.toString();
	}
}
