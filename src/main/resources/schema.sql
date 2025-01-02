DROP TABLE IF EXISTS book; -- 테이블이 이미 존재하면 삭제한다.
CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY NOT NULL, -- 테이블의 기본 키, 데이터베이스는 연속되는 숫자를 생성한다. (bigserial 유형)
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) UNIQUE NOT NULL, -- UNIQUE 제약 조건은 ISBN은 오직 하나의 책에만 할당되도록 보장한다.
    price FLOAT8 NOT NULL, -- 제약 조건은 해당 컬럼이 값을 반드시 가지도록 보장한다.
    title VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL, -- 엔티티가 생성된 때 (timestamp 유형으로 저장)
    last_modified_date TIMESTAMP NOT NULL, -- 엔티티가 마지막으로 수정된 때 (timestamp 유형으로 저장)
    version INTEGER NOT NULL -- 정수로 저장되는 엔티티 버전 번호
);
