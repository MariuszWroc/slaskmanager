/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.batch.processor;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.ItemProcessor;
import pl.mariuszczarny.slask.model.Contract;

/**
 *
 * @author mczarny
 */
public class ContractProcessor implements ItemProcessor<Contract, Contract> {

    private final static Logger fLogger = Logger.getLogger("AppJobAllExport");

    @Override
    public Contract process(Contract result) throws Exception {
        fLogger.log(Level.INFO, "Processing result :{0}", result);

        return result;
    }

}
