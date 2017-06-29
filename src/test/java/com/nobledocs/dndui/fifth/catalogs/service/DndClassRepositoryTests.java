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
import com.nobledocs.dndui.fifth.commons.entity.DndClass;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nobledocs.dndui.fifth.catalogs.service.repository.DndClassRepository;

/**
 *
 * @author z841158
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DndClassRepositoryTests {
    
    @Autowired
    private DndClassRepository repository;
    
    private static final Logger LOG = LoggerFactory.getLogger(DndClassRepositoryTests.class);
    
    @Test
    public void findAllNamesTest() {
        List<DndClass> dndClasses = repository.findAllNames();
        LOG.info(dndClasses.toString());
    }
    
    @Test
    public void findByNameTest() {
        DndClass dndClasses = repository.findByName("Bard");
        LOG.info(dndClasses.toString());
    }
    
    @Test
    public void findAllDndClassSpellsTest() {
        List<DndClass> dndClasses = repository.findAllDndClassSpells();
        LOG.info(dndClasses.toString());
    }
    
}
