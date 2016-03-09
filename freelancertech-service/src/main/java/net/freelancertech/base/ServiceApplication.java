/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.freelancertech.base;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author SimonPascal
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import(PersistenceContext.class)
@EnableJpaRepositories(basePackages = "net.freelancertech.base.repositories")

public class ServiceApplication {
    
}
