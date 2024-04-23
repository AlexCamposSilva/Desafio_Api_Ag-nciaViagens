package com.Lolek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passagem {

	@Id
	@Column (name= "Identificador")
	private String IdentificadorVoo;
	
	@Column (name = "Companhia Aerea")
	private String Companhia;
	
	
	@Column(name= "Status")
	private String Status;
	
	
	@ManyToOne 
	@JoinColumn(name = "cliente_id", nullable = false, updatable =  false)
	private Cliente cliente;
}

