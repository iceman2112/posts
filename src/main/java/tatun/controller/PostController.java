package tatun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tatun.model.Author;
import tatun.model.Category;
import tatun.model.Post;
import tatun.service.AuthorService;
import tatun.service.CategoryService;
import tatun.service.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    private ModelAndView getModelForEdit() {
        ModelAndView modelAndView = new ModelAndView("post/edit");

        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);

        List<Author> authorList = authorService.findAll();
        modelAndView.addObject("authorList", authorList);

        modelAndView.addObject("post", new Post());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index (Model model) {
        model.addAttribute("postList", postService.findAll());
        return "post/index";
    }

    @RequestMapping(value = "post/new")
    public ModelAndView newPost() {
        ModelAndView modelAndView = getModelForEdit();
        modelAndView.addObject("post", new Post());

        return modelAndView;
    }

    @RequestMapping(value = "post/edit/{id}")
    public ModelAndView editPost(@PathVariable int id) {
        ModelAndView modelAndView = getModelForEdit();
        modelAndView.addObject("post", postService.findById(id));

        return modelAndView;
    }

    @RequestMapping(value = "post/new", method = RequestMethod.POST)
    public ModelAndView editSubmit(@ModelAttribute Post post, BindingResult bindingResult, @RequestParam("categoryId") int categoryId, @RequestParam("authorId") int authorId) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            post.setCategory(category);
        }

        Author author = authorService.findById(authorId);
        if (author != null) {
            post.setAuthor(author);
        }

        postService.save(post);

        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "post/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model) {
        Post post = postService.findById(id);
        postService.delete(post);
        return "redirect:/";
    }

    @RequestMapping(value = "post//view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable int id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post/view";
    }
}
