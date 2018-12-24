package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tatun.model.Author;
import tatun.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void save(Author category) {
        authorRepository.save(category);
    }

    public Author findById(int id) {
        Optional<Author> optional = authorRepository.findById(id);
        return optional.get();
    }

    public void delete(Author category) {
        authorRepository.delete(category);

    }
}
