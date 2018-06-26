# MessageStore
A RESTful API to work as a basic message store.

I have used Git Bash to write the curl commands. These can also be found under docs. 

# Add new textmessage
curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia", "text" : "Writing a textmessage" }' localhost:8080/textmessages
curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia", "text" : "Writing another textmessage" }' localhost:8080/textmessages
curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Gottfrid", "text" : "A new person writing a textmessage" }' localhost:8080/textmessages


# Read all textmessages
curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages

# Read one textmessage by Id (2)
curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages/2

# Read textmessages written by name (Cecilia)
curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages/name=Cecilia

# Change textmessage by Id (1)
curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia",
"text" : "Writing over my old textmessage" }' localhost:8080/textmessages/1

# Delete textmessage by Id (1)
curl -X DELETE localhost:8080/textmessages/1
