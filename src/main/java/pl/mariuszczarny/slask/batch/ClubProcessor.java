/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.batch;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.ItemProcessor;
import pl.mariuszczarny.slask.model.Club;

/**
 *
 * @author mczarny
 */
public class ClubProcessor implements ItemProcessor<Club, Club> {

    private final static Logger fLogger = Logger.getLogger("AppJobAllExport");

    @Override
    public Club process(Club result) throws Exception {
        fLogger.log(Level.INFO, "Processing result :{0}", result);

        return result;
    }
}
