package com.flyme.rbac.accountinfo.service.impl;


import com.flyme.core.mybatis.service.BaseServiceImpl;
import com.flyme.rbac.accountinfo.mapper.AccountInfoMapper;
import com.flyme.rbac.accountinfo.entity.AccountInfo;
import com.flyme.rbac.accountinfo.service.IAccountInfoService;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService extends BaseServiceImpl<AccountInfoMapper, AccountInfo> implements IAccountInfoService {

}
