package com.epam.race.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class CustomTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try {
            JspWriter out = pageContext.getOut();
            StringBuilder sb = new StringBuilder();
            sb.append(" © 2018 Copyright: WhoScored.com");
            out.write(sb.toString());
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
