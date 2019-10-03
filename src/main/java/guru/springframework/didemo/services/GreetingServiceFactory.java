package guru.springframework.didemo.services;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang){
        switch (lang){
            case "de":
                return new PrimaryGreetingGerman(greetingRepository);
            case "es":
                return new PrimaryGreetingSpanish(greetingRepository);
            default:
                return new PrimaryGreetingService(greetingRepository);
        }
    }
}
