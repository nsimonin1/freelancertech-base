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
import net.freelancertech.base.dto.UtilisateurDto;

/**
 *
 * @author SimonPascal
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
@Table(name = "ge_utilisateur", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"login"})})
@Getter@Setter
public class UtilisateurEntity  extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    public static final String ADMIN_COMPTE="admin";
    @Column(name = "login", nullable = false, length = 25)
    private String login;
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    @Column(name = "pwd", nullable = false, length = 255)
    private String pwd;
    @Column(name = "poste", length = 25)
    private String poste;
    @Column(name = "status", nullable = false)
    private boolean status;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @Column(name = "expired", nullable = false)
    private boolean expired; 
    @JoinColumn(name = "groupe_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupeEntity groupe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupe_id")
    private long groupeId;


    public UtilisateurEntity() {

    }
   
    @Override
    public String toString() {
        return login + " - " + nom + " - " + poste;
    }

    
    public UtilisateurDto toModel(){
        UtilisateurDto utilisateur=new UtilisateurDto();
      utilisateur.setEnabled(enabled);
      utilisateur.setExpired(expired);
      utilisateur.setGroupeId(groupeId);
      utilisateur.setLogin(login);
      utilisateur.setNom(nom);
      utilisateur.setPoste(poste);
      utilisateur.setPwd(pwd);
      utilisateur.setStatus(status);
      return utilisateur;
   }
   public void fromModel(UtilisateurDto utilisateur){
       this.enabled=utilisateur.isEnabled();
       this.expired=utilisateur.isExpired();
       this.groupeId=utilisateur.getGroupeId();
       this.nom=utilisateur.getNom(); 
       this.poste=utilisateur.getPoste();
       this.pwd=utilisateur.getPwd();
       this.status=utilisateur.isStatus();
   } 
    
}
