#IMAGEM
FROM maven:4.0.0-rc-5-amazoncorretto-21-debian-trixie as build

# criar pasta
WORKDIR /build

# copy arquivos para a pasta

COPY . .

# roda maven
# compila o arquivo java

RUN mvn clean package -DskipTests

FROM amazoncorretto:21.0.5
WORKDIR /app

COPY --from=build ./build/target/*.jar ./anaLoja.jar

ENTRYPOINT java -jar anaLoja.jar
