package com.epam.race.command.impl.admin;

public class DeleteHorseCommand {

//    @Override
//    public String execute(HttpServletRequest req) {
//        String page;
//
//        String name = req.getParameter("name");
//        try{
//            HorseRepository.getInstance().remove(new Horse(name));
//            req.setAttribute("horses",HorseRepository.getInstance().query(
//                    new SelectAllHorsesSpecification()));
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
//
//        }catch (SQLException e){
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
//    }
}
