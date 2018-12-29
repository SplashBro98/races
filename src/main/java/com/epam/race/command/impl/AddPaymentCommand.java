package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Payment;
import com.epam.race.service.PaymentService;
import com.epam.race.service.ServiceException;
import com.epam.race.util.validation.PaymentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class AddPaymentCommand implements Command {
    private static Logger logger = LogManager.getLogger(AddPaymentCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        PaymentValidator validator = new PaymentValidator();
        String paymentId = req.getParameter("paymentId");
        boolean isCorrectId = validator.isCorrectPaymentId(paymentId);
        if(!isCorrectId){
            req.setAttribute("incorrect_id","incorrect payment ID");
            return PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_PAYMENT_PAGE);
        }
        String sum = req.getParameter("sum");
        boolean isCorrectSum = validator.isCorrectSum(sum);
        if(!isCorrectSum){
            req.setAttribute("incorrect_sum","incorrect Sum");
            return PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_PAYMENT_PAGE);
        }

        try {
            PaymentService paymentService = new PaymentService();
            paymentService.addPayment(new Payment(paymentId, new BigDecimal(sum)));

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            logger.error("sdfsdvds",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }

        return page;
    }
}
