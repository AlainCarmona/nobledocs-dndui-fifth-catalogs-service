/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.controller;

import com.nobledocs.dndui.fifth.catalogs.service.bo.SpellServiceBo;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author z841158
 */
@RestController
@RequestMapping("/catalogs/spell")
public class SpellServiceController {
    
    @Autowired
    private SpellServiceBo bo;
    
    @GetMapping("/findAllNames")
    public DnduiResponseDto findAllNames() {
        DnduiResponseDto response = new DnduiResponseDto();
        
        try {
            response = bo.findAllNames();
        } catch(Exception ex) {
            
        }
        
        return response;
    }
    
    @GetMapping("findByName")
    public DnduiResponseDto findByName(@RequestParam(value = "name") String name) {
        DnduiResponseDto response = new DnduiResponseDto();
        
        try {
            response = bo.findByName(name);
        } catch(Exception ex) {
            
        }
        
        return response;
    }
    
}
