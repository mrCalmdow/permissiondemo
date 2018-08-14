package com.flchen.permissiondemo.entity;

import com.flchen.permissiondemo.common.entity.BaseDO;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author feilongchen
 * @since 2018-08-14 6:01 PM
 */
@Data
@Document(collection = "user")
public class UserDO extends BaseDO {

	private String mobile;

	private String name;

	private List<String> permissions;
}
