/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.bo.impl;

import com.nobledocs.dndui.fifth.catalogs.service.bo.LanguageServiceBo;
import com.nobledocs.dndui.fifth.catalogs.service.repository.LanguageRepository;
import com.nobledocs.dndui.fifth.commons.dto.DnduiResponseDto;
import com.nobledocs.dndui.fifth.commons.entity.Language;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Z841158
 */
@Service
public class LanguageServiceBoImpl implements LanguageServiceBo {

    @Autowired
    private LanguageRepository repository;
    
    @Override
    public DnduiResponseDto findAll() {
        DnduiResponseDto response = new DnduiResponseDto();

        try {
            List<Language> languages = repository.findAll();

            response.setCode(200);
            response.setMessage("OK");
            response.setBody(languages);

        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Internal server error on catalogs service (Languages list)");
        }

        return response;
    }

}
