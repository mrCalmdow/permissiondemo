package com.flchen.permissiondemo.entity;

import com.flchen.permissiondemo.common.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * @author feilongchen
 * @since 2018-08-15 4:46 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "permissionGroup")
public class PermissionGroupDO extends BaseDO {

	public static final String TYPE_API = "api";
	public static final String TYPE_MENU = "menu";

	/**
	 * 权限组名
	 */
	private String name;

	/**
	 * 权限组描述
	 */
	private String description;

	/**
	 * 权限组类型
	 */
	private String type;

	/**
	 * 权限集合
	 */
	@DBRef
	private Set<String> permissions = new HashSet<>();
}
