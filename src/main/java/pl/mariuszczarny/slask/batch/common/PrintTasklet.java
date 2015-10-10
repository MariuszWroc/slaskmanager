/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.batch.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 *
 * @author mczarny
 */
public class PrintTasklet implements Tasklet{
    final static Logger logger = LoggerFactory.getLogger(PrintTasklet.class);
    private String message;
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        logger.info(message);
        return RepeatStatus.FINISHED;
    }
}
