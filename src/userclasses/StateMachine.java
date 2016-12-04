/**
 * Your application code goes here<br>
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose
 * of building native mobile applications using Java.
 */


package userclasses;

import ca.weblite.codename1.json.JSONException;
import ca.weblite.codename1.json.JSONObject;
import com.codename1.bluetoothle.Bluetooth;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.googlemaps.MapContainer;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.maps.providers.GoogleMapsProvider;
import com.codename1.sensors.SensorListener;
import com.codename1.sensors.SensorsManager;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.parse4cn1.*;
import generated.StateMachineBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
        Parse.initialize("http://parseapi.back4app.com", "GcRAxCp4DG6eviyuox53OpCE2g4luOVqYM3MYepe", "kVlf0nHTVzt8GjhAyuEtXkhAk345bXTHnr1CXfwN");
    }

    static float gyroscopeX, gyroscopeY, gyroscopeZ, accelerometerX, accelerometerY, accelerometerZ, magneticX, magneticY, magneticZ;

    @Override
    protected void beforeSensors(Form f) {
        SensorsManager gyroscope = SensorsManager.getSenorsManager(SensorsManager.TYPE_GYROSCOPE);
        SensorsManager accelerometer = SensorsManager.getSenorsManager(SensorsManager.TYPE_ACCELEROMETER);
        SensorsManager magnetic = SensorsManager.getSenorsManager(SensorsManager.TYPE_MAGNETIC);

        gyroscope.registerListener(new SensorListener() {
            @Override
            public void onSensorChanged(long timeStamp, float x, float y, float z) {
                findGyroscope(f).setText("t: " + timeStamp + ", x: " + x + ",y: " + y + ",z: " + z);
                gyroscopeX = x;
                gyroscopeY = y;
                gyroscopeZ = z;
            }
        });
        accelerometer.registerListener(new SensorListener() {
            @Override
            public void onSensorChanged(long timeStamp, float x, float y, float z) {
                findAccelerometer(f).setText("t: " + timeStamp + ", x: " + x + ",y: " + y + ",z: " + z);
                accelerometerX = x;
                accelerometerY = y;
                accelerometerZ = z;
            }
        });
        magnetic.registerListener(new SensorListener() {
            @Override
            public void onSensorChanged(long timeStamp, float x, float y, float z) {
                findMagnetic(f).setText("t: " + timeStamp + ", x: " + x + ",y: " + y + ",z: " + z);
                magneticX = x;
                magneticY = y;
                magneticZ = z;
            }
        });
    }

    Bluetooth bt;
    Map devices = new HashMap();
    Container devicesCnt;

    @Override
    protected void beforeBluetooth(Form f) {
        bt = new Bluetooth();
        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(new Button(new Command("enable bluetooth") {

            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    if (!bt.isEnabled()) {
                        bt.enable();
                    }
                    if (!bt.hasPermission()) {
                        bt.requestPermission();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }));
        f.add(new Button(new Command("initialize") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    bt.initialize(true, false, "bluetoothleplugin");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }));
        f.add(new Button(new Command("start scan") {

            @Override
            public void actionPerformed(ActionEvent evt) {

                try {

                    bt.startScan(new ActionListener() {

                                     @Override
                                     public void actionPerformed(ActionEvent evt) {
                                         try {
                                             JSONObject res = (JSONObject) evt.getSource();
                                             System.out.println("response " + res);

                                             if (res.getString("status").equals("scanResult")) {
                                                 //if this is a new device add it
                                                 if (!devices.containsKey(res.getString("address"))) {
                                                     devices.put(res.getString("address"), res);
                                                     updateUI();
                                                 }
                                             }
                                         } catch (JSONException ex) {
                                             ex.printStackTrace();
                                         }
                                     }
                                 }, null, true, Bluetooth.SCAN_MODE_LOW_POWER, Bluetooth.MATCH_MODE_STICKY,
                            Bluetooth.MATCH_NUM_MAX_ADVERTISEMENT, Bluetooth.CALLBACK_TYPE_ALL_MATCHES);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }));

        f.add(new Button(new Command("stop scan") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    bt.stopScan();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }));

        devicesCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(devicesCnt);
        f.show();

    }

    void updateUI() throws JSONException {
        devicesCnt.removeAll();
        Set keys = devices.keySet();
        for (Iterator iterator = keys.iterator(); iterator.hasNext(); ) {
            String address = (String) iterator.next();
            JSONObject obj = (JSONObject) devices.get(address);
            MultiButton mb = new MultiButton(obj.getString("name"));
            mb.setTextLine2(address);
            devicesCnt.add(mb);
        }
        devicesCnt.revalidate();
    }

    static Location lastKnownLocation;

    @Override
    protected void beforeGPS(Form f) {
        MapContainer mapContainer = new MapContainer(new GoogleMapsProvider("AIzaSyCOz5no0XXXCb3KTcXyskeZzysefXOvCNc"));
        lastKnownLocation = LocationManager.getLocationManager().getLastKnownLocation();
        Style s = new Style();
        s.setBgTransparency(0);
        s.setFgColor(0);
        mapContainer.addMarker(FontImage.createMaterial(FontImage.MATERIAL_MY_LOCATION, s).toEncodedImage(), new Coord(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), "", "", evt -> {
            ToastBar.showErrorMessage(lastKnownLocation.toString());
        });
        mapContainer.addTapListener(evt -> {
            Coord coord = mapContainer.getCoordAtPosition(evt.getX(), evt.getY());
            mapContainer.addMarker(FontImage.createMaterial(FontImage.MATERIAL_LOCATION_ON, s).toEncodedImage(), coord, "", "", null);
        });

        f.add(BorderLayout.CENTER, mapContainer);

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.addActionListener(e -> {
            ParseObject object = ParseObject.create("Geo");
            object.put("current", new ParseGeoPoint(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
            if (ParseUser.getCurrent() != null)
                object.put("user", ParseUser.getCurrent());
            try {
                object.save();
                ToastBar.showErrorMessage("Geo Sent");
            } catch (ParseException ex) {
                ex.printStackTrace();
                ToastBar.showErrorMessage(ex.getMessage());
            }
        });
        fab.bindFabToContainer(f.getContentPane());
    }

    @Override
    protected void beforeSerial(Form f) {

    }

    @Override
    protected void onSensors_SendToParseAction(Component c, ActionEvent event) {
        ParseObject object = ParseObject.create("Sensor");
        object.put("gyroscopeX", gyroscopeX);
        object.put("gyroscopeY", gyroscopeY);
        object.put("gyroscopeX", gyroscopeZ);

        object.put("magneticX", magneticX);
        object.put("magneticY", magneticY);
        object.put("magneticX", magneticZ);

        object.put("accelerometerX", accelerometerX);
        object.put("accelerometerY", accelerometerY);
        object.put("accelerometerX", accelerometerZ);

        if (ParseUser.getCurrent() != null)
            object.put("user", ParseUser.getCurrent());

        try {
            object.save();
            ToastBar.showErrorMessage("Sensor Sent");
        } catch (ParseException e) {
            e.printStackTrace();
            ToastBar.showErrorMessage(e.getMessage());
        }
    }

    @Override
    protected void onUser_LoginAction(Component c, ActionEvent event) {
        try {
            ParseUser user = ParseUser.create(findUesrname().getText(), findPassword().getText());
            user.login();
            showForm("Main", null);
        } catch (ParseException e) {
            e.printStackTrace();
            ToastBar.showErrorMessage(e.getMessage());
        }
    }

    @Override
    protected void onMain_InOutAction(Component c, ActionEvent event) {
        if (ParseUser.getCurrent() == null) {
            showForm("User", null);
        } else {
            try {
                ParseUser.getCurrent().logout();
                ToastBar.showErrorMessage("LoggedOut");
            } catch (ParseException e) {
                e.printStackTrace();
                ToastBar.showErrorMessage(e.getMessage());
            }
        }
    }

    @Override
    protected void onUser_RegisterAction(Component c, ActionEvent event) {
        try {
            ParseUser user = ParseUser.create(findUesrname().getText(), findPassword().getText());
            user.signUp();
            showForm("Main", null);
        } catch (ParseException e) {
            e.printStackTrace();
            ToastBar.showErrorMessage(e.getMessage());
        }
    }
}
