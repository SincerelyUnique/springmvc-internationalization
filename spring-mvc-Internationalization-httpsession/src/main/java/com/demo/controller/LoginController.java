package com.demo.controller;

import com.demo.domain.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class LoginController {

    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName, String request_locale, Model model, HttpServletRequest request){
        System.out.println("request_locale="+request_locale);

        //配置国际化
        if (request_locale!=null){
            if (request_locale.equals("zh_CN")){
                //设置中文环境
                Locale locale = new Locale("zh","CN");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else if (request_locale.equals("en_US")){
                //设置英文环境
                Locale locale = new Locale("en","US");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else {
                //使用之前的语言环境
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
            }
        }

        User user = new User();
        model.addAttribute("user", user);
        return formName;
    }

}
