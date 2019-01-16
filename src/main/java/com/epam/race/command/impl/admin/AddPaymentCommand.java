package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.common.Payment;
import com.epam.race.service.PaymentService;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.servlet.Router;
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
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        PaymentValidator validator = new PaymentValidator();
        String paymentId = req.getParameter(StringAttribute.PAYMENT_ID);
        boolean isCorrectId = validator.isCorrectPaymentId(paymentId);
        if(!isCorrectId){
            req.setAttribute(StringAttribute.INCORRECT_ID, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_PAYMENT_PAGE));
            return router;
        }
        String sum = req.getParameter(StringAttribute.SUM);
        boolean isCorrectSum = validator.isCorrectSum(sum);
        if(!isCorrectSum){
            req.setAttribute(StringAttribute.INCORRECT_SUM, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_PAYMENT_PAGE));
            return router;
        }

        try {
            PaymentService paymentService = new PaymentService();
            paymentService.addPayment(new Payment(paymentId, new BigDecimal(sum)));

            RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                    IntegerConstant.COUNT_OF_RACES);
            List<Object> attributes = raceService.mainAttributes();
            req.getSession().setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
            req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
            req.setAttribute(StringAttribute.RACES, raceService.findCurrentRaces());

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in AddPaymentCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }

        return router;
    }
}
