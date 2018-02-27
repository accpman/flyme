package com.flyme.rbac.accountinfo.controller;


import com.flyme.core.mybatis.model.ApiJson;
import com.flyme.core.springmvc.base.MbsBaseController;
import com.flyme.rbac.accountinfo.pojo.AccountInfo;
import com.flyme.rbac.accountinfo.service.IAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用戶信息管理
 */
@RestController
@RequestMapping("/accountinfo/")
public class AccountInfoController extends MbsBaseController {

    @Autowired
    private IAccountInfoService accountInfoService;


    @PostMapping("insert")
    public ApiJson insert(AccountInfo accountInfo) {
        Boolean result = accountInfoService.insert(accountInfo);
        return renderString(result,"添加成功");
    }

    @PostMapping("update")
    public ApiJson update(AccountInfo accountInfo) {
        Boolean result = accountInfoService.updateById(accountInfo);
        return renderString(result,"更新成功");
    }

    @PostMapping("insertOrUpdate")
    public ApiJson insertOrUpdate(AccountInfo accountInfo) {
        Boolean result = accountInfoService.insertOrUpdate(accountInfo);
        return renderString(result,"操作成功");
    }

    @GetMapping("selectById")
    public ApiJson selectById(String accountInfoId) {
        AccountInfo accountInfo = accountInfoService.selectById(accountInfoId);
        return renderObject(accountInfo);
    }
}
