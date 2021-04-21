package pl.piwowarski.lukasz.libraryproject.service;

import org.springframework.stereotype.Service;
import pl.piwowarski.lukasz.libraryproject.repository.BookRepository;
import pl.piwowarski.lukasz.libraryproject.repository.entity.BookEntity;
import pl.piwowarski.lukasz.libraryproject.service.mapper.BookMapper;
import pl.piwowarski.lukasz.libraryproject.web.model.BookModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultBookService implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public DefaultBookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookModel> filter(String name, Long isbn) {
        if (name != null) {
            List<BookEntity> bookEntities = bookRepository.findByNameLike(name);
            return bookMapper.fromList(bookEntities);
        }

        if (isbn != null) {
            BookEntity bookEntity = bookRepository.findByIsbn(isbn);
            BookModel bookModel = bookMapper.from(bookEntity);
            return Collections.singletonList(bookModel);
        }

        return null;
    }
}
