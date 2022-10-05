package com.blockwit.learnSpring.ramamike.repo;

import com.blockwit.learnSpring.ramamike.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
