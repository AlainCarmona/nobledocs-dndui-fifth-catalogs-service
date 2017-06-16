/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.HeightAndWeightServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.HeightAndWeightRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.HeightAndWeight;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author z841158
 */
@Service
public class HeightAndWeightServiceBoImpl implements HeightAndWeightServiceBo {

    @Autowired
    private HeightAndWeightRepository repository;
    
    @Override
    public DnduiResponseDto findAll() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<HeightAndWeight> heightAndWeight = repository.findAll();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(heightAndWeight);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (HeightAndWeight list)");
        }

        return response;
    }
    
}
