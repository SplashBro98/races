package com.epam.race.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class InfoTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        LocalTime localTime = LocalTime.now();
        String time = "<hr/>Time : <b> " + localTime.toString() + " </b><hr/>";

        try {
            JspWriter out = pageContext.getOut();
            out.write(time);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;

    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
