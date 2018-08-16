package com.flchen.permissiondemo.permission;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.stereotype.Component;

/**
 * @author Beldon
 * @create 2018-04-10 上午9:40
 */
@Component
public class PermissionPointCutAdvisor extends AbstractPointcutAdvisor {

    private final Pointcut pointcut;
    private final Advice advice;

    public PermissionPointCutAdvisor(Advice advice) {
        this.pointcut = new PermissionAnnotationMatchingPointcut();
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
