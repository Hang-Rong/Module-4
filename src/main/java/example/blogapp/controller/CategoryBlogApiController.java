package example.blogapp.controller;

import example.blogapp.model.Blog;
import example.blogapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories/{categoryId}/blogs")
public class CategoryBlogApiController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public Page<Blog> getBlogsByCategory(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return blogService.findByCategory(categoryId, pageable);
    }
}
