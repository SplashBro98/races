package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.common.Payment;
import com.epam.race.entity.user.User;
import com.epam.race.service.PaymentService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.servlet.Router;
import com.epam.race.validation.PaymentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class TopUpBalanceCommand implements Command {
    private static Logger logger = LogManager.getLogger(TopUpBalanceCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        PaymentValidator validator = new PaymentValidator();
        String paymentId = req.getParameter(StringAttribute.PAYMENT_ID);
        boolean isCorrectId = validator.isCorrectPaymentId(paymentId);
        if(!isCorrectId){
            req.setAttribute(StringAttribute.INCORRECT_ID, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_TOP_UP_BALANCE_PAGE));
            return router;
        }

        try{
            PaymentService paymentService = new PaymentService();
            Optional<Payment> maybePayment = paymentService.findPaymentById(paymentId);
            if(!maybePayment.isPresent()){
                req.setAttribute(StringAttribute.INCORRECT_ID, StringAttribute.TRUE);
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_TOP_UP_BALANCE_PAGE));
                return router;
            }

            Payment payment = maybePayment.get();
            UserService userService = new UserService();
            String userLogin = req.getSession().getAttribute(StringAttribute.LOGIN).toString();
            User user = userService.findUserByLogin(userLogin);
            userService.updateUserAmount(userLogin,payment.getSum().add(user.getAmount()));
            paymentService.deletePayment(paymentId);

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in TopUpBalanceCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
