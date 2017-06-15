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
    long num1 = Long.parseLong(operands.getString("num1"));
    long num2 = Long.parseLong(operands.getString("num2"));
    long result = num1 + num2;

    // Sanity Check
    System.out.println("num1: " + new Long(num1).toString() + "num2: " + new Long(num2).toString());

    return "{'result':'" + result + "'}";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SampleController.class, args);
  }
}
