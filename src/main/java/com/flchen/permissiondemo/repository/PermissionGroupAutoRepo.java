package com.flchen.permissiondemo.repository;

import com.flchen.permissiondemo.entity.PermissionGroupDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author feilongchen
 * @since 2018-08-16 9:27 AM
 */
@Repository
public interface PermissionGroupAutoRepo extends MongoRepository<PermissionGroupDO, String> {

}
