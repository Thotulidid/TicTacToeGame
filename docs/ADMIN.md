#Administration manual

##Requirements
* git 
 * [setup](https://help.github.com/articles/set-up-git/)

* heroku toolbelt
 * [setup](https://toolbelt.heroku.com/)

> **Note:** heroku toolbelt is only required if you wish to deploy to heroku.

* OpenJDK 7 Or Oracle JDK 7
 * [OpenJDK 7 setup](http://openjdk.java.net/install/)
 * [Oracle JDK 7 setup](http://docs.oracle.com/javase/7/docs/webnotes/install/)

> **Note:** the application is currently only being tested with OpenJDK 7 but it should also compile and run with Oracle JDK 7.

##Getting started
1. Install all requirements.
2. Clone the repository to your machine.

##Setup

###Deploying to heroku
1. Login to heroku as seen in getting started in [https://toolbelt.heroku.com/](https://toolbelt.heroku.com/)
2. From the projects root directory run ```heroku create APPNAME``` where ```APPNAME``` is the desired name for the application.
3. run ```git push heroku master```
4. Now the application should be running at [APPNAME.herokuapp.com](http://APPNAME.herokuapp.com)

###Running locally
1. From the project root directory run ```./gradlew installApp``` to generate the executable file.
2. Now the application is ready and located in your working directory under ```build/install/TicTacToeGame/bin```.
3. To run the application
 * Windows: open the ```TicTacToeGame.bat``` file.
 * Linux: run ```java TicTacToeGame``` in a terminal.
4. Now the application should be running on the default port at [localhost:4567](http://localhost:4567/) 

> **Note:** To run the application on a different port, set the PORT environmental variable to a valid integer port.
