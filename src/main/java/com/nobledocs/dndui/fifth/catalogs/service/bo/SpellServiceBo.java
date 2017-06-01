/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo;

import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.Spell;
import java.util.List;

/**
 *
 * @author z841158
 */
public interface SpellServiceBo {
    
    DnduiResponseDto findAll();
    
    DnduiResponseDto findAllNames();
    
    DnduiResponseDto findAllNamesByInitial();
    
    DnduiResponseDto findById(int id);
    
    DnduiResponseDto findByName(String name);
    
}
