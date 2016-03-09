/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author SimonPascal
 */
@Data
@EqualsAndHashCode(of = "libelle")
public class GroupeDto {
   private String libelle;
   private String description;
   private boolean actif;
   private Long parentId;
}
