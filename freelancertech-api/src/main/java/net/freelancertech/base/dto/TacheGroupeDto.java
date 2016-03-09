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
public class TacheGroupeDto implements Serializable{
    private static final long serialVersionUID = 1L;
  
    private long groupeId;
   
    private long tacheId;
   
    private boolean actif;

    
}
