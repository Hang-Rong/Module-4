package example.blogapp.controller;

import example.blogapp.model.Blog;
import example.blogapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogDetailApiController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogService.findById(id);
    }
}
