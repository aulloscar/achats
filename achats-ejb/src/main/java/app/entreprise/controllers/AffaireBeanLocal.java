/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.controllers;

import app.entreprise.menuiserieshared.entities.Affaire;
import app.entreprise.menuiserieshared.exceptions.AffaireInconnueException;
import javax.ejb.Local;

/**
 *
 * @author OscarAullo
 */
@Local
public interface AffaireBeanLocal {
    
    public Affaire getAffaire(int idAffaire) throws AffaireInconnueException;
    public void updateAffaire(int idAffaire, Affaire a) throws AffaireInconnueException;
    
}
