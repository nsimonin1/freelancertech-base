/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base.dao.monitor;

import net.freelancertech.base.entites.AbstractEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author SimonPascal
 */
@Aspect
@Component
public class ServiceSecurity {

    @Before("execution(* net.freelancertech.base.repositories.*.*save(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        Object[] objects=joinPoint.getArgs();
        for (Object object : objects) {
           AbstractEntity entity=(AbstractEntity) object;
            entity.setUserCreate("Tester");
            entity.setUserMaj("Tester"); 
        }         
    }
}
