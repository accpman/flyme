package com.flyme.rbac.account.service.impl;


import com.flyme.core.mybatis.service.BaseServiceImpl;
import com.flyme.rbac.account.mapper.AccountMapper;
import com.flyme.rbac.account.entity.Account;
import com.flyme.rbac.account.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseServiceImpl<AccountMapper, Account> implements IAccountService {

}
