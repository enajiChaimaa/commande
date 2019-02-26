/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.service;

import com.sir.commande_api_v3.bean.Commande;

/**
 *
 * @author User
 */
public interface CommandeService {
    public Commande findByReference(String reference);
    public int payer(String reference,double montant);
    public int creer(Commande commande);
}
