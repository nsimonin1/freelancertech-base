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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import net.freelancertech.base.dto.PhotoDto;

/**
 *
 * @author SimonPascal
 */
@SuppressWarnings("PersistenceUnitPresent")
@Entity
@Table(name = "ge_photo")
@Getter@Setter
public class PhotoEntity extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "code")
    private String code; 
    @Lob
    @Column(name = "contenu", nullable = false)
    private byte[] contenu;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "type", nullable = false)
    private String type;

    public PhotoEntity() {
    }

    public PhotoEntity(byte[] contenu, String description, String type) {
        this.contenu = contenu;
        this.description = description;
        this.type = type;
    }

   

     public PhotoDto toModel(){
      PhotoDto photo=new PhotoDto();
      photo.setCode(code);
      photo.setDescription(description);
      photo.setContenu(contenu);
      photo.setType(type);
      return photo;
   }
   public void fromModel(PhotoDto photo){
       this.code=photo.getCode();
       this.description=photo.getDescription();
       this.contenu=photo.getContenu();
       this.type=photo.getType();
   } 
    @Override
    public String toString() {
        return type + " - " + description;
    }

   
}
