package example.blogapp.service;

import example.blogapp.model.Blog;
import example.blogapp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> search(String keyword, Pageable pageable) {
        return blogRepository.findByTitleContaining(keyword, pageable);
    }

    @Override
    public Page<Blog> findByCategory(Long categoryId, Pageable pageable) {
        return blogRepository.findByCategory_Id(categoryId, pageable);
    }
}
