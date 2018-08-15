package com.flchen.permissiondemo.web.controller.member;

import com.flchen.permissiondemo.common.mo.ResponseMO;
import com.flchen.permissiondemo.common.web.BaseController;
import com.flchen.permissiondemo.permission.annotation.Permission;
import com.flchen.permissiondemo.permission.constants.PermissionConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feilongchen
 * @since 2018-08-15 10:39 AM
 */
@Slf4j
@Api(tags = "需要鉴权的操作")
@RestController
@RequestMapping("/member/operations")
public class OperationController extends BaseController {

	@ApiOperation("测试token过滤器是否生效")
	@GetMapping("/test")
	public ResponseMO testToken() {
		log.info("Hi, this method test for toke authorization.");
		return success();
	}

	@ApiOperation("测试permission拦截器是否生效")
	@Permission(permissions = {PermissionConstants.Permission.ADD})
	@GetMapping("/permission")
	public ResponseMO testPermission() {
		log.info("This method test for permission" + PermissionConstants.Permission.ADD);
		return success();
	}
}
