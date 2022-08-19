 # Order Management - Siesta

------------------
Order Management is `Spring Boot` based `Micro Service` to orchestrate the life cycle of order for products

```
Primary Contact:
Ashish Raj | rajs22007@gmail.com @@
```

#### Github :- [Order Management - Siesta](https://github.com/rajs22007/order-management)
- Clone the project, open in IDE and run the spring boot application.
- To contribute, ask for access (if needed). 
- Create new feature branch and work with that branch.
- Raise merge request against master branch to get the commits reviewed. Do not merge direct to master without code review.

#### Swagger :- [Local Swagger](http://localhost:8080/swagger-ui/index.html)
- No configuration changes needed at present, just start the application and go to swagger link.


## Issues under analysis

-------------
[#All Open Issues - /order-management/issues](https://github.com/rajs22007/order-management/issues)

| Issues     | Status | Assignee     | Link                                                                                                |
|------------|--------|--------------|-----------------------------------------------------------------------------------------------------|
| Siesta #01 | `OPEN` | `ASHISH`     | [Data modeling](https://github.com/rajs22007/order-management/issues/1)                             |
| Siesta #02 | `OPEN` | `UNASSIGNED` | [Architecture brain-storm](https://github.com/rajs22007/order-management/issues/2)                  |
| Siesta #03 | `OPEN` | `ASHISH`     | [Finalize tech stacks](https://github.com/rajs22007/order-management/issues/3)                      |
| Siesta #04 | `OPEN` | `UNASSIGNED` | [Mock APIs for prototype development](https://github.com/rajs22007/order-management/issues/4)       |
| Siesta #05 | `OPEN` | `UNASSIGNED` | [Blueprint design for presentation.](https://github.com/rajs22007/order-management/issues/5)        |
| Siesta #06 | `OPEN` | `UNASSIGNED` | [Entity definitions and relationships](https://github.com/rajs22007/order-management/issues/6)      |
| Siesta #07 | `OPEN` | `UNASSIGNED` | [Product Catalogue Configurations](https://github.com/rajs22007/order-management/issues/7)          |
| Siesta #08 | `OPEN` | `UNASSIGNED` | [Authentication & Authorization analysis](https://github.com/rajs22007/order-management/issues/8)   |
| Siesta #09 | `OPEN` | `UNASSIGNED` | [DB Versioning Introduction.](https://github.com/rajs22007/order-management/issues/9)               |
| Siesta #10 | `OPEN` | `UNASSIGNED` | [MongoDB vs Postgres vs Mongo feasibility](https://github.com/rajs22007/order-management/issues/10) |


## API Specifications:

-------------
`Initial Mock API documentation under process`

## Historical events

-------------
### 18 August 2022
- Initial Project Setup with mock api for Product.
- Initial issues created.
- Swagger UI enabled to validate APIs and to get API documentation

### 19 August 2022
- Initial Error Handling introduction, default image return support when image is not found.
- API Error message body definition added.
- Added support for multiple product image upload
- Product Image download supported based on `productCode` and `imageId`
- Enable Product search based on `productCode`
- Default mapping capability added. Open for Future scope of framework based mapper
-  In memory H2 db is supported at present, open for integration `MariaDB/ Postgres/ MongoDB`