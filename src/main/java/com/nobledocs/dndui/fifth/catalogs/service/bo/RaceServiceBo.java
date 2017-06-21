/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo;

import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;

/**
 *
 * @author z841158
 */
public interface RaceServiceBo {
    
    DnduiResponseDto findAll();
    
    DnduiResponseDto findAllNames();
    
    DnduiResponseDto findById(int id);
    
    DnduiResponseDto findByName(String name);
    
}
