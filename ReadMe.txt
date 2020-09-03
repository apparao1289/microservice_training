orderservice code base:

Eclipse --> File --> import --> Existing maven projects --> select the project code base.

Eclipse --> Run --> Run Configuration --> left side window select "Maven Build" --> Name ( orderServiceclean package)

Goals: clean package

Click on "Apply" button

Click on "Run" button.

For running the application open OrderApplication.java class and right click -> Run As Spring Boot App

Open your favorite browser, paste the below  link and hit enter

http://localhost:8083/order/swagger-ui.html

Note: Corresponding DB scripts available in resources folder.

H2 Database link: http://localhost:8083/order/h2


customerservice code base:


Eclipse --> File --> import --> Existing maven projects --> select the project code base.

Eclipse --> Run --> Run Configuration --> left side window select "Maven Build" --> Name ( customerServiceclean package)

Goals: clean package

Click on "Apply" button

Click on "Run" button.

For running the application open CustomerApplication.java class and right click -> Run As Spring Boot App

Open your favorite browser, paste the below  link and hit enter

http://localhost:8081/customer/swagger-ui.html

Note: Corresponding DB scripts available in resources folder.
H2 Database : http://localhost:8081/customer/h2


Inventoryservice code base:

Eclipse --> File --> import --> Existing maven projects --> select the project code base.

Eclipse --> Run --> Run Configuration --> left side window select "Maven Build" --> Name ( inventoryServiceclean package)

Goals: clean package

Click on "Apply" button

Click on "Run" button.

For running the application open InventoryApplication.java class and right click -> Run As Spring Boot App

Open your favorite browser, paste the below  link and hit enter

http://localhost:8082/inventory/swagger-ui.html

Note: Corresponding DB scripts available in resources folder.

H2 Database link: http://localhost:8082/inventory/h2
