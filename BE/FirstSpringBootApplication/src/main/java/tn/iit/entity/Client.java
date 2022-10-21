package tn.iit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@Setter
@NoArgsConstructor // obligatoire selon la spec JEE
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_client")
public class Client implements Serializable /* spec JEE */ {
	private static final long serialVersionUID = 1L;

	@Id // rib --> PK
	@Include
	@Column(length = 10)
	private String cin;
	private String nom;
	private String prenom;
	
	public Client(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}

	//bidirectionnelle
	@JsonIgnore //cassé la boucle de json
	@Exclude // cassé la boucle de toString
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes; //defautl fetch: LAZY

}
