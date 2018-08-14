package com.flchen.permissiondemo.repository;

import com.flchen.permissiondemo.entity.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author feilongchen
 * @since 2018-08-14 6:05 PM
 */
@Repository
public interface UserAutoRepo extends MongoRepository<UserDO, String> {

	UserDO findByMobile(String mobile);
}
