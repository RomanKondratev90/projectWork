package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:accesses.properties")
public interface AccessesConfig extends Config {
    @Key("URL")
    String URL();
}
