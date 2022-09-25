package com.techcourse.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextstep.mvc.view.JspView;
import nextstep.mvc.view.ModelAndView;
import nextstep.web.annotation.Controller;
import nextstep.web.annotation.RequestMapping;
import nextstep.web.support.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginViewController {

    private static final Logger log = LoggerFactory.getLogger(LoginViewController.class);

    private static final String LOGIN_JSP_VIEW_NAME = "/login.jsp";
    private static final String REDIRECT_INDEX_JSP_VIEW_NAME = "redirect:/index.jsp";

    @RequestMapping(value = "/login/view", method = RequestMethod.GET)
    public ModelAndView loginView(final HttpServletRequest request, final HttpServletResponse response) {
        return UserSession.getUserFrom(request.getSession())
                .map(user -> {
                    log.info("logged in {}", user.getAccount());
                    return new ModelAndView(new JspView(REDIRECT_INDEX_JSP_VIEW_NAME));
                })
                .orElse(new ModelAndView(new JspView(LOGIN_JSP_VIEW_NAME)));
    }
}
