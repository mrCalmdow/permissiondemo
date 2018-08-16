package com.flchen.permissiondemo.permission;


import com.flchen.permissiondemo.entity.UserDO;
import com.flchen.permissiondemo.permission.annotation.Permission;
import com.flchen.permissiondemo.permission.properties.CommomProperties;
import com.flchen.permissiondemo.repository.UserAutoRepo;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Beldon
 * @create 2018-04-10 上午9:21
 */
@Component
public class PermissionAdvice implements MethodInterceptor {

	private final PermissionJudge permissionJudge;

	@Autowired
	private UserAutoRepo userAutoRepo;

	@Autowired
	private CommomProperties commomProperties;

	//通过构造方法自动注入
	public PermissionAdvice(PermissionJudge permissionJudge) {
		this.permissionJudge = permissionJudge;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String mobile = request.getHeader(commomProperties.getPermissionHeader());
		Permission permission = invocation.getMethod().getAnnotation(Permission.class);
		if (StringUtils.isEmpty(mobile)) {
//			throw new Exception("请求非法，必须包含请求头mobile");
			return permissionJudge.noPermissionReturn();
		}
		//TODO 查询用户的权限，判断是否存在权限
		UserDO user = userAutoRepo.findByMobile(mobile);
		if (null == user) {
//			throw new Exception("请求非法，用户mobile不存在");
			return permissionJudge.noPermissionReturn();
		}
		if (permissionJudge.hasPermission(user.getId(), permission.permissions())) {
			return invocation.proceed();
		}
		return permissionJudge.noPermissionReturn();
	}
}
