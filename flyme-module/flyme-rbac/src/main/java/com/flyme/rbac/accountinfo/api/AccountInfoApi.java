package com.flyme.rbac.accountinfo.api;

import com.flyme.common.base.ApiJson;
import com.flyme.core.mybatis.event.AfterQueryEvent;
import com.flyme.core.mybatis.event.BeforQueryEvent;
import com.flyme.core.springmvc.base.MbsBaseController;
import com.flyme.rbac.accountinfo.pojo.AccountInfo;
import com.flyme.rbac.accountinfo.service.IAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :flyme
 * @date : 2018/3/3 22:43
 * @description :用户管理接口
 */

@RestController
@RequestMapping("/api/account/")
public class AccountInfoApi extends MbsBaseController {

    @Autowired
    private IAccountInfoService accountInfoService;

    @PostMapping("reg")
    public ApiJson insert(ApiJson j,AccountInfo accountInfo) {
        //发布注册前通知事件
        applicationContext.publishEvent(new BeforQueryEvent(accountInfo,j));
        Boolean result = accountInfoService.insert(accountInfo);
        //发布注册后通知事件
        applicationContext.publishEvent(new AfterQueryEvent(this));
        return renderString(result, "注册成功");
    }
}
