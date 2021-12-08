/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.metier;

import app.entreprise.menuiserieshared.entities.Affaire;
import app.entreprise.menuiserieshared.exceptions.AffaireInconnueException;
import javax.ejb.Local;

/**
 *
 * @author OscarAullo
 */
@Local
public interface AffaireBusinessLocal {
    
    public Affaire getAffaire(int id) throws AffaireInconnueException;
    public Affaire majAffaire(Affaire a) throws AffaireInconnueException;
}
