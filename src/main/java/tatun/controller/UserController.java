package tatun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tatun.model.User;
import tatun.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "user/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAuthor(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute User user, Model model) {
        userService.save(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        userService.delete(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/view";
    }
}
