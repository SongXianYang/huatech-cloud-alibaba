package com.huatech.filters;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description: 全局认证过滤器
 * @author: SongXY
 * @create: 2021-03-02 14:55
 **/
//@Component
@Log4j2
public class AuthGlobalFilter implements Ordered, GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //token
        if (!StringUtils.equals(token, "admin")) {
            log.error("认证出错啦！！");
            //未经授权问题
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //数值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
