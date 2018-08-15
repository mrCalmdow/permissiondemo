package com.flchen.permissiondemo.web.controller.pub;

import com.flchen.permissiondemo.common.mo.ResponseMO;
import com.flchen.permissiondemo.common.web.BaseController;
import com.flchen.permissiondemo.entity.PermissionDO;
import com.flchen.permissiondemo.repository.PermissionAutoRepo;
import com.flchen.permissiondemo.web.mo.PermissionAddMO;
import com.flchen.permissiondemo.web.mo.PermissionListMO;
import com.flchen.permissiondemo.web.mo.PermissionUpdateMO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author feilongchen
 * @since 2018-08-15 12:20 PM
 */
@Slf4j
@Api(tags = "权限项管理")
@RestController
@RequestMapping("/pub/permissions")
public class PermissionController extends BaseController {

	@Autowired
	private PermissionAutoRepo permissionAutoRepo;

	@ApiOperation("添加一项权限")
	@PostMapping
	public ResponseMO addPermission(@RequestBody @Valid PermissionAddMO permissionAddMO) {
		PermissionDO permissionDO = permissionAutoRepo.findByPermission(permissionAddMO.getPermission());
		if(null != permissionDO) {
			log.info("Permission already exist.");
			return error("Permission already exist.");
		}

		permissionDO = new PermissionDO();
		BeanUtils.copyProperties(permissionAddMO, permissionDO);
		permissionAutoRepo.save(permissionDO);
		return success();
	}

	@ApiOperation("删除一条权限项")
	@DeleteMapping("/{id}")
	public ResponseMO deletePermission(@PathVariable @NotNull String id) {

		Optional<PermissionDO> permissionDO = permissionAutoRepo.findById(id);
		if(!permissionDO.isPresent()) {
			log.info("Permission Id :[{}] not exist.");
			return error("Permission Id :[{}] not exist.");
		}

		permissionAutoRepo.delete(permissionDO.get());
		return success();
	}

	@ApiOperation("修改一条权限项")
	@PutMapping
	public ResponseMO updatePermission(@RequestBody @Valid PermissionUpdateMO permissionUpdateMO) {
		Optional<PermissionDO> permissionDO = permissionAutoRepo.findById(permissionUpdateMO.getId());
		if(!permissionDO.isPresent()) {
			log.info("Permission Id :[{}] not exist.");
			return error("Permission Id :[{}] not exist.");
		}
		PermissionDO targetDO = permissionDO.get();
		BeanUtils.copyProperties(permissionUpdateMO, targetDO);
		permissionAutoRepo.save(targetDO);
		return success();
	}

	@ApiOperation("查询一条权限详情")
	@GetMapping("/{id}")
	public ResponseMO getPermission(@PathVariable @NotNull String id) {
		Optional<PermissionDO> permissionDO = permissionAutoRepo.findById(id);
		if(!permissionDO.isPresent()) {
			log.info("Permission Id :[{}] not exist.");
			return error("Permission Id :[{}] not exist.");
		}
		return success(permissionDO.get());
	}

	@ApiOperation("查询所有权限项")
	@GetMapping
	public ResponseMO allPermission() {
		PermissionListMO permissionListMO = new PermissionListMO();
		PageRequest pageRequest = PageRequest.of(permissionListMO.getPageNumber(), permissionListMO.getPageSize());
		Page<PermissionDO> page = permissionAutoRepo.findAll(pageRequest);
		if(CollectionUtils.isEmpty(page.getContent())) {
			List<PermissionDO> permissionDOS = new ArrayList<>();
			permissionListMO.setContent(permissionDOS);
			return success(permissionListMO);
		}
		permissionListMO.setContent(page.getContent());
		return success(permissionListMO);
	}
}
