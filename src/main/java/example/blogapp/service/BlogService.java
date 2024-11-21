package example.blogapp.service;

import example.blogapp.model.Blog;
import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    Blog save(Blog blog);
    void delete(Long id);
}
