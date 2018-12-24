package tatun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tatun.model.Author;
import tatun.service.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("authorList", authorService.findAll());
        return "author/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "author/edit";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute Author author, Model model) {
        authorService.save(author);
        return "redirect:/author";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author/edit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "redirect:/author";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable int id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author/view";
    }
}
