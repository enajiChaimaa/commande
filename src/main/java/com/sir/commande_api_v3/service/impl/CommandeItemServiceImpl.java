/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.service.impl;

import com.sir.commande_api_v3.bean.CommandeItem;
import com.sir.commande_api_v3.dao.CommandeItemDao;
import com.sir.commande_api_v3.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CommandeItemServiceImpl implements CommandeItemService {
   
    @Autowired
    private CommandeItemDao commandeitemdao;
    
//
//    @Override
//    public List<CommandeItem> findByCommandeReference(String reference) {
//    return commandeitemdao.findByCommandeReference(reference);
//    }

    @Override
    public int creer(CommandeItem commandeItem) {
     commandeitemdao.save(commandeItem);
     return 1;
    }
    
     public CommandeItemDao getCommandeitemdao() {
        return commandeitemdao;
    }

    public void setCommandeitemdao(CommandeItemDao commandeitemdao) {
        this.commandeitemdao = commandeitemdao;
    }

    @Override
    public List<CommandeItem> findAll() {
     return commandeitemdao.findAll();
    }
}
