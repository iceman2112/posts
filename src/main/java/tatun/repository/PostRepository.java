package tatun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tatun.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
