# Użyj obrazu openjdk jako bazowego
FROM openjdk:latest

# Utwórz katalog na aplikację
RUN mkdir /app

# Utwórz katalog na logi
RUN mkdir /logs

# Skopiuj plik Java do kontenera
COPY src/NetworkScanner.java /app/NetworkScanner.java

# Ustaw katalog roboczy
WORKDIR /app

# Skompiluj plik Java
RUN javac NetworkScanner.java

# Ustaw komendę startową do uruchomienia skanera sieciowego
CMD ["java", "NetworkScanner"]

#CMD ["sh", "-c", "while true; do java NetworkScanner; sleep 60; done"]
