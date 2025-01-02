package com.polarbookshop.catalogservice.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> { // 엔티티(Book)와 기본 키 유형(Long)을 지정하면서 CRUD 연산을 제공하는 리포지토리를 확장한다.

    Optional<Book> findByIsbn(String isbn); // 실행 시간에 스프링 데이터에 의해 구현이 제공되는 메소드

    boolean existsByIsbn(String isbn);

    @Modifying // 데이터베이스 상태를 수정할 연산임을 나타낸다.
    @Transactional // 메소드가 트랜잭션으로 실행됨을 나타낸다.
    @Query("DELETE FROM book WHERE isbn = :isbn") // 스프링 데이터가 메소드 구현에 사용할 쿼리를 선언한다.
    void deleteByIsbn(String isbn);

}
