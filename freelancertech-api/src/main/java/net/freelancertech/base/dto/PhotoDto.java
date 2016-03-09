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
@EqualsAndHashCode(of = "code")
public class PhotoDto implements Serializable{
    private static final long serialVersionUID = 1L;
     
    private String code;    
    private byte[] contenu;    
    private String description;    
    private String type;

    
    

   

    
    @Override
    public String toString() {
        return type + " - " + description;
    }

   
}
