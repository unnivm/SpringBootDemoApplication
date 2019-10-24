
## Description

This application is loading the places catalog based on the admin role.  There are two roles. Admin and user roles. User role can access location details, not able to load places catalog details. 

User role is achieved by Spring Security by extending WebSecurityConfigurerAdapter class. The roles are "ROLE_ADMIN"  and "ROLE_USER". You can go through CustomWebSecurityConfigurerAdapter class more details.

Admin user can download and insert the data into the in-memory database. This is a POST request and can be made only by user with admin right.Please find the image below. I used POSTMAN tool to make a POST request.

![post](https://user-images.githubusercontent.com/968987/67464831-a7dc3d00-f661-11e9-92ee-c7cd8015b6e2.png)
