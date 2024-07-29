FROM gradle:7.4.0-jdk17

WORKDIR /bin

COPY /bin .

RUN gradle installDist
CMD ./build/install/HexletJavalin/bin/HexletJavalin