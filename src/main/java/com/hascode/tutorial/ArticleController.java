package com.hascode.tutorial;

import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ArticleController {

  static class Article {

    private String title;
    private String url;

    public Article(String title, String url) {
      this.title = title;
      this.url = url;
    }

    public String getTitle() {
      return title;
    }

    public String getUrl() {
      return url;
    }
  }

  @GetMapping(path = "/articles")
  public String getProducts(Model model) {
    model.addAttribute("articles", Arrays.asList(
        new Article("Microbenchmarks with JMH / Java Microbenchmark Harness",
            "http://www.hascode.com/2017/10/microbenchmarks-with-jmh-java-microbenchmark-harness/"),
        new Article(
            "Resilient Architecture in Practice – Circuit Breakers for Java: Failsafe, Javaslang, Hystrix and Vert.x",
            "http://www.hascode.com/2017/02/resilient-architecture-circuit-breakers-for-java-hystrix-vert-x-javaslang-and-failsafe-examples/"),
        new Article("Assuring Architectural Rules with ArchUnit",
            "http://www.hascode.com/2017/07/assuring-architectural-rules-with-archunit/")));
    return "articles";
  }

  @GetMapping(path = "/logout")
  public String logout(HttpServletRequest request) throws ServletException {
    request.logout();
    return "/";
  }
}
