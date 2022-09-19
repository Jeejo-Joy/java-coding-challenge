# Foreign exchange rate service as SpringBoot-based microservice

## Intro
The task is to create a foreign exchange rate service as SpringBoot-based microservice. 

The exchange rates can be received from [2]. This is a public service provided by the German central bank.

## The APIS

- As a client, I want to get a list of all available currencies

	Example:
	
	http://localhost:8080/api/currencies

	![All_currencies](/images/All_currencies.png)


- As a client, I want to get all EUR-FX exchange rates at all available dates as a collection

	Example:
		
	http://localhost:8080/api/exchange-rates
	
	![All_exchange_rates](/images/All_exchange_rates.png)
	
	
- As a client, I want to get the EUR-FX exchange rate at particular day

	Example:
	
	with specific date
	http://localhost:8080/api/convert/exchange-rates/{date}
	
	http://localhost:8080/api/exchange-rates/2022-09-12
	
	![Exchangerate_by_date](/images/Exchangerate_by_date.png)
	

- As a client, I want to get a foreign exchange amount for a given currency converted to EUR on a particular day

	Example:
	
	By default today's date
	http://localhost:8080/api/convert/{currency}/{value}
	
	with specific date
	http://localhost:8080/api/convert/{currency}/{value}/{date}
	
	http://localhost:8080/api/convert/USD/2022/2022-09-12

	![Currency_rate_conversion](/images/Currency_rate_conversion.png)


 
## Setup
#### Requirements
- Java 11 (will run with OpenSDK 15 as well)
- Maven 3.x

#### Project
after cloning run below commands:

````shell script
run:
$ mvn spring-boot:run

debug:
$ mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"

````

After running, the project, switch to your browser and hit http://localhost:8080/api/currencies. You should see some 
demo output. 


[1] https://start.spring.io/

[2] [Bundesbank Daily Exchange Rates](https://www.bundesbank.de/dynamic/action/en/statistics/time-series-databases/time-series-databases/759784/759784?statisticType=BBK_ITS&listId=www_sdks_b01012_3&treeAnchor=WECHSELKURSE)
