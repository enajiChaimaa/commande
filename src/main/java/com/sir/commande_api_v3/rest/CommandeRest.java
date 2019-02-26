/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.rest;

import com.sir.commande_api_v3.bean.Commande;
import com.sir.commande_api_v3.bean.CommandeItem;
import com.sir.commande_api_v3.service.CommandeItemService;
import com.sir.commande_api_v3.service.CommandeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping({"/commande-api-v3/commandes"})
public class CommandeRest {
    
    @Autowired
    private CommandeService commandeservice;
    
    @Autowired
    private CommandeItemService commandeitemservice;

    @GetMapping("/ref")
    public List<CommandeItem> findAll() {
        return commandeitemservice.findAll();
    }
    
    
    
    @PostMapping("/")
    public int creer(@RequestBody Commande commande) {
        return commandeservice.creer(commande);
    }

    public CommandeItemService getCommandeitemservice() {
        return commandeitemservice;
    }

    public void setCommandeitemservice(CommandeItemService commandeitemservice) {
        this.commandeitemservice = commandeitemservice;
    }

  
    
    

    public CommandeService getCommandeservice() {
        return commandeservice;
    }

    public void setCommandeservice(CommandeService commandeservice) {
        this.commandeservice = commandeservice;
    }

     @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeservice.findByReference(reference);
    }

     @PutMapping("/reference/{reference}/montant/{montant}")
    public int payer(@PathVariable String reference,@PathVariable double montant) {
        return commandeservice.payer(reference, montant);
    }
    
    
    
    
    
    
}
