/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.entites;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import net.freelancertech.base.dto.GroupeDto;
import net.freelancertech.base.dto.TacheDto;

/**
 *
 * @author SimonPascal
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
@Getter@Setter
@Table(name = "ge_taches", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom"})})
public class TacheEntity extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_TACHE_CODE="ROLE_PUBLIC";
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif")
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "nom")
    private String nom;   
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;

     


    


    @Override
    public String toString() {
        return "com.freelancertech.entites.Tache[ id=" + id + " ]";
    }

     public TacheDto toModel(){
      TacheDto tache=new TacheDto();
      tache.setActif(actif);
      tache.setDescription(description);
      tache.setNom(nom);
      return tache;
   }
   public void fromModel(TacheDto tache){
       this.actif=tache.isActif();
       this.description=tache.getDescription();
       this.nom=tache.getNom(); 
   } 
}
