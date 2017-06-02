/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service;

import com.nobledocs.dndui.fifth.catalogs.service.repository.SpellRepository;
import com.nobledocs.dndui.fifth.commons.entity.Spell;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Alain Carmona
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpellRepositoryTests {

    @Autowired
    private SpellRepository repository;

    private static final Logger LOG = LoggerFactory.getLogger(SpellRepositoryTests.class);

    @Test
    public void findAllTest() {
        List<Spell> spells = repository.findAll();

        assertNotNull(spells);
        assertThat(spells.size() > 1);

        LOG.info("Spells in repository: " + spells.size());
    }
    
    @Test
    public void findAllNamesTest() {
        List<Spell> names = repository.findAllNames();

        assertNotNull(names);
        assertThat(names.size() > 1);

        LOG.info("Spells in repository: " + names.size());
        LOG.info(names.toString());
    }

    @Test
    public void findOneTest() {
        Spell spell = repository.findOne(180);

        assertNotNull(spell);
        assertThat(spell.getName().equals("Alarm"));

        LOG.info(spell.toString());
    }

    @Test
    public void findByNameTest() {
        Spell spell = repository.findByName("Bane");

        assertNotNull(spell);
        assertThat(spell.getName().equals("Bane"));

        LOG.info(spell.toString());
    }

}
