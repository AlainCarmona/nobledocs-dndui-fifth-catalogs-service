/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.nobledocs.dndui.fifth.catalogs.service.repository.DnduiClassRepository;
import com.nobledocs.dndui.fifth.commons.entity.DnduiClass;

/**
 *
 * @author z841158
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DnduiClassRepositoryTests {
    
    @Autowired
    private DnduiClassRepository repository;
    
    @Test
    public void save() {
        DnduiClass dnduiClass = new DnduiClass();
        dnduiClass.setId(1);
        dnduiClass.setName("Dwarf");
        dnduiClass.setDescription("Dwarf description catalog...");
        
        repository.save(dnduiClass);
    }
    
}
