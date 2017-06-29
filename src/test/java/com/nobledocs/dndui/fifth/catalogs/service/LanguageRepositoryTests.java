/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service;

import com.nobledocs.dndui.fifth.catalogs.service.repository.LanguageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Z841158
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LanguageRepositoryTests {
    
    @Autowired
    private LanguageRepository repository;
    
    private final Logger LOG = LoggerFactory.getLogger(LanguageRepositoryTests.class);
    
    @Test
    public void findAllTest() {
        LOG.info(repository.findAll().toString());
    }
    
}
