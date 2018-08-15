package com.flchen.permissiondemo.web.mo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author feilongchen
 * @since 2018-08-14 6:27 PM
 */
@ApiModel
@Data
public class UserAddMO {

	@ApiModelProperty
	@NotBlank
	private String mobile;

	@ApiModelProperty
	@NotBlank
	private String name;

	@ApiModelProperty
	private Set<String> permissions;
}
