package com.techcourse.controller;

import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextstep.mvc.view.JspView;
import nextstep.mvc.view.ModelAndView;
import nextstep.web.annotation.Controller;
import nextstep.web.annotation.RequestMapping;
import nextstep.web.support.RequestMethod;

@Controller
public class RegisterController {

    private static final String REDIRECT_INDEX_JSP_VIEW_NAME = "redirect:/index.jsp";
    private static final String REGISTER_JSP_VIEW_NAME = "/register.jsp";

    @RequestMapping(value = "/register/view", method = RequestMethod.GET)
    public ModelAndView getRegisterView(final HttpServletRequest request, final HttpServletResponse response) {
        return new ModelAndView(new JspView(REGISTER_JSP_VIEW_NAME));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(final HttpServletRequest request, final HttpServletResponse response) {
        final var user = new User(2,
                request.getParameter("account"),
                request.getParameter("password"),
                request.getParameter("email"));
        InMemoryUserRepository.save(user);

        return new ModelAndView(new JspView(REDIRECT_INDEX_JSP_VIEW_NAME));
    }
}
