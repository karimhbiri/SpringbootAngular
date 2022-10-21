package tn.iit.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class EtudiantDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private char genre;

}
