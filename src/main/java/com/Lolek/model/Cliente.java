package com.Lolek.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column (name= "Id", unique = true)
	private Long Id;
	
	@Column (name= "Nome", unique = true)
	@NotNull
	@NotEmpty
	private String nome;
	
	@Column (name= "CPF", unique = true)
	@NotNull
	@NotEmpty
	private String CPF;
	
	@Column (name= "Telefone", unique = true)
	@NotNull
	@NotEmpty
	private String telefone;
	
	@OneToMany (mappedBy = "cliente")
	private List <Passagem> passagem = new ArrayList<>();
	
	public Cliente(Long id, String nome, String cPF, String telefone) {
		super();
		Id = id;
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Passagem> getPassagem() {
		return passagem;
	}

	public void setPassagem(List<Passagem> passagem) {
		this.passagem = passagem;
	}
	

	
	
}
