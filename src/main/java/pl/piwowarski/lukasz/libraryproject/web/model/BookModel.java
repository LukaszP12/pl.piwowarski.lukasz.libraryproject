package pl.piwowarski.lukasz.libraryproject.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    private long id;
    private String name;
    private long ibanNumber;



}
