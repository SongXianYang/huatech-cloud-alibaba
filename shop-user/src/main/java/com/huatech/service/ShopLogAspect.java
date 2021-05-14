package com.huatech.service;

import com.huatech.entity.ShopLog;
import com.huatech.service.ShopLogService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @Aspect 表明是一个切面类
 * @Component 将当前类注入到Spring容器内
 * @Pointcut 切入点，其中execution用于使用切面的连接点。使用方法：execution(方法修饰符(可选) 返回类型 方法名 参数 异常模式(可选)) ，可以使用通配符匹配字符，*可以匹配任意字符。
 * @Before 在方法前执行
 * @After 在方法后执行
 * @AfterReturning 在方法执行后返回一个结果后执行
 * @AfterThrowing 在方法执行过程中抛出异常的时候执行
 * @Around 环绕通知，就是可以在执行前后都使用，这个方法参数必须为ProceedingJoinPoint，proceed()方法就是被切面的方法，上面四个方法可以使用JoinPoint，JoinPoint包含了类名，被切面的方法名，参数等信息。
 */
/**
 * 切商城日志
 *
 * @author SongXianYang
 */
@Aspect
@Service
@Slf4j
public class ShopLogAspect {

    @Resource
    private ShopLogService shopLogService;

    @Pointcut("execution( * com.huatech.service.ShopBookService.*.*(..))")
    public void LogAspect() {
    }
    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("在方法后执行");
    }
    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        log.info("doAfterReturning:","在方法执行后返回一个结果后执行");
        //获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        log.info("name: ",name);
        Class aClass = signature.getDeclaringType();
        System.out.println(aClass);
        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName = " + declaringTypeName);
        int modifiers = signature.getModifiers();
        System.out.println("modifiers = " + modifiers);
        Class<? extends Signature> aClass1 = signature.getClass();
        System.out.println("aClass1 = " + aClass1);
//        ShopLog shopLog = new ShopLog();
//        shopLogService.insert(shopLog);
    }

}
