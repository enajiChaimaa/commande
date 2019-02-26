 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commande_api_v3.service;

import com.sir.commande_api_v3.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author User
 */
public interface CommandeItemService {
    //public List<CommandeItem> findByCommandeReference(String reference);
    public int creer(CommandeItem commandeItem);
    public List<CommandeItem> findAll();
}
