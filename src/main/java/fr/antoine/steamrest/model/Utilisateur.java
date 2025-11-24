package fr.antoine.steamrest.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("utilisateurs")
public class Utilisateur {

    @Id
    private Long utilisateurId;

    private String nomUtilisateur;
    
    private String motDePasse;

    private String email;

    private Timestamp dateInscription;

    private Long roleId;


    public Utilisateur() {
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}



}
