package dev.asif.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// By default, Spring instantiates all the beans during startup
// @Lazy annotation instructs Spring to instantiate the bean only when required
@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

}
