/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.service.impl;

import net.freelancertech.base.ServiceApplication;
import net.freelancertech.base.dto.TacheDto;
import net.freelancertech.base.service.TacheService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author SimonPascal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
public class TacheServiceImplTest {
    @Autowired
    private TacheService tacheService;
    public TacheServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class TacheServiceImpl.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        TacheDto tacheDto = new TacheDto(); 
        tacheDto.setActif(true);
        tacheDto.setDescription("une tache de teste");
        tacheDto.setNom("teste");
        tacheService.ajouter(tacheDto);
         
    }
    
}
