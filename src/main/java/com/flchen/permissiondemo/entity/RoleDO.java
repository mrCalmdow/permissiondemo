package com.flchen.permissiondemo.entity;

import com.flchen.permissiondemo.common.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * @author feilongchen
 * @since 2018-08-15 4:40 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "role")
public class RoleDO extends BaseDO {

	/**
	 * 角色名
	 */
	private String name;

	/**
	 * 角色描述
	 */
	private String description;

	/**
	 * 角色具有的权限
	 */
	private Set<String> permissions = new HashSet<>();
}
