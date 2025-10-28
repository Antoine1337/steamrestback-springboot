package fr.antoine.steamrest.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("utilisateurs")
public class Utilisateur {

    @Id
    private Long utilisateurId;

    private String nomUtilisateur;

    private String email;

    private Timestamp dateInscription;

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


}
