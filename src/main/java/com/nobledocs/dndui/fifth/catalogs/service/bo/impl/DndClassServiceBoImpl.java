/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.DndClassServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.DndClassRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.DndClass;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Z841158
 */
@Service
public class DndClassServiceBoImpl implements DndClassServiceBo {

    @Autowired
    private DndClassRepository repository;

    @Override
    public DnduiResponseDto findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DnduiResponseDto findAllNames() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<DndClass> dndClasses = repository.findAllNames();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(dndClasses);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (D&D Class names list)");
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
            DndClass dndClass = repository.findByName(name);

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(dndClass);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (D&D Class by name)");
        }

        return response;
    }

    @Override
    public DnduiResponseDto findAllDndClassSpells() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<DndClass> dndClasses = repository.findAllDndClassSpells();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(dndClasses);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (D&D Class spells)");
        }

        return response;
    }

}
