package com.epam.race.command.impl;

public class SelectHorseCommand  {

//    @Override
//    public String execute(HttpServletRequest req){
//        String page;
//        String name = req.getParameter("name");
//        try {
//            List<Horse> horses = HorseRepository.getInstance().query(new SelectHorseByNameSpecification(name));
//            if(!horses.isEmpty()){
//                req.setAttribute("horse",horses.get(0));
//            }else {
//                req.setAttribute("nothing","Horse with this name doesn`t exist");
//            }
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
//        }catch (SQLException e){
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
//    }
}
