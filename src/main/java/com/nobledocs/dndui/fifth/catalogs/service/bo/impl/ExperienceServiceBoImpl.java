/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.ExperienceServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.ExperienceRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.Experience;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author z841158
 */
@Service
public class ExperienceServiceBoImpl implements ExperienceServiceBo {

    @Autowired
    private ExperienceRepository repository;

    @Override
    public DnduiResponseDto findAll() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<Experience> experience = repository.findAll();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(experience);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (Experience list)");
        }

        return response;
    }

}
