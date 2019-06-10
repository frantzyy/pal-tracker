commmands:

cf set-env pal-tracker JBP_CONFIG_OPEN_JDK_JRE '{ jre: { version: 11.+ } }'

cf push pal-tracker  -p ./build/libs/pal-tracker.jar --random-route



