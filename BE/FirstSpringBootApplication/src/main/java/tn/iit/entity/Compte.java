package tn.iit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // obligatoire selon la spec JEE
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_compte")
public class Compte implements Serializable /* spec JEE */ {
	private static final long serialVersionUID = 1L;

	@Id // rib --> PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Include
	private Long rib;
	private float solde;
	//unidirectionnelle
	@ManyToOne //default fetch EAGER
	@JoinColumn(name="id_client")
	private Client client;
	
	public Compte(float solde, Client client) {
		super();
		this.solde = solde;
		this.client = client;
	}
	
	public String getNomAndPrenom() {
		return client.getNom() + " " + client.getPrenom();
	}

	
}
