SELECT * FROM classicmodels.customers;
-- select city from classicmodels.customers;
SELECT * FROM classicmodels.customers WHERE city = 'Nantes' ;
SELECT * FROM classicmodels.customers WHERE city IN ('Nantes','Las Vegas', 'NYC');
