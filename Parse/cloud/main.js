var Cayenne = require('cayennejs');
const cayenneClient = new Cayenne.MQTT({
    username: "fed056e0-b98e-11e6-85fb-51e12662ad94",
    password: "cc67296a124bcfecb2d3e82af8d763d851d14e45",
    clientId: "e11d2210-b9b9-11e6-ae5a-dfc2c3108b24"
});

Parse.Cloud.beforeSave("Sensor", function (request, response) {
    var magneticY = request.object.get('magneticY');
    cayenneClient.connect(function (err, mqttClient) {
        cayenneClient.rawWrite(44, magneticY);
    });
    response.success();
});