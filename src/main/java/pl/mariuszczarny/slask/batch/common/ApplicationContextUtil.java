/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.batch.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mczarny
 */
public final class ApplicationContextUtil {
    private final static Logger logger = LoggerFactory.getLogger(PrintTasklet.class);
    private final String fileName;
    private ApplicationContext applicationContext;

    
    public ApplicationContextUtil(ApplicationContext applicationContext, String fileName) {
        this.fileName = fileName;
        setApplicationContext(applicationContext);

    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        if (fileName.isEmpty()) {
            logger.error("String contain batch configuration is empty");
        } else {
            this.applicationContext = new ClassPathXmlApplicationContext("file:src/main/resources/spring/batch/jobs/" + fileName);
        }
    }
    
}
