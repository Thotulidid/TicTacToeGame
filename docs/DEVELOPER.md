#Developer's manual

###Requirements
* git 
 * [setup](https://help.github.com/articles/set-up-git/)

* OpenJDK 7 Or Oracle JDK 7
 * [OpenJDK 7 setup](http://openjdk.java.net/install/)
 * [Oracle JDK 7 setup](http://docs.oracle.com/javase/7/docs/webnotes/install/)

> **Note:** the application is currently only being tested with OpenJDK 7 but it should also compile and run with Oracle JDK 7

###Getting started
1. Install all requirements.
2. Clone the repository to your dev machine.

###Running the webapp locally
1. ```./gradlew run``` in the root folder of the project.
2. open [http://localhost:4567/](http://localhost:4567/) in your web browser of choice.

###Building and testing
Before committing your changes to github you should run tests locally by running the following command from the root folder:
* Linux

> sbin/local_tests

* Windows powershell

> sh .\sbin\local_tests

If all tests pass you are all set to commit your changes. After your code has been pushed to github, [travis-ci](https://travis-ci.org/Thotulidid/TicTacToeGame) will take over and build and unit tests the code. If the unit tests pass the application is deployed to the [staging server](https://tttwebstage.herokuapp.com) which the functional tests are run against. Finally if the functional tests pass the application is deployed to the [production server](https://tttweb.herokuapp.com).

If you wish to receive notifications via e-mail from travis you need edit the ```.travis.yml``` file and add your e-mail address under ```notifications > email > recipients```.

> **Note:** if your commit contains only trivial changes(e.g. changing markdown files) that dont affect the tests you can put ```[skip ci]``` anywhere in the commit message to make travis ignore the commit.

##Optional
###Generationg documentation
To generate javadoc and code coverage reports run:
* Linux

> sbin/docs

* Windows powershell

> sh .\sbin\docs

###Eclipse setup
1. Run ./gradlew eclipse.
2. In eclipse open File->Import.
3. Expand "General" and choose Existing projects into Workspace.
4. Keep "Select root directory" selected and browse for the project.
5. Press "Finish".
