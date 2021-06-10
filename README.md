# RadekRates Application Frontend</h1>

<p align="center">
  <img width="180" height="180" src="https://zapodaj.net/images/79d68e8d99461.jpg">
</p> 

[Download the video presenting the application](https://drive.google.com/file/d/1BYT20JfRvlgHwPI5srQfXUWT55aEl93I/view) 

**This is the frontend side of the application**  
*To check out the backend side of the application click the link shown below:*  

[RadekRates App Backend](https://github.com/radoslaw-lazur/radekRatesBack)  
  
## Description

This app is an exemplary currency exchange web application. 
The application allows a new user to sign in, save IBAN numbers and finally create currency exchanges.
After signing in to the application activation E-mail is sent.
Other functions are also provided by the applications e.g. 
if the user is not activated there is no possibility to log in; 
the user forgets the password there is a way to get it back with the use of requested e-mail.
After creating the transaction, the application sends order details via E-mail.

There is no connection to another API regarding the payment activities.
Please note that transactions are not real and they are created only to show how the application works. 
Thus, the app does not store any sensitive information.
Additionally, the provided IBAN numbers are with wrong dimension. 
Below you can find the expected E-mail with reference to the requested order:  

[Sample Transaction E-mail outlook](https://zapodaj.net/images/4cd9d4dc3351a.png)  

The App is connected with APIs: [Fixer Currency API](https://fixer.io/) and [OpenWeather API](https://openweathermap.org/)  
The app can handle the scheduled Email regarding the current currency rates and the simple weather forecast data. 

All expected E-mails you can check in the link shown down below:  

[Samle E-mails](https://drive.google.com/drive/folders/1sqPugOzT309ssavN9kkeoHJs7UUYCZeu?usp=sharing)

**Additionally, please check the sample vidio presenting the frontend side bassed on Vaadin shown down below:**

[Download the video presenting the application](https://drive.google.com/file/d/1BYT20JfRvlgHwPI5srQfXUWT55aEl93I/view)

## Tech Description

This is a Java app which uses Gradle build. The project has been made based on Spring Boot Framework and Vaadin. 
This project was created using InteliJ Idea IDE.

## Start-up / Launch

To start-up the application the repository needs to be cloned. When cloned, build the project using 'gradlew build' terminal command. 
When the project is built, run the app.

The app starts on localhost:8888 - Tomcat 

I invite you to see the backend side of this app here: 

[Radek Rates App Backend](https://github.com/radoslaw-lazur/radekRatesBack)


If you have any questions please do not hesitate to ask: radoslaw.lazur@gmail.com

