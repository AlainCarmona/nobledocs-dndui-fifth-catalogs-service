/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.util;

import com.google.gson.Gson;

/**
 *
 * @author Alain Carmona
 */
public class ToGson {

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
