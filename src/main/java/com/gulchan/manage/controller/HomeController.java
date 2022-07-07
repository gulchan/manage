package com.gulchan.manage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Value("${cusotmer.orderUrl}")
    private String orderUrl;

    final static class InnerClass {

    }

    @RequestMapping(value="/home",method= RequestMethod.GET)
    public String home(Model model){
        return "home";
    }

    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello","hello Thymleaf!");
        model.addAttribute("orderUrl","orderUrl:" + this.orderUrl);
        return "hello";
    }

    /**
     * @author gulchan
     * @see
     * @link
     * @since
     * @throws
     * @exception
     * @param model
     * @return
     */
    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String index(Model model) throws InterruptedException {
        final String a = "aa";
        Thread.sleep(100);
        return "layTabPlus/index";
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(Model model) throws InterruptedException {
        return "login";
    }

    @RequestMapping(value="/success",method= RequestMethod.GET)
    public String success(Model model) throws InterruptedException {
        return "success";
    }
}

