package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SelectPizzaController {

    private final OrderService orderService;
    private String pizzaType;
    private Order order;

    public SelectPizzaController(OrderService orderService) {

        this.orderService = orderService;

    }

    @PostMapping("/")
    public void postOrder(@RequestParam String pizzaType) {
        this.order.setPizzaType(pizzaType);
    }

    @GetMapping(value="/selectPizza.do")
    public ModelAndView pizzaSize(){
        ModelAndView mav = new ModelAndView("selectPizzaSize");
        if(this.order == null)
            mav.addObject("pizzaType" , "object order has returned null");
        else
            mav.addObject("pizzaType" , this.order.getPizzaType());
        return mav;
    }
}
