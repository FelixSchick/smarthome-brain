package de.felixschick.smarthomerestapi.controller;

import de.felixschick.smarthomerestapi.sources.SmarthomeBridgeAPIFactory;
import de.felixschick.smarthomerestapi.sources.interfaces.iSmarthomeBridgeAPISource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private final SmarthomeBridgeAPIFactory smarthomeBridgeAPIFactory;

    @Autowired
    public DeviceController(SmarthomeBridgeAPIFactory smarthomeBridgeAPIFactory) {
        this.smarthomeBridgeAPIFactory = smarthomeBridgeAPIFactory;
    }

    @RequestMapping("/getDevices")
    public String getDevices(@RequestParam String source) {
        iSmarthomeBridgeAPISource apiSource = smarthomeBridgeAPIFactory.getSource(source);
        return apiSource.getDevices();
    }

}
