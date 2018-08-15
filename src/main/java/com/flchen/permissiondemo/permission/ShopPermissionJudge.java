package com.flchen.permissiondemo.permission;

import com.flchen.permissiondemo.common.util.ResponseUtil;
import com.flchen.permissiondemo.entity.UserDO;
import com.flchen.permissiondemo.permission.properties.CommomProperties;
import com.flchen.permissiondemo.repository.UserAutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.Set;

/**
 * @author feilongchen
 * @since 2018-08-15 2:44 PM
 */
@Component
public class ShopPermissionJudge implements PermissionJudge {

	@Autowired
	private UserAutoRepo userAutoRepo;

	@Autowired
	private CommomProperties commomProperties;

	@Override
	public boolean hasPermission(String userId, String[] permissions) {
		Optional<UserDO> optionalUserDO = userAutoRepo.findById(userId);
		if(!optionalUserDO.isPresent()) {
			return false;
		}
		UserDO userDO = optionalUserDO.get();
		Set<String> userPermissions = userDO.getPermissions();
		if(CollectionUtils.isEmpty(userPermissions)) {
			return false;
		}
		for(String permission : permissions) {
			//用户有做任意一个权限就可以访问
			if(userPermissions.contains(permission)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object noPermissionReturn() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return ResponseUtil.error("无权限");
	}
}
