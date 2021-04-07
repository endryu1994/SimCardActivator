# SIM-card activator
This example shows:
* How to set up Camunda in Spring Boot application.
* How to use AMQP and SOAP in your processes the Spring way.

## Business process

<div style="text-align:center"><img src="/docs/overview.png"/></div>

* It is triggered via SOAP.
* Calls a SOAP service.
* Sends an AMQP message as a response.

## Preconditions
### RabbitMQ
1. Install RabbitMQ.
2. Upload this [configuration](https://github.com/endryu1994/SimCardActivator/blob/Readme/src/test/resources/rabbitmq/rabbitmq_config.json) using "Import definitions" in RabbitMQ UI.

### SoapUI
1. Install SoapUI.
2. Import [projects](https://github.com/endryu1994/SimCardActivator/tree/Readme/src/test/resources/soapui) to SoapUI.
3. Open WebService project and start MockService.
