package com.huatech.predicate;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 自定义的一个年龄断言
 * @author: SongXY
 * @create: 2021-03-02 10:56
 **/
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    //构造器
    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }
    //用于从配置文件中获取参数值赋值到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {
    //这里的顺序要跟配置文件中的参数顺序一致
        return Arrays.asList("ageMin", "ageMax");
    }
    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.isEmpty(ageStr)) {
                    return false;
                }
                //string类型转换成integer类型
                int age = Integer.parseInt(ageStr);
                //判断传过来的值是否是在这个区间内，如果在这个区间，就返回true
                if (age > config.getAgeMin() && age < config.getAgeMax()) {
                    return true;
                }
                // 是否存在配置的文件
                return false;
            }
        };
    }
    @Data
    @NoArgsConstructor
    public static class Config {
        private int ageMin;
        private int ageMax;
    }
}
