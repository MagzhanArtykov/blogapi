# Sample Blog API implementation

**TODO**
1. Tags duplicates on update, I can fix it if it is critical
2. I did not used DTO aproach(and its annotations) to keep it only with starter dependencies

**Testing**

Provided Postman sample to simplify testing in 
blogapi/src/main/resources/BlogAPI.postman_collection.json


**Task description**

Spring Boot app that provides RESTful API for the blog:
- Get a collection of posts (paginated, has optional filtering by tags)
- Create a new post
- Update (tags only)
- Delete a post by ID

Post has:
- A title (required)
- Content (required)
- Tags (optional)
Posts are stored in the in-memory database. Integration with the database has to be implemented with Spring Data JPA.


