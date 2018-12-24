package com.epam.race.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Command {
    String execute(HttpServletRequest req);

}
