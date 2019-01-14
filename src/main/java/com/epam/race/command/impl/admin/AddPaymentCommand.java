package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttributes;
import com.epam.race.entity.common.Payment;
import com.epam.race.service.PaymentService;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import com.epam.race.validation.PaymentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public class AddPaymentCommand implements Command {
    private static Logger logger = LogManager.getLogger(AddPaymentCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        PaymentValidator validator = new PaymentValidator();
        String paymentId = req.getParameter(StringAttributes.PAYMENT_ID);
        boolean isCorrectId = validator.isCorrectPaymentId(paymentId);
        if(!isCorrectId){
            req.setAttribute(StringAttributes.INCORRECT_ID,StringAttributes.TRUE);
            return PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_PAYMENT_PAGE);
        }
        String sum = req.getParameter(StringAttributes.SUM);
        boolean isCorrectSum = validator.isCorrectSum(sum);
        if(!isCorrectSum){
            req.setAttribute(StringAttributes.INCORRECT_SUM, StringAttributes.TRUE);
            return PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_PAYMENT_PAGE);
        }

        try {
            PaymentService paymentService = new PaymentService();
            paymentService.addPayment(new Payment(paymentId, new BigDecimal(sum)));

            RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                    IntegerConstant.COUNT_OF_RACES);
            List<Object> attributes = raceService.mainAttributes();
            req.setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
            req.setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
            req.setAttribute(StringAttributes.RACES, raceService.findCurrentRaces());

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            logger.error("Service Exception in AddPaymentCommand",e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }

        return page;
    }
}
