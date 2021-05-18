# softage_test

cd employeeservice
mvn package
cd ..

cd reportservice
mvn package
cd ..

java -jar employeeservice/target/employeeservice-0.0.1-SNAPSHOT.jar &

java -jar reportservice/target/reportservice-0.0.1-SNAPSHOT.jar &

curl -s -d @test_data/create_semen -H "Content-Type: application/x-www-form-urlencoded" http://localhost:8080/employees/

curl -s http://localhost:8080/employees/1
{"id":1,"name":"semen","position":"HEAD","startDate":"2015-12-20T18:00:00.000+00:00","dismissDate":"2017-12-20T17:00:00.000+00:00"}

curl -s http://localhost:8090/report/1
730
