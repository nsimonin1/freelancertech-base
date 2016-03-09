/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author SimonPascal
 */
@Data
public class TacheDto implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_TACHE_CODE="ROLE_PUBLIC";
    
    private boolean actif;
    
    private String nom;   
    
    private String description;

     


    


    @Override
    public String toString() {
        return nom;
    }

    
}
