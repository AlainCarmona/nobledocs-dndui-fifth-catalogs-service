/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.ArmorServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.ArmorRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.Armor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Z841158
 */
@Service
public class ArmorServiceBoImpl implements ArmorServiceBo {

    @Autowired
    private ArmorRepository repository;

    @Override
    public DnduiResponseDto findAll() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<Armor> armors = repository.findAll();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(armors);
        } catch (Exception ex) {

        }

        return response;
    }

}
