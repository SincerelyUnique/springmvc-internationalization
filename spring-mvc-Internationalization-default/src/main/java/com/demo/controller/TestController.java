package com.demo.controller;

import com.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName, Model model){
        User user = new User();
        model.addAttribute("user",user);
        return formName;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute @Validated User user,Model model,HttpServletRequest request){
        if (user.getLoginname()!=null && user.getLoginname().equals("jalen")
                && user.getPassword()!=null && user.getPassword().equals("123456")){
            //从后台代码获取国际化信息username
            RequestContext requestContext = new RequestContext(request);
            String username = requestContext.getMessage("username");

            //将获取的username信息设置到User对象，并设置到Model中
            user.setUsername(username);
            model.addAttribute("user",user);
            return "success";
        }
        return "error";
    }
}
