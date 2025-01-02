package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book( // 도메인 모델은 불가변 객체인 레코드로 구현된다.
        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern( // 이 필드는 주어진 정규 표현식의 값과 일치하는 형식을 가져야 한다(표준 ISBN 형식).
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn, // 책을 고유하게 식별

        @NotBlank(message = "The book title must be defined.") // 이 필드는 널 값이 되어서는 안되고 화이트스페이스가 아닌 문자가 최소 하나 이상 있어야 한다.
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater then zero.") // 이 필드는 널 값이 되어서는 안되고 0보다 큰 값을 가져야 한다.
        Double price
) { }
