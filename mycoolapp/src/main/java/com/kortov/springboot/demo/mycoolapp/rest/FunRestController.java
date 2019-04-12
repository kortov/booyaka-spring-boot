package com.kortov.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

  @Value("${coach.name}")
  private String coachName;

  @Value("${team.name}")
  private String teamName;

  @GetMapping("/teaminfo")
  public String getTeamInfo() {
    return "Coach: " + coachName + ", teamName: " + teamName;
  }

  @GetMapping("/")
  public String sayHello() {
    return "Hello world! Time on the server is" + LocalDateTime.now();
  }

  @GetMapping("/workout")
  public String getDailyWorkout() {
    return "Booyaka Booyaka!!!";
  }

  @GetMapping("/fortune")
  public String getDailyFortune() {
    return "Today is your lucky day!";
  }
}
