package com.hackathon.nineteen.repository;

import com.hackathon.nineteen.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Павло on 03.10.2017.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select category.categoryName from Category as category")
    List<String> getCategoryByCategoryName();
}
