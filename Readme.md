# Verification steps
## Flight center
### Application start
##### Terminal 
1. Go to directory `flight-center` 
2. Run `mvn spring-boot:run`

##### IDE
1. Open class `FlightCenterApp`.
2. Run the class.

### Verification
1. Open in your browser `http://localhost:8100/flight/1/ABC`
2. After a few seconds you should see message `Flight confirmed with no issues.` 

## Online shop
### Application start
##### Terminal 
1. Go to directory `online-shop` 
2. Run `mvn spring-boot:run`

##### IDE
1. Open class `OnlineShopApp`.
2. Run the class.

### Verification
1. Open in your browser `http://localhost:8200/order/1`
2. After a few seconds you should see message `You are the happy owner of new products!` 