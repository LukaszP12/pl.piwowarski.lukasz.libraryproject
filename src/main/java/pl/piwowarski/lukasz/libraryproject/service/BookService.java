package pl.piwowarski.lukasz.libraryproject.service;

import pl.piwowarski.lukasz.libraryproject.web.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookModel> filter(String name, Long isbn);
}
