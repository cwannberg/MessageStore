# MessageStore
A RESTful API to work as a basic message store.

I have used Git Bash to write the curl commands. These can also be found under docs. 

# Add new textmessage
curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia", "text" : "Writing a textmessage" }' localhost:8080/textmessages

# Read all textmessages
curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages

# Read one textmessage by Id
curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages/1

# Read textmessages written by name
curl -i -H "Content-Type: application/json" -X GET localhost:8080/textmessages/name=Cecilia

# Change textmessage by Id 
curl -i -H "Content-Type: application/json" -X POST -d '{ "name": "Cecilia",
"text" : "Writing over my old textmessage" }' localhost:8080/textmessages/1

# Delete textmessage by Id
curl -X DELETE localhost:8080/textmessages/1
