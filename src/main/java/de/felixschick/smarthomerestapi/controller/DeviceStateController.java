package de.felixschick.smarthomerestapi.controller;

import de.felixschick.smarthomerestapi.sources.SmarthomeBridgeAPIFactory;
import de.felixschick.smarthomerestapi.sources.interfaces.iSmarthomeBridgeAPISource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/device/state")
public class DeviceStateController {

    private final SmarthomeBridgeAPIFactory smarthomeBridgeAPIFactory;

    @Autowired
    public DeviceStateController(SmarthomeBridgeAPIFactory smarthomeBridgeAPIFactory) {
        this.smarthomeBridgeAPIFactory = smarthomeBridgeAPIFactory;
    }

    @RequestMapping()
    public String getDeviceState(@RequestParam String source, @RequestParam String deviceID) {
        iSmarthomeBridgeAPISource apiSource = smarthomeBridgeAPIFactory.getSource(source);
        return apiSource.getDeviceState(deviceID);
    }

    @PostMapping()
    public void setDeviceState(@RequestParam String source, @RequestParam String deviceID, @RequestParam String state) {
        iSmarthomeBridgeAPISource apiSource = smarthomeBridgeAPIFactory.getSource(source);
        apiSource.setDeviceState(deviceID, state);
    }

    @PostMapping("/toggle")
    public void toggleDeviceState(@RequestParam String source, @RequestParam String deviceID) {
        iSmarthomeBridgeAPISource apiSource = smarthomeBridgeAPIFactory.getSource(source);
        String currentState = apiSource.getDeviceState(deviceID);
        Boolean state = Boolean.parseBoolean(currentState);
        if (state) {
            apiSource.setDeviceState(deviceID, "false");
        } else
            apiSource.setDeviceState(deviceID, "true");
    }
}
