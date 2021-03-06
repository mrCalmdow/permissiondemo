package com.flchen.permissiondemo.entity;

import com.flchen.permissiondemo.common.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author feilongchen
 * @since 2018-08-14 6:18 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "permission")
public class PermissionDO extends BaseDO {
	public static final String TYPE_API = "api";
	public static final String TYPE_MENU = "menu";

	/**
	 * 权限标识
	 */
	private String permission;
	/**
	 * 权限说明
	 */
	private String description;
	/**
	 * 权限类型
	 */
	private String type;
	/**
	 * 权限组id
	 */
	private String groupId;
}
