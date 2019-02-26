/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.rest;

import com.sir.commande_api_v3.bean.CommandeItem;
import com.sir.commande_api_v3.dao.CommandeItemDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/commande-api-v3/commandeItems")
public class CommandeItemRest {
    
    @Autowired
    private CommandeItemDao commandeitemdao;

 
   @GetMapping("reference")
    public List<CommandeItem> findAll() {
        return commandeitemdao.findAll();
    }
    
    

//    @GetMapping("reference")
//    public List<CommandeItem> findByCommandeReference(String reference) {
//        return commandeitemdao.findByCommandeReference(reference);
//    }
    
    

    public CommandeItemDao getCommandeitemdao() {
        return commandeitemdao;
    }

    public void setCommandeitemdao(CommandeItemDao commandeitemdao) {
        this.commandeitemdao = commandeitemdao;
    }
    
    
    
}
