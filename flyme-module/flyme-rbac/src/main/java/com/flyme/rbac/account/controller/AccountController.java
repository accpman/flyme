package com.flyme.rbac.account.controller;


import com.flyme.common.base.ApiJson;
import com.flyme.core.springmvc.base.MbsBaseController;
import com.flyme.rbac.account.pojo.Account;
import com.flyme.rbac.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 账户管理
 */
@RestController
@RequestMapping("/account/")
public class AccountController extends MbsBaseController {

    @Autowired
    private IAccountService accountService;


    @PostMapping("insert")
    public ApiJson insert(Account account) {
        Boolean result = accountService.insert(account);
        return renderString(result,"添加成功");
    }

    @PostMapping("update")
    public ApiJson update(Account account) {
        Boolean result = accountService.updateById(account);
        return renderString(result,"更新成功");
    }

    @PostMapping("insertOrUpdate")
    public ApiJson insertOrUpdate(Account account) {
        Boolean result = accountService.insertOrUpdate(account);
        return renderString(result,"操作成功");
    }

    @GetMapping("selectById")
    public ApiJson selectById(String accountId) {
        Account account = accountService.selectById(accountId);
        return renderObject(account);
    }
}
