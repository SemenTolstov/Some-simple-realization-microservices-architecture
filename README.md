# softage_test

cd employeeservice
mvn package
cd ..

cd reportservice
mvn package
cd ..

java -jar employeeservice/target/employeeservice-0.0.1-SNAPSHOT.jar &

java -jar reportservice/target/reportservice-0.0.1-SNAPSHOT.jar &

