package com.flchen.permissiondemo.repository;

import com.flchen.permissiondemo.entity.PermissionDO;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author feilongchen
 * @create 2018-08-15 12:21 PM
 */
@Repository
public interface PermissionAutoRepo extends MongoRepository<PermissionDO, String> {

	PermissionDO findByPermission(String permission);
}
