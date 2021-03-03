package com.huatech.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;


import javax.servlet.http.HttpServletRequest;

/**
 * @description: 自定义来源处理规则
 * @author: SongXY
 * @create: 2021-02-28 18:00
 **/
//@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String s = httpServletRequest.getParameter("ServiceName");
        if (StringUtils.isEmpty(s)) {
            throw new RuntimeException();
        }
        return s;
    }
}
