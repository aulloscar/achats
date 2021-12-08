/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.services;

import app.entreprise.expo.jms.EnvoiConfirmationAchat;
import app.entreprise.metier.AffaireBusinessLocal;
import app.entreprise.menuiserieshared.entities.Affaire;
import app.entreprise.menuiserieshared.exceptions.AffaireInconnueException;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author OscarAullo
 */
@Stateless
public class ServiceAffaire implements ServiceAffaireLocal {

    /**
     * EJB de Log dans JMS. Pour l'exemple...
     */
    private EnvoiConfirmationAchat envoiConfirmationAchat = new EnvoiConfirmationAchat();
    
    @EJB(beanName="AffaireBusiness")
    private AffaireBusinessLocal affaireBusiness; 
    
    /**
     * Convertisseur Objet JSON et inversement)
     */
    private Gson gson;

    /**
     * Constructeur par défaut de l'exposition
     */
    public ServiceAffaire() {
        this.gson = new Gson();
    }
    
    @Override
    public String getAffaire(int id) throws AffaireInconnueException {
        return this.gson.toJson(this.affaireBusiness.getAffaire(id));
    }
    
    @Override
    public String majAffaire(String a) throws AffaireInconnueException {
        try {
            Affaire affaire = this.gson.fromJson(a, Affaire.class);
            this.affaireBusiness.majAffaire(affaire);
            return this.gson.toJson(this.affaireBusiness.getAffaire(affaire.getIdAffaire()));
        } catch (AffaireInconnueException ex) {
            throw new AffaireInconnueException();
        }
    }
}
    
