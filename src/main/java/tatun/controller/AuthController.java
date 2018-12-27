package tatun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tatun.model.User;
import tatun.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("auth/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPost(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute(name = "login") String login,
            @ModelAttribute(name = "password") String password
    ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        if (login == null || password == null) return modelAndView;
        if (login.isEmpty() || password.isEmpty()) return modelAndView;

        User user = userService.initUser(login, password);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return modelAndView;
        }

        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());

        return modelAndView;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        HttpSession session = request.getSession();
        session.removeAttribute("userId");

        return modelAndView;
    }
}
