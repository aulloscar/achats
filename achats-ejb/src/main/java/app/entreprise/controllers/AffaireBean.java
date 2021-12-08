/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.controllers;

import app.entreprise.menuiserieshared.entities.Affaire;
import app.entreprise.menuiserieshared.entities.AffaireBD;
import app.entreprise.menuiserieshared.exceptions.AffaireInconnueException;

/**
 *
 * @author OscarAullo
 */
public class AffaireBean implements AffaireBeanLocal{
    
    /**
     * Attribut représentant la BD des affaires
     *
     * @see AffaireBD
     */
    private AffaireBD bdAffaire;
    
     /**
     * Constructeur initialisant une BD vide des affaires
     */
    public AffaireBean() {
        this.bdAffaire = new AffaireBD();

    }
    
    @Override
    public Affaire getAffaire(int idAffaire) throws AffaireInconnueException{
        if (!this.bdAffaire.lesaffaires.containsKey(idAffaire)) {
            throw new AffaireInconnueException();
        } 
        else {
            return this.bdAffaire.lesaffaires.get(idAffaire);
        }    
    }
    
    @Override
    public void updateAffaire(int idAffaire, Affaire a) throws AffaireInconnueException {
        if (!this.bdAffaire.lesaffaires.containsKey(idAffaire)) {
            throw new AffaireInconnueException();
        } 
        else {
            this.bdAffaire.lesaffaires.get(idAffaire).setAdresseLivraison(a.getAdresseLivraison());
            this.bdAffaire.lesaffaires.get(idAffaire).setCotes(a.getCotes());
            this.bdAffaire.lesaffaires.get(idAffaire).setMontant(a.getMontant());  
            this.bdAffaire.lesaffaires.get(idAffaire).setRdvCommercial(a.getRdvCommercial());
            this.bdAffaire.lesaffaires.get(idAffaire).setRdvPoseur(a.getRdvPoseur());
        }
    }
}
