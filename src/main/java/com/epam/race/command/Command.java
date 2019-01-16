package com.epam.race.command;

import com.epam.race.servlet.Router;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Router execute(HttpServletRequest req);
}
