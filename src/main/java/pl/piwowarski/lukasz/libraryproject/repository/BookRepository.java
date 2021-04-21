package pl.piwowarski.lukasz.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.piwowarski.lukasz.libraryproject.repository.entity.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

//    @Override
//    List<BookEntity> findAll();
//
//    @Override
//    <S extends BookEntity> List<S> saveAll(Iterable<S> iterable);
//
//    @Override
//    BookEntity getById(Long aLong);

//    @Query("SELECT b FROM Books b WHERE b.name LIKE %:name%")
    List<BookEntity> findByNameLike(String name);

    BookEntity findByIsbn(Long isbn);

}
