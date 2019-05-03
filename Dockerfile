FROM openjdk:8-jre-alpine
VOLUME /tmp
RUN apk add --update curl && rm -rf /var/cache/apk/*
COPY ./target/number-service-*.jar number-service.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=1", "-XX:+UseG1GC", "-Djava.security.egd=file:/dev/./urandom","-jar","/number-service.jar"]
