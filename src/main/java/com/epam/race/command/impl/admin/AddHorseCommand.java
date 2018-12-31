package com.epam.race.command.impl.admin;

public class AddHorseCommand  {

//    @Override
//    public String execute(HttpServletRequest req) {
//        Horse horse = new Horse();
//        horse.setName(req.getParameter("name"));
//        horse.setAge(Integer.parseInt(req.getParameter("age")));
//        horse.setWins(Integer.parseInt(req.getParameter("wins")));
//
//        String page;
//        try{
//            HorseRepository.getInstance().add(horse);
//
//            new MainPageService().setAttributes(req);
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
//        }catch (SQLException e){
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
//    }
}
