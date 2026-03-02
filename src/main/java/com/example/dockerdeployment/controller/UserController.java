package com.example.dockerdeployment.controller;

import com.example.dockerdeployment.dto.UserRequestDto;
import com.example.dockerdeployment.dto.UserResponseDto;
import com.example.dockerdeployment.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

@Autowired
    private UserService userService;
@Autowired
private HealthEndpoint healthEndpoint;

    @GetMapping(value = "/health")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("{\"status\":\"OK\"}");
    }

    @GetMapping(value = {"", "/status"})
    public ResponseEntity<String> check() {
        String health = healthEndpoint.health().getStatus().getCode();
        return ResponseEntity.ok("{\"status\":\"" + health + "\"}");
    }

@GetMapping("/")
public String getHtmlForCreate(HttpServletRequest request){
    String ip=request.getRemoteAddr();
    System.out.println("THIS IS IP ADDRESS ------------"+ip);
    return "index";
}
    @GetMapping("/signup")
    public String creatingNavigator(Model model){
    model.addAttribute("user",new UserRequestDto());
        return "signup";
    }
@PostMapping("/create")
    public String creating(@ModelAttribute UserRequestDto dto){
    UserResponseDto responsedto= userService.saveUser(dto);
    return "redirect:/getAll";
}
@GetMapping("/getAll")
    public String allUsers(Model model){
    List<UserResponseDto>list=userService.allUsers();
    model.addAttribute("users",list);
    return "get-all-users";
}

}
