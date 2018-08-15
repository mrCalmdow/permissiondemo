package com.flchen.permissiondemo.web.controller.pub;

import com.flchen.permissiondemo.common.mo.ResponseMO;
import com.flchen.permissiondemo.common.web.BaseController;
import com.flchen.permissiondemo.entity.UserDO;
import com.flchen.permissiondemo.repository.UserAutoRepo;
import com.flchen.permissiondemo.web.mo.UserAddMO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author feilongchen
 * @since 2018-08-14 6:04 PM
 */
@Api(tags = "用户管理")
@Slf4j
@RestController
@RequestMapping("/pub/users")
public class UserController extends BaseController {

	@Autowired
	private UserAutoRepo userAutoRepo;

	@ApiOperation("增加用户")
	@PostMapping
	public ResponseMO addUser(@RequestBody @Valid UserAddMO userAddMO) {
		UserDO userDO = userAutoRepo.findByMobile(userAddMO.getMobile());
		if(null != userDO) {
			log.info("用户手机号：[{}]已经存在。", userAddMO.getMobile());
			error("用户手机号：[" + userAddMO.getMobile() + "}]已经存在。");
		}
		userDO = new UserDO();
		userDO.setMobile(userAddMO.getMobile());
		userDO.setName(userAddMO.getName());
		userDO.setPermissions(userAddMO.getPermissions());
		userAutoRepo.save(userDO);
		return success();
	}
}
