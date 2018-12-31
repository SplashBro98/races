package com.epam.race.command.impl.client;

import com.epam.race.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConfirmSignUpCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String submittedCode = req.getParameter("confirm code"); //ConstantAttributes.CONFIRM_CODE
        HttpSession httpSession = req.getSession();
        String realCode = String.valueOf(httpSession.getAttribute("confirm code")).trim(); //ConstantAttributes.CONFIRM_CODE


//        String page;
//        if (submittedCode.equals(realCode)){
//            Client client = (Client) httpSession.getAttribute(ConstantAttributes.CLIENT);
//            String encryptedPassword = String.valueOf(httpSession.getAttribute(ConstantAttributes.ENCRYPTED_PASSWORD));
//            RegisterLogic.registerNewClient(client, encryptedPassword);
//            page = ConfigurationManager.getProperty(ConstantPathPages.PATH_PAGE_MAIN_CLIENT);
//            httpSession.setAttribute(ConstantAttributes.LOGIN, client.getLogin());
//            httpSession.setAttribute(ConstantAttributes.USER, client);
//        } else {
//            httpServletRequest.setAttribute(ConstantAttributes.ERROR_CONFIRM_CODE,
//                    messageManager.getMessage(ConstantMessages.PATH_ERROR_WRONG_CONFIRM_CODE));
//            page = ConfigurationManager.getProperty(ConstantPathPages.PATH_PAGE_CONFIRM);
//        }
//        router.setPagePath(page);
//        return router;
        return null;
    }
}
