# game-of-three
* Prerequisites:
    * java 11 installed (to check `java -version`)
    * maven 3 installed (to check `mvn -version`)
        
1. Update file `src/main/resources/application.properties` file according to your settings:
    * Which player wants to start the game (player1 or player2). Default setting takes Player1 to start the game
    * Logging level. By default, it is Info.
2. Build Spring Boot Project with Maven: `mvn clean install`
3. Run Spring Boot app using Maven: `mvn spring-boot:run` or `java -jar target/GameOfThree-0.0.1-SNAPSHOT.jar`
4. The winner will be printed in console
    #####NOTE: the application runs on default port 8080, so make sure no other application is running on 8080. 
