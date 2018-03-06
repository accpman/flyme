package com.flyme.rbac.accountinfo.controller;


import com.flyme.common.base.ApiJson;
import com.flyme.core.springmvc.base.MbsBaseController;
import com.flyme.rbac.accountinfo.entity.AccountInfo;
import com.flyme.rbac.accountinfo.service.IAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户管理
 * @author 张亚斐
 */
@RestController
@RequestMapping("/accountinfo/")
public class AccountInfoController extends MbsBaseController {

    @Autowired
    private IAccountInfoService accountInfoService;


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
