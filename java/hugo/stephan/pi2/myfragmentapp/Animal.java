package hugo.stephan.pi2.myfragmentapp;

public class Animal {

    //fields
    private String name, gps, battery, service, active, mnemonic;

    public Animal(String name, String gps, String battery, String service, String active, String mnemonic) {
        this.name = name;
        this.gps = gps;
        this.battery = battery;
        this.service = service;
        this.active = active;
        this.mnemonic = mnemonic;
    }

    public String getName() {
        return name;
    }

    public String getGps() {
        return gps;
    }

    public String getBattery() {
        return battery;
    }

    public String getService() {
        return service;
    }

    public String getActive() {
        return active;
    }

    public String getMnemonic() {
        return mnemonic;
    }
}
