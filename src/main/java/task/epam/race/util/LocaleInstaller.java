package task.epam.race.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleInstaller {

    public void installLocale(HttpServletRequest req, Locale locale){
        ResourceBundle bundle = ResourceBundle.getBundle("text", locale);
        req.setAttribute("head", bundle.getString("head"));
        req.setAttribute("string",bundle.getString("string"));
        req.setAttribute("enter1",bundle.getString("enter1"));
        req.setAttribute("enter2",bundle.getString("enter2"));
        req.setAttribute("enter3",bundle.getString("enter3"));
    }
}
