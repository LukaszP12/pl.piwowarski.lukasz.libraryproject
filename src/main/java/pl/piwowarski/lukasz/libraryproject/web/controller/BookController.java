package pl.piwowarski.lukasz.libraryproject.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.lukasz.libraryproject.service.DefaultBookService;
import pl.piwowarski.lukasz.libraryproject.web.model.BookModel;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    private DefaultBookService defaultBookService;

    public BookController(DefaultBookService defaultBookService) {
        this.defaultBookService = defaultBookService;
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<BookModel>> filter(@RequestParam(name = "name") String name,
                                                  @RequestParam(name = "isbn") Long isbn) {
        List<BookModel> bookModels = defaultBookService.filter(name, isbn);
        return ResponseEntity.ok().body(bookModels);
    }

    @GetMapping(value = "/filter/name")
    public ResponseEntity<List<BookModel>> filterName(@RequestParam(name = "name") String name) {
        List<BookModel> bookModels = defaultBookService.filter(name, null);
        return ResponseEntity.ok().body(bookModels);
    }

    @GetMapping(value = "/filter/isbn")
    public ResponseEntity<List<BookModel>> filterIsbn(@RequestParam(name = "isbn") Long isbn) {
        List<BookModel> bookModels = defaultBookService.filter(null, isbn);
        return ResponseEntity.ok().body(bookModels);
    }
}
