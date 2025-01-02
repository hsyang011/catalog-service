package com.polarbookshop.catalogservice.web;

import com.polarbookshop.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest // JSON 직렬화에 중점을 둔 테스트 클래스임을 나타낸다.
public class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json; // JSON 직렬화 및 역직렬화를 확인하기 위한 유틸리티 클래스

    @Test
    void testSerialize() throws Exception {
        var book = Book.of("1234567890", "Title", "Author", 9.90, "Polarsophia");
        var jsonContent = json.write(book);
        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn") // JsonPath 형식을 사용해 JSON 객체를 탐색하고 자바의 JSON 변환을 확인한다.
                .isEqualTo(book.isbn());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(book.title());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(book.price());
    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
                    "isbn": "1234567890",
                    "title": "Title",
                    "author": "Author",
                    "price": 9.90,
                    "publisher": "Polarsophia"
                }
                """; // 자바 텍스트 블록 기능을 사용해 JSON 객체를 정의한다.
        assertThat(json.parse(content)) // JSON에서 자바 객체로의 변환을 확인한다.
                .usingRecursiveComparison()
                .isEqualTo(Book.of("1234567890", "Title", "Author", 9.90, "Polarsophia"));
    }

}
