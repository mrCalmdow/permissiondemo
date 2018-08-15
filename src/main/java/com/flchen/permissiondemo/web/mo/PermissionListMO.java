package com.flchen.permissiondemo.web.mo;

import com.flchen.permissiondemo.common.mo.PageableMO;
import com.flchen.permissiondemo.entity.PermissionDO;
import lombok.Data;

import java.util.List;

/**
 * @author feilongchen
 * @since 2018-08-15 2:04 PM
 */
@Data
public class PermissionListMO extends PageableMO {

	private List<PermissionDO> content;
}
