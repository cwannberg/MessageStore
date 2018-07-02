# MessageStore
A RESTful API to work as a basic message store.

I used Spring initializr to get started. 
I've used Git Bash to write the curl commands. These can also be found under docs. 

# Getting started 
Clone the project and open it in your prefered IDE. I've used IntelliJ. Choose "Check out from Version Control" in start window,
choose Git in the drop down-menu and paste the projects URL (https://github.com/cwannberg/MessageStore.git). 

You find MessageStoreApplication.java under src/main/java/com.example.demo. Run it.
Now open your commandprompt, or use Git Bash (https://gitforwindows.org/)

# Curl commands
Curl commands can also be found under docs. curl-commands.txt

Add new textmessage

```curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia", "text" : "Writing a textmessage" }' localhost:8080/textmessages```

Read all textmessages

```curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages```

Read one textmessage by Id

```curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages/1```

Read textmessages written by name

```curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages/name=Cecilia```

Change textmessage by Id 

```curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia", "text" : "Writing over my old textmessage" }' localhost:8080/textmessages/1```

Delete textmessage by Id

```curl -X DELETE localhost:8080/textmessages/1```

# Tests
No tests have been added yet. 

# Acknowledgments
The class MakeSpringPrettyPrintJSON.java is COPIED FROM: https://stackoverflow.com/questions/36119852/spring-boot-actuator-pretty-print-json
I've used it to make the application return pretty-printed JSON (easier to debug)
