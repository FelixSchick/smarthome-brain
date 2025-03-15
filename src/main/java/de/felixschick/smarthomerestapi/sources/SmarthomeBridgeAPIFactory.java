package de.felixschick.smarthomerestapi.sources;

import de.felixschick.smarthomerestapi.sources.interfaces.iSmarthomeBridgeAPISource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmarthomeBridgeAPIFactory {

    private final Map<String, iSmarthomeBridgeAPISource> sources;

    @Autowired
    public SmarthomeBridgeAPIFactory(Map<String, iSmarthomeBridgeAPISource> sources) {
        this.sources = sources;
    }

    public iSmarthomeBridgeAPISource getSource(String sourceName) {
        return sources.get(sourceName);
    }
}