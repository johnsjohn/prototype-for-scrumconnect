package com.prototype.scrumconnect.repositories;

import java.util.List;

import com.prototype.scrumconnect.models.UserDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public UserDataModel save(UserDataModel userData) {
        mongoTemplate.save(userData);
        return userData;
    }

    public List<UserDataModel> findAll() {
        return mongoTemplate.findAll(UserDataModel.class);
    }


}
