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
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mczarny
 */
public class CoachImport {

    private final static Logger fLogger = Logger.getLogger("AppJobCoachImport");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fLogger.log(Level.INFO, "Import coach csv from mysql");
        String[] springConfig
                = {"spring/batch/config/database.xml",
                    "spring/batch/config/context.xml",
                    "spring/batch/jobs/fromdb/coach.xml"
                };

        ApplicationContext context
                = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobCoachLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job coachJob = (Job) context.getBean("coachImportJob");

        try {
            JobExecution execution = jobCoachLauncher.run(coachJob, new JobParameters());
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
    }
    
}
