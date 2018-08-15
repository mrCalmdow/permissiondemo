package com.flchen.permissiondemo.domian;

import com.flchen.permissiondemo.common.annotation.Domain;
import com.flchen.permissiondemo.entity.UserDO;
import com.flchen.permissiondemo.repository.UserAutoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author feilongchen
 * @since 2018-08-15 4:16 PM
 */
@Domain
public class UserDomain {

	@Autowired
	private UserAutoRepo userAutoRepo;

	private UserDO entity;

	public boolean hasAnyPermission(String... permissions) {
		return false;
	}

	public Set<String> getAllPermissions() {
		return entity.getPermissions();
	}
}
