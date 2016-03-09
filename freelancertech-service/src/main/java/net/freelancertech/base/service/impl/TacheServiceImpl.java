/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.service.impl;

import net.freelancertech.base.dto.TacheDto;
import net.freelancertech.base.entites.TacheEntity;
import net.freelancertech.base.repositories.TacheRepository;
import net.freelancertech.base.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SimonPascal
 */
@Service
public class TacheServiceImpl implements TacheService{
    @Autowired
    private TacheRepository tacheRepository;
    
    @Override
    public void ajouter(TacheDto tacheDto){
        TacheEntity entity=new TacheEntity();
        entity.fromModel(tacheDto);
        tacheRepository.save(entity);
    }
}
