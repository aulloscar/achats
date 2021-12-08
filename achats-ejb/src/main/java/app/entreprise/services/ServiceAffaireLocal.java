/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.services;

import app.entreprise.menuiserieshared.exceptions.AffaireInconnueException;

/**
 *
 * @author OscarAullo
 */
public interface ServiceAffaireLocal {
    
    public String getAffaire(int id) throws AffaireInconnueException;
    
    public String majAffaire(String a) throws AffaireInconnueException;
}
