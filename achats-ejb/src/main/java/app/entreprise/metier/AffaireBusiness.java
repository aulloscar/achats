/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.metier;

import app.entreprise.controllers.AffaireBeanLocal;
import app.entreprise.menuiserieshared.entities.Affaire;
import app.entreprise.menuiserieshared.exceptions.AffaireInconnueException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author OscarAullo
 */
@Stateless
public class AffaireBusiness implements AffaireBusinessLocal{
    
    /**
     * EJB permettant la manipulation technique de la base
     */
    @EJB(beanName="AffaireBean")
    private AffaireBeanLocal affaireBean;

    /**
     * Constrcuteur par défaut du métier Bourse
     */
    public AffaireBusiness() {
    }
    
    @Override
    public Affaire getAffaire(int id) throws AffaireInconnueException {
        return this.affaireBean.getAffaire(id);
    }
    
    @Override
    public Affaire majAffaire(Affaire a) throws AffaireInconnueException {
        try {
            this.affaireBean.updateAffaire(a.getIdAffaire(), a);
            return this.affaireBean.getAffaire(a.getIdAffaire());
        } 
        catch (AffaireInconnueException ex) {
            System.out.println("Erreur - Maj de l'affaire a échoué");
            throw new AffaireInconnueException();
        }
    }
}
