/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.controller;

import com.nobledocs.dndui.fifth.catalogs.service.bo.ArmorServiceBo;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Z841158
 */
@RestController
@RequestMapping("/armor")
public class ArmorServiceController {

    @Autowired
    private ArmorServiceBo bo;

    @GetMapping("/findAll")
    public DnduiResponseDto findAll() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            response = bo.findAll();
        } catch (Exception ex) {

        }

        return response;
    }

}
