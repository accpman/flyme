package com.flyme.core.springmvc.base;

import com.flyme.common.base.ApiJson;
import com.flyme.core.springmvc.binder.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 类描述：mybatis基础控制器
 */
@Controller
public class MbsBaseController {
    ApiJson j = new ApiJson();
    public static final Logger log = LoggerFactory.getLogger(MbsBaseController.class);


    /**
     * 后台接收Date转换
     */
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetimeFormat.setLenient(false);
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(java.sql.Timestamp.class, new CustomTimestampEditor(datetimeFormat, true));
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
        binder.registerCustomEditor(String.class, new StringEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(float.class, new FloatEditor());
    }


    /**
     * 客户端返回字符串
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            // 解决跨域问题
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 重定向至地址 url
     */
    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    protected ApiJson renderString(Boolean result, String info) {
        if (result) {
            j.setAppInfo(info);
        } else {
            j.setAppError("操作失敗");
        }
        return j;
    }

    protected ApiJson renderObject(Object obj) {

        return j.setObject(obj);

    }
}