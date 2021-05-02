package br.com.zupacademy.gabriela.casadocodigo.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBooksResponse {

    public ListBooksResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static List<ListBooksResponse> createBooksList(Iterable<Book> books) {
        List<ListBooksResponse> responseList = new ArrayList<>();
        books.forEach(book -> responseList.add(new ListBooksResponse(book)));

        return responseList;
    }
}


