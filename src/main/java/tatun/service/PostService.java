package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tatun.model.Post;
import tatun.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post findById(int id) {
        Optional<Post> optional = postRepository.findById(id);
        return optional.get();
    }

    public void delete(Post post) {
        postRepository.delete(post);

    }
}
