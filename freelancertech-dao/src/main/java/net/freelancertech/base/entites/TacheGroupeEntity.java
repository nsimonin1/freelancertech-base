/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.entites;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.freelancertech.base.dto.TacheGroupeDto;

/**
 *
 * @author SimonPascal
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
@Table(name = "ge_taches_groupes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"groupe_id","tache_id"})})
@Getter@Setter
public class TacheGroupeEntity extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "groupe_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupeEntity groupe;
    @JoinColumn(name = "tache_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TacheEntity tache;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupe_id")
    private long groupeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tache_id")
    private long tacheId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif")
    private boolean actif;

    public TacheGroupeEntity() {
    }

    public TacheGroupeEntity(Long id) {
        this.id = id;
    }
   
    @Override
    public String toString() {
        return tache+" "+groupe;
    }

    public TacheGroupeDto toModel(){
      TacheGroupeDto tacheGroupe=new TacheGroupeDto();
      tacheGroupe.setActif(actif);
      tacheGroupe.setGroupeId(groupeId);
      tacheGroupe.setTacheId(tacheId);
      return tacheGroupe;
   }
   public void fromModel(TacheGroupeDto tacheGroupe){
       this.actif=tacheGroupe.isActif();
       this.groupeId=tacheGroupe.getGroupeId();
       this.tacheId=tacheGroupe.getTacheId(); 
   } 
}
