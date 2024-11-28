package example.blogapp.controller;

import example.blogapp.fomatter.CategoryFormatter;
import example.blogapp.model.Blog;
import example.blogapp.model.Category;
import example.blogapp.service.BlogService;
import example.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryFormatter categoryFormatter;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(categoryFormatter);
    }

    @GetMapping
    public String listBlogs(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            throw new IllegalStateException("No categories available. Please create a category first.");
        }
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categories);
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog) {
        if (blog.getCategory() == null || blog.getCategory().getId() == null) {
            System.out.println("Erro occured");
            return "redirect:/blogs";
        }
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        model.addAttribute("blogs", blogService.search(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "list";
    }

    @GetMapping("/category/{id}")
    public String blogsByCategory(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        model.addAttribute("blogs", blogService.findByCategory(id, pageable));
        model.addAttribute("category", categoryService.findById(id));
        return "list";
    }

    @GetMapping("/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "edit";
    }

    @PostMapping("/{id}/update")
    public String updateBlog(@PathVariable Long id, @ModelAttribute Blog blog) {
        blog.setId(id);
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/blogs";
    }
}
