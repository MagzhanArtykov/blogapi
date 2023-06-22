package com.epam.demo.blogapi.data.repository;

import com.epam.demo.blogapi.data.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
