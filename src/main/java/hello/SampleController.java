package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import org.json.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

  @RequestMapping("/hello")
  @ResponseBody
  String home() {
    return "Hello, world!";
  }

  @RequestMapping(value="/api/math/add", method = RequestMethod.POST)
  public @ResponseBody String addition(@RequestBody String jsonString) {
    JSONObject operands = new JSONObject(jsonString);
    long num1 = operands.getInt("num1");
    long num2 = operands.getInt("num2");
    long result = num1 + num2;

    // Sanity Check
    System.out.println("num1: " + new Long(num1).toString() + "num2: " + new Long(num2).toString());

    return "{\"result\":" + result + "}";
  }

  @RequestMapping(value="/api/math/subtract", method = RequestMethod.POST)
  public @ResponseBody String subtract(@RequestBody String jsonString) {
    JSONObject operands = new JSONObject(jsonString);
    long num1 = operands.getInt("num1");
    long num2 = operands.getInt("num2");
    long result = num1 - num2;

    // Sanity Check
    System.out.println("num1: " + new Long(num1).toString() + "num2: " + new Long(num2).toString());

    return "{\"result\":" + result + "}";
  }

  @RequestMapping(value="/api/math/multiply", method = RequestMethod.POST)
  public @ResponseBody String multiply(@RequestBody String jsonString) {
    JSONObject operands = new JSONObject(jsonString);
    long num1 = operands.getInt("num1");
    long num2 = operands.getInt("num2");
    long result = num1 * num2;

    // Sanity Check
    System.out.println("num1: " + new Long(num1).toString() + "num2: " + new Long(num2).toString());

    return "{\"result\":" + result + "}";
  }

  @RequestMapping(value="/api/math/divide", method = RequestMethod.POST)
  public @ResponseBody String divide(@RequestBody String jsonString) {
    JSONObject operands = new JSONObject(jsonString);
    long num1 = operands.getInt("num1");
    long num2 = operands.getInt("num2");
    double result = (double) num1 / num2;

    // Sanity Check
    System.out.println("num1: " + new Long(num1).toString() + "num2: " + new Long(num2).toString());

    return "{\"result\":" + result + "}";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SampleController.class, args);
  }
}
