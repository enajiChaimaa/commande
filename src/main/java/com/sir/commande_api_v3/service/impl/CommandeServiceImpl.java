/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.service.impl;

import com.sir.commande_api_v3.bean.Commande;
import com.sir.commande_api_v3.bean.CommandeItem;
import com.sir.commande_api_v3.dao.CommandeDao;
import com.sir.commande_api_v3.service.CommandeItemService;
import com.sir.commande_api_v3.service.CommandeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
    private CommandeDao commandedao;
    @Autowired
    private CommandeItemService commandeItemService;
    
    @Override
    public Commande findByReference(String reference) {
        return commandedao.findByReference(reference);
    }

    @Override
    public int payer(String reference, double montant) {
        Commande commande=findByReference(reference);
        if(commande==null){
            return -1;
        }else if(commande.getTotalPaiement()+montant>commande.getTotal()){
            return -2;
        }else{
            double nvPaiement=commande.getTotalPaiement()+montant;
            commande.setTotalPaiement(nvPaiement);
            commandedao.save(commande);
            return 1;
        }
    }

//    @Override
//    public int creer(Commande commande) {
//        Commande c=findByReference(commande.getReference());
//        if(c!=null){
//            return -1;
//        }else{
//            commande.setTotalPaiement(0);
//            commande =commandedao.save(commande);
//             for (CommandeItem commandeitem : commande.getCommandeItems()) {
//                commandeitem.setCommande(commande);
//                commandeItemService.save(commandeitem);
//            }
//            return 1;
//            
//        }
//    }

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }
    
       public CommandeDao getCommandedao() {
        return commandedao;
    }

    public void setCommandedao(CommandeDao commandedao) {
        this.commandedao = commandedao;
    }

    @Override
    public int creer(Commande commande) {
       Commande c= findByReference(commande.getReference());
    if(c!=null){
        return -1;
    }else{
        commande.setTotalPaiement(0D);
        calculerCommandeTotal(commande);
        commandedao.save(commande);
        List<CommandeItem>commandeItems=commande.getCommandeItems();
        for(CommandeItem commandeItem:commandeItems){
            commandeItem.setCommande(commande);
            commandeItemService.creer(commandeItem);
        }
        return 1;
    }
    
    }

    private void calculerCommandeTotal(Commande commande) {
     List<CommandeItem>commandeItems=commande.getCommandeItems();
     Double total=0D;
     for(CommandeItem commandeItem:commandeItems){
         total+=commandeItem.getPrix()*commandeItem.getQte();
     }
     commande.setTotal(total);
    }
    
}
