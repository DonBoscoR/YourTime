db.createUser( { user: "root",pwd: "root",roles: [ { role: "readWrite", db: "yourtimedb"}],} );
db.createCollection("user");
db.createCollection("serviceprovider");
db.createCollection("masterdata");
db.createCollection("feedback");
db.createCollection("cancelation");
db.createCollection("booking");
db.user.insertOne({"username":"don","password":"don","firstname":"Don Bosco","lastname":"Rayappan","email":"donboscorayappan@gmail.com","addressline1":"","addressline2":"","country":"India","state":"TN","zip":"606755","phonenumbber":"783983934753","isserviceprovider":"N","role":"Admin","serviceproviderid":""});