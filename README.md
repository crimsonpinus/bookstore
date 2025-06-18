# 📚 BookStore

BookStore는 **Spring Boot**를 활용하여 도서 관리와 판매 기능을 제공하는 REST API 기반 애플리케이션입니다.  
PostgreSQL과 JPA로 데이터베이스를 구성하며, Swagger를 통한 API 문서화도 포함되어 있습니다.

---

## 🚀 주요 기능

- **도서 CRUD**: 도서 등록, 조회, 수정, 삭제  
- **재고 관리**: 도서 재고 추가 및 판매 처리  
- **카테고리 및 키워드 검색**: 이름, 저자, 카테고리를 통한 필터링 및 검색  
- **예외 처리**: 권한, 재고 부족 등 상황에 따른 예외 응답  
- **API 문서화**: Swagger UI 지원

---

## 🧩 기술 스택

- **Java + Spring Boot**: 핵심 프레임워크  
- **Spring Data JPA + Hibernate**: 데이터 레이어  
- **PostgreSGL**: 영구 데이터 저장  
- **Swagger (Springdoc/OpenAPI)**: API 문서 자동화    
- **Lombok**: 반복 코드 감소  

---

## ⚙️ 세부 정보
- cors 적용
- 필터 적용하여 인풋 아웃풋 로그 남김
- api, db 분리한 멀티 모듈 프로젝트
- 모든 에러처리는 Api형태로 받게 수정 (null 포함)
- swagger를 통한 문서화(http://localhost:7077/swagger-ui/index.html#)

