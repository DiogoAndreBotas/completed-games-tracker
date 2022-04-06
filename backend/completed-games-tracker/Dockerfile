FROM openjdk:17 as BUILD_IMAGE
LABEL maintainer='DiogoAndreBotas'

WORKDIR /workspace/app
COPY . /workspace/app
RUN ./gradlew build --no-daemon

FROM openjdk:17 as PRODUCTION_IMAGE
WORKDIR /app
VOLUME /tmp
COPY --from=BUILD_IMAGE /workspace/app/build/libs/completed-games-tracker.jar /app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/completed-games-tracker.jar"]