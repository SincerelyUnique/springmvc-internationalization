package com.demo.controller;

import com.demo.domain.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LoginController {

    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName,
                            String request_locale,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){

        System.out.println("request_locale="+request_locale);

        if (request_locale!=null){
            if (request_locale.equals("zh_CN")){
                Locale locale = new Locale("zh","CN");
                (new CookieLocaleResolver()).setLocale(request,response,locale);
            } else if (request_locale.equals("en_US")) {
                Locale locale = new Locale("en","US");
                (new CookieLocaleResolver()).setLocale(request,response,locale);
            }else {
                (new CookieLocaleResolver()).setLocale(request,response, LocaleContextHolder.getLocale());
            }
        }

        User user = new User();
        model.addAttribute("user",user);
        return formName;

    }

}
