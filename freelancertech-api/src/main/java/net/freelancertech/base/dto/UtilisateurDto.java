/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.dto;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author SimonPascal
 */

@Data
@EqualsAndHashCode(of = "login")
public class UtilisateurDto  implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String ADMIN_COMPTE="admin"; 
    private String login; 
    private String nom; 
    private String pwd; 
    private String poste; 
    private boolean status; 
    private boolean enabled; 
    private boolean expired;   
    private long groupeId;

 
   
    @Override
    public String toString() {
        return login + " - " + nom + " - " + poste;
    }

    
}
