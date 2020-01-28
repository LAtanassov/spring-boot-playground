package dev.latanassov.info;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${app_version:unknown}")
    private String version;

    @GetMapping("/info/version")
    public String version() {
        return version;
    }
}
