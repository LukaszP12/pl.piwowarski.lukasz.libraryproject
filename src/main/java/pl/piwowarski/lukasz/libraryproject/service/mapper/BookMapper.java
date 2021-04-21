package pl.piwowarski.lukasz.libraryproject.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.piwowarski.lukasz.libraryproject.repository.entity.BookEntity;
import pl.piwowarski.lukasz.libraryproject.web.model.BookModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    private static final Logger LOGGER = Logger.getLogger(BookMapper.class.getName());

    public BookEntity from(BookModel bookModel) {
        LOGGER.info("from(" + bookModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        BookEntity bookEntity = modelMapper.map(bookModel, BookEntity.class);

        LOGGER.info("from(...)=" + bookEntity);
        return bookEntity;
    }

    public List<BookModel> fromList(List<BookEntity> bookEntities) {
        return bookEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public BookModel from(BookEntity bookEntity) {
        LOGGER.info("from(" + bookEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        BookModel bookModel = modelMapper.map(bookEntity, BookModel.class);

        LOGGER.info("from(...)=" + bookModel);
        return bookModel;
    }


}
