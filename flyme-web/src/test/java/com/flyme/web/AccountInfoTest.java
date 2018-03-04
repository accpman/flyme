package com.flyme.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.flyme.common.base.EntityMap;
import com.flyme.core.mybatis.base.CriteriaQuery;
import com.flyme.common.base.ApiJson;
import com.flyme.rbac.account.pojo.Account;
import com.flyme.rbac.accountinfo.pojo.AccountInfo;
import com.flyme.rbac.accountinfo.service.IAccountInfoService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlymeWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class AccountInfoTest {
    @Autowired
    private IAccountInfoService accountInfoService;
    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * 测试find方法
     */
    @Test
    public void find() {
        AccountInfo account = accountInfoService.selectById("1");
        System.out.print("用户:" + account);
    }

    /**
     * 测试insert(插入语句只显示非空字段)方法
     */
    @Test
    public void insert() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUserName("测试1");
        Boolean flag = accountInfoService.insert(accountInfo);
        System.out.print("添加用户:" + accountInfo);
    }
    /**
     * 测试insertAllColumn(插入语句显示全部字段)方法
     */
    @Test
    public void insertAllColumn() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUserName("测试1");
        Boolean flag = accountInfoService.insertAllColumn(accountInfo);
        System.out.print("添加用户:" + accountInfo);
    }
    /**
     * 测试insertOrUpdate方法-add
     */
    @Test
    public void insertOrUpdate1() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUserName("测试1");
        Boolean flag = accountInfoService.insertOrUpdate(accountInfo);
        System.out.print("添加用户:" + accountInfo);
    }
    /**
     * 测试insertOrUpdate方法-update
     */
    @Test
    public void insertOrUpdate2() {
        AccountInfo accountInfo = new AccountInfo("73af25f2dea3427ba8fb5d919b5880f8");
        accountInfo.setUserName("测试2");
        Boolean flag = accountInfoService.insertOrUpdate(accountInfo);
        System.out.print("更新用户:" + accountInfo);
    }
    /**
     * 测试deleteById(根据主键删除)方法
     */
    @Test
    public void deleteById() {
        Boolean flag = accountInfoService.deleteById("3");
        System.out.print("删除用户:" + flag);
    }
    /**
     * 测试deleteBatchIds(根据主键批量删除)方法
     */
    @Test
    public void deleteBatchIds() {
        List<String> ids= Lists.newArrayList("2","3","4");
        Boolean flag = accountInfoService.deleteBatchIds(ids);
        System.out.print("批量删除用户:" + flag);
    }
    /**
     * 测试deleteByMap(构造map删除)方法
     */
    @Test
    public void deleteByMap() {
        EntityMap map=new EntityMap();
        map.put("userName","测试1");
        Boolean flag = accountInfoService.deleteByMap(map);
        System.out.print("删除用户:" + flag);
    }
    /**
     * 测试deleteByCq(构造CriteriaQuery删除)方法
     */
    @Test
    public void deleteByCq() {
        CriteriaQuery cq=new CriteriaQuery();
        cq.eq("userName","测试1").and("age>{0}","3").ge("sex",3);
        cq.orNew();
        cq.eq("nickName","test");
        Boolean flag = accountInfoService.delete(cq);
        System.out.print("删除用户:" + flag);
    }
    /**
     * 测试updateById方法
     */
    @Test
    public void updateById() {
        AccountInfo accountInfo=new AccountInfo("3");
        accountInfo.setUserName("测试2");
        Boolean flag = accountInfoService.updateById(accountInfo);
        System.out.print("更新用户:" + flag);
    }
    /**
     * 测试update(构造CriteriaQuery更新)方法
     */
    @Test
    public void update() {
        AccountInfo accountInfo=new AccountInfo();
        accountInfo.setUserName("测试");
        CriteriaQuery cq=new CriteriaQuery();
        cq.eq("accountInfoId","3");
        Boolean flag = accountInfoService.update(accountInfo,cq);
        System.out.print("更新用户:" + flag);
    }


    /**
     * 测试selectById接口
     */
    @Test
    public void selectById() {
        Map<String, String> params = new HashMap<>();
        params.put("accountInfoId", "1");
        ApiJson result = testRestTemplate.postForObject("/api/account/reg",null, ApiJson.class, params);
        System.out.print("selectById:" + result);
    }

    /**
     * 测试selectBatchIds(根据主键批量查询)方法
     */
    @Test
    public void selectBatchIds() {
        List<String> ids= Lists.newArrayList("2","3","4");
        List<AccountInfo> list= accountInfoService.selectBatchIds(ids);
        System.out.print("批量查询用户:" + list);
    }
    /**
     * 测试selectByMap(构造map查询)方法
     */
    @Test
    public void selectByMap() {
        EntityMap map=new EntityMap();
        map.put("userName","测试1");
        List<AccountInfo> list = accountInfoService.selectByMap(map);
        System.out.print("查询用户:" + list);
    }

    /**
     * selectMap(构造CriteriaQuery查询)方法返回map
     */
    @Test
    public void selectMap() {
        CriteriaQuery cq=new CriteriaQuery();
        cq.eq("accountInfoId","1");
        Map accountInfo = accountInfoService.selectMap(cq);
        System.out.print("查询用户:" + accountInfo);
    }

    /**
     * selectObj(构造CriteriaQuery查询)方法返回Object
     */
    @Test
    public void selectObj() {
        CriteriaQuery cq=new CriteriaQuery();
        cq.setSqlSelect("nickName");
        Object accountInfo = accountInfoService.selectObj(cq);
        System.out.print("查询用户:" + accountInfo);
    }
    /**
     * selectObjs(构造CriteriaQuery查询)方法返回List<Object>
     */
    @Test
    public void selectObjs() {
        CriteriaQuery cq=new CriteriaQuery();
        cq.setSqlSelect("nickName");
        List<Object> accountInfo = accountInfoService.selectObjs(cq);
        System.out.print("查询用户:" + accountInfo);
    }
    /**
     * selectOne(构造entity查询)方法
     */
    @Test
    public void selectOne() {
        CriteriaQuery cq=new CriteriaQuery();
        cq.eq("accountInfoId","3");
        AccountInfo accountInfo = accountInfoService.selectOne(cq);
        System.out.print("查询用户:" + accountInfo);
    }

    /**
     * selectCount(构造entity统计数量)方法
     */
    @Test
    public void selectCount() {
        CriteriaQuery cq=new CriteriaQuery();
        cq.eq("accountInfoId","3");
        int n = accountInfoService.selectCount(cq);
        System.out.print("查询用户:" + n);
    }


    /**
     * 测试selectList方法的
     */
    @Test
    public void selectList() {
        CriteriaQuery cq = new CriteriaQuery<AccountInfo>();
        cq.eq("accountInfoId", "1");
        List<Account> userList = accountInfoService.selectList(cq);
        System.out.print("selectList:" + userList);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void selectPage() {
        CriteriaQuery cq = new CriteriaQuery<AccountInfo>();
        Page page = new Page<AccountInfo>(1, 10);
        cq.eq("accountInfoId", "1");
        Page<AccountInfo> result = accountInfoService.selectPage(page, cq);
        System.out.print("selectPage:" + result);
    }
    /**
     * 测试分页查询
     */
    @Test
    public void selectMapsPage() {
        CriteriaQuery cq = new CriteriaQuery<AccountInfo>();
        Page page = new Page<AccountInfo>(1, 10);
        cq.eq("accountInfoId", "1");
        Page<Map> result = accountInfoService.selectMapsPage(page, cq);
        System.out.print("selectPage:" + result);
    }

    /**
     * 测试自定义分页查询
     */
    @Test
    public void pageList() {
        CriteriaQuery cq = new CriteriaQuery<AccountInfo>();
        Page page = new Page<AccountInfo>(1, 10);
        cq.setSqlSelect("ai.accountInfoId,ai.userName");
        cq.eq("ai.accountInfoId", "1").eq("ai.userName", "管理员");
        cq.createAlias("account","a");
        Page<EntityMap> list = accountInfoService.pageList(page, cq);
        System.out.print("自定义分页pageList:####" + list);
    }
}
