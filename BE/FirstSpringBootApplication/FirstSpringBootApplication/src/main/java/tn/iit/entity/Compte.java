package tn.iit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "client")
	private String nomClient;
	
	public Compte(float solde, String nomClient) {
		super();
		this.solde = solde;
		this.nomClient = nomClient;
	}

}
