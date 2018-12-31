package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Payment;
import com.epam.race.entity.user.User;
import com.epam.race.service.PaymentService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.util.validation.PaymentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class TopUpBalanceCommand implements Command {
    private static Logger logger = LogManager.getLogger(TopUpBalanceCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        PaymentValidator validator = new PaymentValidator();
        String paymentId = req.getParameter("paymentId");
        boolean isCorrectId = validator.isCorrectPaymentId(paymentId);
        if(!isCorrectId){
            req.setAttribute("incorrect_id","incorrect payment ID");
            return PageManager.INSTANCE.getProperty(PageManager.PATH_TOP_UP_BALANCE_PAGE);
        }

        try{
            PaymentService paymentService = new PaymentService();
            Optional<Payment> maybePayment = paymentService.findPaymentById(paymentId);
            if(!maybePayment.isPresent()){
                req.setAttribute("incorrect_id","payment with this ID doesn`t exist");
                return PageManager.INSTANCE.getProperty(PageManager.PATH_TOP_UP_BALANCE_PAGE);
            }

            Payment payment = maybePayment.get();
            UserService userService = new UserService();
            String userLogin = req.getSession().getAttribute("login").toString();
            User user = userService.findUserByLogin(userLogin);
            userService.updateUserAmount(userLogin,payment.getSum().add(user.getAmount()));
            paymentService.deletePayment(paymentId);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            logger.error("sdfsd",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
