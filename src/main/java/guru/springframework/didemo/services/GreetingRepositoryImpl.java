package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getPrimaryGreeting() {
        return "Hello from primary Service";
    }

    @Override
    public String getGermanGreeting() {
        return "Primarer Grussdienst";
    }

    @Override
    public String getSpanishGreeting() {
        return "Servicio de saludo primario";
    }
}
