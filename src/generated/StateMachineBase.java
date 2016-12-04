/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Main";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Button findButton1(Component root) {
        return (com.codename1.ui.Button)findByName("Button1", root);
    }

    public com.codename1.ui.Button findButton1() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findUesrname(Component root) {
        return (com.codename1.ui.TextField)findByName("Uesrname", root);
    }

    public com.codename1.ui.TextField findUesrname() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Uesrname", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Uesrname", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel2(Component root) {
        return (com.codename1.ui.Label)findByName("Label2", root);
    }

    public com.codename1.ui.Label findLabel2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findLogin(Component root) {
        return (com.codename1.ui.Button)findByName("Login", root);
    }

    public com.codename1.ui.Button findLogin() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Login", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Login", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findSendToParse(Component root) {
        return (com.codename1.ui.Button)findByName("sendToParse", root);
    }

    public com.codename1.ui.Button findSendToParse() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("sendToParse", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("sendToParse", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findMagnetic(Component root) {
        return (com.codename1.ui.Label)findByName("Magnetic", root);
    }

    public com.codename1.ui.Label findMagnetic() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Magnetic", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Magnetic", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel4(Component root) {
        return (com.codename1.ui.Label)findByName("Label4", root);
    }

    public com.codename1.ui.Label findLabel4() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findRegister(Component root) {
        return (com.codename1.ui.Button)findByName("Register", root);
    }

    public com.codename1.ui.Button findRegister() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Register", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Register", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findAccelerometer(Component root) {
        return (com.codename1.ui.Label)findByName("Accelerometer", root);
    }

    public com.codename1.ui.Label findAccelerometer() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Accelerometer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Accelerometer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findGyroscope(Component root) {
        return (com.codename1.ui.Label)findByName("Gyroscope", root);
    }

    public com.codename1.ui.Label findGyroscope() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Gyroscope", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Gyroscope", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton3(Component root) {
        return (com.codename1.ui.Button)findByName("Button3", root);
    }

    public com.codename1.ui.Button findButton3() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton2(Component root) {
        return (com.codename1.ui.Button)findByName("Button2", root);
    }

    public com.codename1.ui.Button findButton2() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findInOut(Component root) {
        return (com.codename1.ui.Button)findByName("InOut", root);
    }

    public com.codename1.ui.Button findInOut() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("InOut", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("InOut", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findPassword(Component root) {
        return (com.codename1.ui.TextField)findByName("Password", root);
    }

    public com.codename1.ui.TextField findPassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Password", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Password", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_MainGPS = 3;
    public static final int COMMAND_MainSensors = 1;
    public static final int COMMAND_MainBluetooth = 2;
    public static final int COMMAND_MainSerial = 4;

    protected boolean onMainGPS() {
        return false;
    }

    protected boolean onMainSensors() {
        return false;
    }

    protected boolean onMainBluetooth() {
        return false;
    }

    protected boolean onMainSerial() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_MainGPS:
                if(onMainGPS()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainSensors:
                if(onMainSensors()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainBluetooth:
                if(onMainBluetooth()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainSerial:
                if(onMainSerial()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("GPS".equals(f.getName())) {
            exitGPS(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(f.getName())) {
            exitSensors(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(f.getName())) {
            exitBluetooth(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(f.getName())) {
            exitUser(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(f.getName())) {
            exitSerial(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitGPS(Form f) {
    }


    protected void exitSensors(Form f) {
    }


    protected void exitBluetooth(Form f) {
    }


    protected void exitUser(Form f) {
    }


    protected void exitSerial(Form f) {
    }


    protected void exitMain(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("GPS".equals(f.getName())) {
            beforeGPS(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(f.getName())) {
            beforeSensors(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(f.getName())) {
            beforeBluetooth(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(f.getName())) {
            beforeUser(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(f.getName())) {
            beforeSerial(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeGPS(Form f) {
    }


    protected void beforeSensors(Form f) {
    }


    protected void beforeBluetooth(Form f) {
    }


    protected void beforeUser(Form f) {
    }


    protected void beforeSerial(Form f) {
    }


    protected void beforeMain(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("GPS".equals(c.getName())) {
            beforeContainerGPS(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(c.getName())) {
            beforeContainerSensors(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(c.getName())) {
            beforeContainerBluetooth(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(c.getName())) {
            beforeContainerUser(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(c.getName())) {
            beforeContainerSerial(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerGPS(Container c) {
    }


    protected void beforeContainerSensors(Container c) {
    }


    protected void beforeContainerBluetooth(Container c) {
    }


    protected void beforeContainerUser(Container c) {
    }


    protected void beforeContainerSerial(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("GPS".equals(f.getName())) {
            postGPS(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(f.getName())) {
            postSensors(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(f.getName())) {
            postBluetooth(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(f.getName())) {
            postUser(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(f.getName())) {
            postSerial(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postGPS(Form f) {
    }


    protected void postSensors(Form f) {
    }


    protected void postBluetooth(Form f) {
    }


    protected void postUser(Form f) {
    }


    protected void postSerial(Form f) {
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("GPS".equals(c.getName())) {
            postContainerGPS(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(c.getName())) {
            postContainerSensors(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(c.getName())) {
            postContainerBluetooth(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(c.getName())) {
            postContainerUser(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(c.getName())) {
            postContainerSerial(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerGPS(Container c) {
    }


    protected void postContainerSensors(Container c) {
    }


    protected void postContainerBluetooth(Container c) {
    }


    protected void postContainerUser(Container c) {
    }


    protected void postContainerSerial(Container c) {
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("GPS".equals(rootName)) {
            onCreateGPS();
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(rootName)) {
            onCreateSensors();
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(rootName)) {
            onCreateBluetooth();
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(rootName)) {
            onCreateUser();
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(rootName)) {
            onCreateSerial();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateGPS() {
    }


    protected void onCreateSensors() {
    }


    protected void onCreateBluetooth() {
    }


    protected void onCreateUser() {
    }


    protected void onCreateSerial() {
    }


    protected void onCreateMain() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("GPS".equals(f.getName())) {
            getStateGPS(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Sensors".equals(f.getName())) {
            getStateSensors(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Bluetooth".equals(f.getName())) {
            getStateBluetooth(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("User".equals(f.getName())) {
            getStateUser(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Serial".equals(f.getName())) {
            getStateSerial(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateGPS(Form f, Hashtable h) {
    }


    protected void getStateSensors(Form f, Hashtable h) {
    }


    protected void getStateBluetooth(Form f, Hashtable h) {
    }


    protected void getStateUser(Form f, Hashtable h) {
    }


    protected void getStateSerial(Form f, Hashtable h) {
    }


    protected void getStateMain(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("GPS".equals(f.getName())) {
            setStateGPS(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Sensors".equals(f.getName())) {
            setStateSensors(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Bluetooth".equals(f.getName())) {
            setStateBluetooth(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("User".equals(f.getName())) {
            setStateUser(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Serial".equals(f.getName())) {
            setStateSerial(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateGPS(Form f, Hashtable state) {
    }


    protected void setStateSensors(Form f, Hashtable state) {
    }


    protected void setStateBluetooth(Form f, Hashtable state) {
    }


    protected void setStateUser(Form f, Hashtable state) {
    }


    protected void setStateSerial(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Sensors")) {
            if("sendToParse".equals(c.getName())) {
                onSensors_SendToParseAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("User")) {
            if("Uesrname".equals(c.getName())) {
                onUser_UesrnameAction(c, event);
                return;
            }
            if("Password".equals(c.getName())) {
                onUser_PasswordAction(c, event);
                return;
            }
            if("Login".equals(c.getName())) {
                onUser_LoginAction(c, event);
                return;
            }
            if("Register".equals(c.getName())) {
                onUser_RegisterAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Main")) {
            if("InOut".equals(c.getName())) {
                onMain_InOutAction(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onMain_ButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onMain_Button1Action(c, event);
                return;
            }
            if("Button2".equals(c.getName())) {
                onMain_Button2Action(c, event);
                return;
            }
            if("Button3".equals(c.getName())) {
                onMain_Button3Action(c, event);
                return;
            }
        }
    }

      protected void onSensors_SendToParseAction(Component c, ActionEvent event) {
      }

      protected void onUser_UesrnameAction(Component c, ActionEvent event) {
      }

      protected void onUser_PasswordAction(Component c, ActionEvent event) {
      }

      protected void onUser_LoginAction(Component c, ActionEvent event) {
      }

      protected void onUser_RegisterAction(Component c, ActionEvent event) {
      }

      protected void onMain_InOutAction(Component c, ActionEvent event) {
      }

      protected void onMain_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onMain_Button1Action(Component c, ActionEvent event) {
      }

      protected void onMain_Button2Action(Component c, ActionEvent event) {
      }

      protected void onMain_Button3Action(Component c, ActionEvent event) {
      }

}
