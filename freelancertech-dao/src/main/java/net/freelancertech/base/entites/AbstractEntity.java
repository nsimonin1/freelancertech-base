/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author SimonPascal
 */
@SuppressWarnings("PersistenceUnitPresent")
@MappedSuperclass
@Getter@Setter
@EqualsAndHashCode(of = "id")
public abstract class AbstractEntity implements Serializable{
    private static final long serialVersionUID = -3705039121917914167L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;
    @Version
    @Column(name = "version", nullable = false)
    protected Integer version;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = false)
    protected Date dateCreate;
    @Column(name = "user_create", nullable = false)
    protected String userCreate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_maj", nullable = false)
    protected Date dateMaj;
    @Column(name = "user_maj", nullable = false)
    protected String userMaj;

     

    @PrePersist
    public void prePersist() {
        setDateCreate(new Date());
        setDateMaj(getDateCreate());        
    }

    @PreUpdate
    public void preUpdate() {
        setDateMaj(new Date());
    }

     
    

   
 

    @Override
    public abstract String toString();
}
