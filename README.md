# Pivotal resources

[Lessons](https://courses.education.pivotal.io/c/349802921/index.html)

[CLI - Getting Started](https://docs.run.pivotal.io/cf-cli/getting-started.html)

[Travis CI](https://travis-ci.org/)

# Useful commands


* Create jar to deploy
`./gradlew clean build`

* Deploy app
`cf push pal-tracker  -p ./build/libs/pal-tracker.jar --random-route`


* Set jdk for env
`cf set-env pal-tracker JBP_CONFIG_OPEN_JDK_JRE '{ jre: { version: 11.+ } }'`

* Run app
`cf start pal-tracker`

* Restage app (used to pick up env changes)
`cf restage pal-tracker`

`cf set-env pal-tracker WELCOME_MESSAGE 'hellofrompal'`


* Run specific test
`./gradlew test --tests *InMemoryTimeEntryRepositoryTest`

* Create DB
`cf create-service db-service silver mydb -c '{"ram_gb":4}'`


* see VCAP properties
`cf env pal-tracker`

* CF CLI logged in user
`cf target`

* Create time entry
curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userId\": 1, \"date\": \"2019-01-01\", \"hours\": 8}"
curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userId\": 2, \"date\": \"2019-01-01\", \"hours\": 6}"
curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userId\": 3, \"date\": \"2019-01-01\", \"hours\": 4}"
curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userId\": 4, \"date\": \"2019-01-01\", \"hours\": 2}"
curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userId\": 5, \"date\": \"2019-01-01\", \"hours\": 1}"

* MySQL

`cf mysql tracker-database`  (need to install cf plugin... need MySQL client installed locally and ssh turned on)

alternatively you can ssh tunnel in


`show tables`

`describe time_entries`