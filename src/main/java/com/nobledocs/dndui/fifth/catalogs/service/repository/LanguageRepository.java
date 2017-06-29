/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.repository;

import com.nobledocs.dndui.fifth.commons.entity.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Z841158
 */
public interface LanguageRepository extends MongoRepository<Language, Integer> {
    
}
