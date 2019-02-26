/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.dao;

import com.sir.commande_api_v3.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface CommandeDao extends JpaRepository<Commande,Long>{// pr herité les crud 
    public Commande findByReference(String reference);
    
    
}
