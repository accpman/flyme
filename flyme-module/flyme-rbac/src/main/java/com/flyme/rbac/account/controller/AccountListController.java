package com.flyme.rbac.account.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.flyme.core.springmvc.base.MbsBaseController;
import com.flyme.rbac.account.entity.Account;
import com.flyme.rbac.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 账户列表
 */
@RestController
@RequestMapping("/account/")
public class AccountListController extends MbsBaseController {

    @Autowired
    private IAccountService accountService;


    @GetMapping("list")
    public Page<Account> data() {
        EntityWrapper ew = new EntityWrapper<Account>();
        Page page = new Page<Account>(1, 10);
        ew.eq("accountId", "1");
        Page<Account> accountList = accountService.pageList(page, ew);
        return accountList;
    }
}
