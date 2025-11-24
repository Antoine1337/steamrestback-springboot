package fr.antoine.steamrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("session_tokens")
public class SessionToken {

    @Id
    private Long sessionId;

    private String token;

    private Long utilisateurId;


    public SessionToken() { }


	public Long getSessionId() {
		return sessionId;
	}


	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Long getUtilisateurId() {
		return utilisateurId;
	}


	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

    
    
}
