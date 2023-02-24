FROM adoptopenjdk:16-jre
COPY target/HotelBookingApp*.jar /app.jar
CMD java -jar /app.jar