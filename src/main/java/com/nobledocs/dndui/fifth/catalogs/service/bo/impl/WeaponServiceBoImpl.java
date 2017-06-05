/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.WeaponServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.WeaponRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.Weapon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Z841158
 */
@Service
public class WeaponServiceBoImpl implements WeaponServiceBo {
    
    @Autowired
    private WeaponRepository repository;        

    @Override
    public DnduiResponseDto findAll() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<Weapon> weapons = repository.findAll();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(weapons);
        } catch (Exception ex) {

        }

        return response;
    }

}
