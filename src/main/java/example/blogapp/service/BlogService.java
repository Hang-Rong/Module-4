package example.blogapp.service;

import example.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    Blog save(Blog blog);
    void delete(Long id);
    Page<Blog> search(String keyword, Pageable pageable);
    Page<Blog> findByCategory(Long id, Pageable pageable);
}
