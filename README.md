# Ecommerce-Rest-API---Spring-Boot

## Statment
  This is a Ecommerce REST API developed Using Spring Boot.This API can be Used to consume services in Your Angular or


## prerequisites
1. Download or clone the project, import ecommerce database in your local system, which is present in src-main-resources folder.
2. Check for maven installed in your ide, if no, install.
3. Change app configuration settings in resources file, with your local dburl, username,password.
4. Update Maven Dependencies,maven clean,install check whether project build is success or not.
5. Run Project as Spring Boot Application and type this url "http://localhost:8080/swagger-ui.html#/" in your browser or make use of POSTMAN to test API.

## Description.
- There are total 5 Entites Involved, all are dependent. They are as follows:
1. Category(categoryId,categoryName)
2. Subcategory(subcategoryId,subcategoryName,categoryId)
3. Product(subcategoryId,ProductId,ProductName,Quantity_Avaliable,unitPrice)
4. Cart(ProductId,purchasedQuantity)
5. Checkout(ProductId,QuantityPurchased,UnitPrice,TotalPrice)
- User Management Details <br/>
User(userId,userName,mailId,password(Encrpyted),role).Based on the role authentication, we restrict some access to endpoint urls.

**So the flow is like "category" --> "list of subcategories" ---> (single category) "list of products"**.

## Thank You. Happy Coding.


