package com.flchen.permissiondemo.entity;

import com.flchen.permissiondemo.common.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * @author feilongchen
 * @since 2018-08-14 6:01 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "user")
public class UserDO extends BaseDO {

	private String mobile;

	private String name;

	private Set<String> permissions;
}
