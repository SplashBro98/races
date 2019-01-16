package com.epam.race.servlet;

public class Router {

    private String page;
    public enum MoveType{
        FORWARD,
        REDIRECT
    }
    private MoveType moveType = MoveType.FORWARD;

    public Router() {
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setRedirect(){
        moveType = MoveType.REDIRECT;
    }


    public Router(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
