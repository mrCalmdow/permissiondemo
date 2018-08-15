package com.flchen.permissiondemo.web.mo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author feilongchen
 * @since 2018-08-15 12:29 PM
 */
@Data
public class PermissionAddMO {
	@NotBlank
	private String permission;
	@NotBlank
	private String description;
	private String type;
	/**
	 * 权限组id
	 */
	private String groupId;
}
