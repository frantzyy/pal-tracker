# Useful commands


* Create jar to deploy
./gradlew clean build

* Deploy app
cf push pal-tracker  -p ./build/libs/pal-tracker.jar --random-route


* Set jdk for env
cf set-env pal-tracker JBP_CONFIG_OPEN_JDK_JRE '{ jre: { version: 11.+ } }'

* Run app
cf start pal-tracker

* Restage app (used to pick up env changes"
cf restage pal-tracker

cf set-env pal-tracker WELCOME_MESSAGE 'hellofrompal'


* Run specific test
./gradlew test --tests *InMemoryTimeEntryRepositoryTest



