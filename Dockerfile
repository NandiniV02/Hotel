FROM adoptopenjdk:16-jre
COPY HotelBookingApp-*.jar /app.jar
CMD java -jar /app.jar