package fr.antoine.steamrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("bibliotheque_jeux")
public class BibliothequeJeux {

    @Id
    private Long bibliothequeId;
	private Long utilisateurId;
    private Long jeuId;
    private Long heuresJeu;
    private Boolean estInstalle;

    public BibliothequeJeux() { }

    public Long getBibliothequeId() {
		return bibliothequeId;
	}

	public void setBibliothequeId(Long bibliothequeId) {
		this.bibliothequeId = bibliothequeId;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Long getJeuId() {
		return jeuId;
	}

	public void setJeuId(Long jeuId) {
		this.jeuId = jeuId;
	}

	public Long getHeuresJeu() {
		return heuresJeu;
	}

	public void setHeuresJeu(Long heuresJeu) {
		this.heuresJeu = heuresJeu;
	}

	public Boolean getEstInstalle() {
		return estInstalle;
	}

	public void setEstInstalle(Boolean estInstalle) {
		this.estInstalle = estInstalle;
	}

}
