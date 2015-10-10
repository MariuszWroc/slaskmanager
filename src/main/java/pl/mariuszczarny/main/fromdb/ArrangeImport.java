/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.main.fromdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import pl.mariuszczarny.slask.batch.common.ApplicationContextUtil;

/**
 *
 * @author mczarny
 */
@Configuration
@EnableBatchProcessing
public class ArrangeImport implements ApplicationContextAware{

    private final static Logger fLogger = Logger.getLogger("AppJobArrangeImport");
    
    private static ApplicationContext findedContext;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fLogger.log(Level.INFO, "Import arrange csv from mysql");
        
        ApplicationContext appContext = null;
        ApplicationContextUtil contextUtil = new ApplicationContextUtil(appContext, "fromcsv/arrange.xml");
        findedContext = contextUtil.getApplicationContext();
        if (findedContext != null) {
            JobLauncher jobArrangeLauncher = (JobLauncher) findedContext.getBean("jobLauncher");
            Job arrangeJob = (Job) findedContext.getBean("arrangeImportJob");

            try {
                JobExecution execution = jobArrangeLauncher.run(arrangeJob, new JobParameters());
                fLogger.log(Level.INFO, "Exit Status : {0}", execution.getStatus());
            } catch (JobParametersInvalidException e) {
                e.getMessage();
            } catch (JobExecutionAlreadyRunningException e) {
                e.getMessage();
            } catch (JobInstanceAlreadyCompleteException e) {
                e.getMessage();
            } catch (JobRestartException e) {
                e.getMessage();
            }
            fLogger.log(Level.INFO, "Done");
        } else {
            fLogger.log(Level.INFO, "Application context not set");
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
