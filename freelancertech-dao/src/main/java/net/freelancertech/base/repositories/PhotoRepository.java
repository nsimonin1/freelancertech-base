/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.repositories;

import net.freelancertech.base.entites.PhotoEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author SimonPascal
 */
public interface PhotoRepository extends CrudRepository<PhotoEntity, Long>{
    
}
