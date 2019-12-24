package mk.finki.ukim.mk.lab.web.controllers;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@Controller
public class ShowPizzaController {

    private final PizzaService pizzaService;


    public ShowPizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

//    @GetMapping(value="/")
//    public String showPizzas(Model model){
//        model.addAttribute("list", pizzaService.listPizzas());
//        return "listPizzas";
//    }

    //@GetMapping("/")
    public ModelAndView listOfPizzas(){
        ModelAndView mav = new ModelAndView("listPizzas");
        mav.addObject("list" , pizzaService.listPizzas());
        return mav;
    }


//    HttpSession session = req.getSession();
//    String username = req.getParameter("username");
//        session.setAttribute("username", username);
//        resp.sendRedirect("/");


}
