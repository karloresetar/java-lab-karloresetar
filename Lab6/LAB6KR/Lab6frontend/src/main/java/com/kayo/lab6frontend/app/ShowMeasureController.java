package com.kayo.lab6frontend.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kayo.lab6frontend.models.Measure;
import jakarta.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class ShowMeasureController {
    RestTemplate restTemplate=new RestTemplate();


    @PostConstruct
    public void init() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper().registerModule(new JavaTimeModule()));
        restTemplate.getMessageConverters().add(converter);
    }


    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/measurelist")
    public String showMeasures(Model model) {
        Measure[] response=restTemplate.getForObject("http://localhost:8082/measures/listmeasures",Measure[].class);
        assert response != null;
        for (Measure m:response) {
            System.out.println(m);
        }
        model.addAttribute("measures", response);
        return "preview_measures";
    }

    @GetMapping("/addNewForm")
    public String showNewMeasureForm(Model model) {
        var measure=new Measure();
        model.addAttribute("measure",measure);
        return "new_measure";
    }


    @PostMapping("/add")
    public String addMeasure(@ModelAttribute Measure measure) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Measure> request = new HttpEntity<>(measure, headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/measures/add", HttpMethod.POST, request, String.class);
        System.out.println(response.getBody());
        return "redirect:/";
    }




}
