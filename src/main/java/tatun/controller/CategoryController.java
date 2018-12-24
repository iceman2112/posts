package tatun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tatun.model.Category;
import tatun.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/edit";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute Category category, Model model) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return "redirect:/category";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }
}
