/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Z841158
 */
@Controller
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/inventories")
    public String getDmInventoriesPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails
                    = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            LOG.info("El usuario " + userDetails.getUsername() + ' ' + userDetails.getAuthorities()
                    + " ha iniciado sesión.");
            List<String> authorities = new ArrayList<>();

            for (GrantedAuthority a : userDetails.getAuthorities()) {
                authorities.add(a.getAuthority());
            }

            if (authorities.contains("DM")) {
                return "dm.inventories";
            }

            if (authorities.contains("PLAYER")) {
                return "player.inventories";
            }

        } else {
            return "login";
        }

        return "index";
    }

}
