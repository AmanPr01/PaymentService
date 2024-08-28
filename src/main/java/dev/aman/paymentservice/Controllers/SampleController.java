package dev.aman.paymentservice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/{id}")
    public String sampleAPI(@PathVariable("id") Long id) {
        return "Hello Everybody " + id;
    }
}
