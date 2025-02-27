package nextstep.mvc.controller.tobe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import nextstep.mvc.view.ModelAndView;

public class HandlerExecution {

    private final Object controller;
    private final Method handler;

    public HandlerExecution(final Object controller, final Method handler) {
        this.controller = controller;
        this.handler = handler;
    }

    public ModelAndView handle(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return (ModelAndView) handler.invoke(controller, request, response);
    }
}
