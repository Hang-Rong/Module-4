package example.blogapp.repository;

import example.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> findByCategory_Id(Long categoryId, Pageable pageable);
    Page<Blog> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
