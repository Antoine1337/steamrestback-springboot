package fr.antoine.steamrest.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("jeux")
public class Jeux {

    @Id
    private Long jeuId;
    private String titre;
    private String developpeur;
    private String editeur;
    private Date dateSortie;
    private String image;
    private Double prix;

    public Jeux() { }

	public Long getJeuId() {
		return jeuId;
	}

	public void setJeuId(Long jeuId) {
		this.jeuId = jeuId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(String developpeur) {
		this.developpeur = developpeur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}


}
