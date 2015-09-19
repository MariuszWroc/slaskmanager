/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.batch;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.ItemProcessor;
import pl.mariuszczarny.slask.model.Finance;

/**
 *
 * @author mczarny
 */
public class FinanceProcessor implements ItemProcessor<Finance, Finance> {

    private final static Logger fLogger = Logger.getLogger("AppJobAllExport");

    @Override
    public Finance process(Finance result) throws Exception {
        fLogger.log(Level.INFO, "Processing result :{0}", result);

        return result;
    }

}