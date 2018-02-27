package com.flyme.rbac.accountinfo.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.flyme.common.base.EntityMap;
import com.flyme.core.mybatis.base.CriteriaQuery;
import com.flyme.core.springmvc.base.MbsBaseController;
import com.flyme.rbac.accountinfo.pojo.AccountInfo;
import com.flyme.rbac.accountinfo.service.IAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用戶信息列表
 */
@RestController
@RequestMapping("/accountinfo/")
public class AccountInfoListController extends MbsBaseController {

    @Autowired
    private IAccountInfoService accountInfoService;


    @GetMapping("list")
    public Page<EntityMap> data() {
        CriteriaQuery cq = new CriteriaQuery<AccountInfo>();
        Page page = new Page<AccountInfo>(1, 10);
        cq.setSqlSelect("ai.accountInfoId,ai.userName");
        cq.eq("ai.accountInfoId", "1").eq("ai.userName", "管理员");
        cq.createAlias("account","a");
        Page<EntityMap> list = accountInfoService.pageList(page, cq);
        return list;
    }
}
