package com.flchen.permissiondemo.repository;

import com.flchen.permissiondemo.entity.RoleDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author feilongchen
 * @since 2018-08-16 9:26 AM
 */
@Repository
public interface RoleAutoRepo extends MongoRepository<RoleDO, String> {

}
