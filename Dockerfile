FROM gradle:7.4.0-jdk17

WORKDIR /app

RUN ./gradlew clean install

CMD ./build/install/HexletJavalin/bin/HexletJavalin