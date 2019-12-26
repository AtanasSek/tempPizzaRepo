package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//@WebServlet(name = "ShowPizza", urlPatterns = "")
//@EnableWebSecurity
public class ShowPizza extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private PizzaService pizzaService;

    public ShowPizza(SpringTemplateEngine springTemplateEngine, PizzaService pizzaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = req.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        List<Pizza> pizzaList = pizzaService.listPizzas();
        webContext.setVariable("list", pizzaList);
        response.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas.html", webContext, response.getWriter());

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

