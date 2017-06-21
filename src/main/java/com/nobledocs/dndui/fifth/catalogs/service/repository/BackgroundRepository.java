/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.repository;

import com.nobledocs.dndui.fifth.commons.entity.Background;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author z841158
 */
public interface BackgroundRepository extends MongoRepository<Background, Integer> {
    
    @Query(value = "{}", fields = "{ _id : 1, name : 1 }")
    List<Background> findAllNames();
    
    Background findByName(String name);
    
}
