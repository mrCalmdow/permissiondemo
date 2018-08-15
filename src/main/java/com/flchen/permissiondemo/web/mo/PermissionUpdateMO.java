package com.flchen.permissiondemo.web.mo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author feilongchen
 * @since 2018-08-15 12:29 PM
 */
@Data
public class PermissionUpdateMO {

	@NotNull
	private String id;

	@NotBlank
	private String name;
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
