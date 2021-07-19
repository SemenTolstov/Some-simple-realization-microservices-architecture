

# HOWTO run in Windows MINGW environment

cd employeeservice
./mvnw package
cd ..

cd reportservice
./mvnw package
cd ..

java -jar employeeservice/target/employeeservice-0.0.1-SNAPSHOT.jar &

java -jar reportservice/target/reportservice-0.0.1-SNAPSHOT.jar &

curl -s -d @test_data/create_semen -H "Content-Type: application/x-www-form-urlencoded" http://localhost:8080/employees/

curl -s -d @test_data/create_denis -H "Content-Type: application/x-www-form-urlencoded" http://localhost:8080/employees/

curl -s -d @test_data/create_alex -H "Content-Type: application/x-www-form-urlencoded" http://localhost:8080/employees/


curl -s http://localhost:8090/report/
1096
