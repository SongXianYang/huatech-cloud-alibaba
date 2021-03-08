package com.huatech.aop;

import com.huatech.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @description: 注解切面日志
 * @author: SongXY
 * @create: 2021-03-08 10:49
 **/
@Component
@Aspect//来定义一个切面
public class LogAspect {
    @Pointcut("@annotation(com.huatech.annotation.Log)")//注解定义切点，标记方法。
    public void operationLog() {
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        try {
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("获取到执行结果:"+proceed);//获取到执行结果
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();//获取标有这个注解的方法
            String name = methodSignature.getName();//获取方法的名称
            Method method = methodSignature.getMethod();
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("parameter = " + parameter);//获取参数
            }
            Object[] args = proceedingJoinPoint.getArgs();//获取参数值
            for (Object arg : args) {
                System.out.println("参数值 = " + arg);
            }
            Log logAnnotation = methodSignature.getMethod().getAnnotation(Log.class);
            if (logAnnotation != null) {
                System.out.println("获取注解属性id：" + logAnnotation.id());
                System.out.println("获取注解属性name：" + logAnnotation.name());
                System.out.println("获取注解属性operation：" + logAnnotation.operation());
            }
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("进入方法前执行.....");

    }

    /**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }
}
