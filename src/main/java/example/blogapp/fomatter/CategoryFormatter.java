package example.blogapp.fomatter;

import example.blogapp.model.Category;
import example.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Long categoryId = Long.parseLong(text);
        return categoryService.findById(categoryId);
    }

    @Override
    public String print(Category object, Locale locale) {
        return object != null ? object.getId().toString() : "";
    }
}
