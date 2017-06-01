/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.entity;

import com.nobledocs.dndui.fifth.catalogs.service.util.ToGson;
import org.springframework.data.annotation.Id;

/**
 *
 * @author z841158
 */
public class Race extends ToGson {

    @Id
    private int id;
    private String name;
    private String description;

    public Race() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
