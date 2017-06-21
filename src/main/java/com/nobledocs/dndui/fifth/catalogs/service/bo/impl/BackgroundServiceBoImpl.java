/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.BackgroundServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.BackgroundRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.Background;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author z841158
 */
@Service
public class BackgroundServiceBoImpl implements BackgroundServiceBo {
    
    @Autowired
    private BackgroundRepository repository;

    @Override
    public DnduiResponseDto findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DnduiResponseDto findAllNames() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<Background> backgrounds = repository.findAllNames();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(backgrounds);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (Background names list)");
        }

        return response;
    }

    @Override
    public DnduiResponseDto findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DnduiResponseDto findByName(String name) {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            Background background = repository.findByName(name);

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(background);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (Background by name)");
        }

        return response;
    }
    
}
