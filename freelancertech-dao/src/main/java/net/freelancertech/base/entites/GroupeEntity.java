/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.entites;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import net.freelancertech.base.dto.GroupeDto;

/**
 *
 * @author SimonPascal
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
@Cacheable(true)
@Table(name = "ge_groupes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"libelle"})})
@Getter@Setter
public class GroupeEntity extends AbstractEntity{
    private static final long serialVersionUID = 1L;
   
    @Column(nullable = false, length = 55)
    private String libelle;
    @Column(length = 255)
    private String description;
    @Column(nullable = false)
    private boolean actif;
    @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupeEntity parent;
    @Column(nullable = false,name = "parent_id")
    private Long parentId;
     


    public GroupeEntity() {
    }
  
 


    @Override
    public String toString() {
        return libelle;
    }

   public GroupeDto toModel(){
      GroupeDto groupe=new GroupeDto();
      groupe.setActif(actif);
      groupe.setDescription(description);
      groupe.setLibelle(libelle);
      groupe.setParentId(parentId);
      return groupe;
   }
   public void fromModel(GroupeDto groupe){
       this.actif=groupe.isActif();
       this.description=groupe.getDescription();
       this.libelle=groupe.getLibelle();
       this.parentId=groupe.getParentId();
   } 
}
