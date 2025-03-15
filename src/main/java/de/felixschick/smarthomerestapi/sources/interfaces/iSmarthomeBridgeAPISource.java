package de.felixschick.smarthomerestapi.sources.interfaces;

import org.springframework.web.client.RestTemplate;

public interface iSmarthomeBridgeAPISource {

    RestTemplate restClient();

    String getDevices();

    String getDeviceState(String deviceID);

    void setDeviceState(String deviceID, String state);
}