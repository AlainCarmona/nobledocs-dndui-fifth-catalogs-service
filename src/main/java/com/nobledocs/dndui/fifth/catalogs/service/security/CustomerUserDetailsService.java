/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nobledocs.dndui.fifth.catalogs.service.security;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author z841158
 */
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        MongoDatabase database = mongoClient.getDatabase("dndui-fifth");
        MongoCollection<Document> collection = database.getCollection("user");

        Document document = collection.find(Filters.eq("username", user)).first();

        if (document != null) {
            String username = document.getString("username");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");

            MongoUserDetails mongoUserDetails = new MongoUserDetails(username, password, authorities.toArray(new String[authorities.size()]));

            return mongoUserDetails;
        }

        return null;
    }

}
