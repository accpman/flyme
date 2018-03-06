package com.flyme.rbac.role.service.impl;

import com.flyme.rbac.role.entity.Role;
import com.flyme.rbac.role.mapper.RoleMapper;
import com.flyme.rbac.role.service.IRoleService;
import com.flyme.core.mybatis.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author flyme
 * @since 2018-03-06
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {

}
