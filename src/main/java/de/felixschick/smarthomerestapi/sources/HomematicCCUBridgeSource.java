package de.felixschick.smarthomerestapi.sources;

import de.felixschick.smarthomerestapi.sources.interfaces.iSmarthomeBridgeAPISource;
import de.felixschick.smarthomerestapi.utils.XMLValueExtractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HomematicCCUBridgeSource implements iSmarthomeBridgeAPISource {

    @Value("${homematic.api.url}")
    private String apiUrl;

    @Value("${homematic.auth.token}")
    private String authToken;

    private final RestTemplate restTemplate;

    public HomematicCCUBridgeSource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RestTemplate restClient() {
        return restTemplate;
    }

    @Override
    public String getDevices() {
        return restClient().getForObject(apiUrl + "/devicelist.cgi?{authToken}", String.class, authToken);
    }

    @Override
    public String getDeviceState(String deviceID) {
        String response = restClient().getForObject(apiUrl + "/state.cgi?datapoint_id={deviceID}&{authToken}", String.class, deviceID, authToken);
        return XMLValueExtractor.getValueFromXML(response, "/state/datapoint/@value");
    }

    @Override
    public void setDeviceState(String deviceID, String state) {
        restClient().getForObject(apiUrl + "/statechange.cgi?ise_id={deviceID}&new_value={state}&{authToken}", String.class, deviceID, state, authToken);
    }
}