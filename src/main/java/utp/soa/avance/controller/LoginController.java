package utp.soa.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utp.soa.avance.dao.TokenRepository;
import utp.soa.avance.dto.PasswordResetToken;
import utp.soa.avance.dto.UserDTO;
import utp.soa.avance.model.Usuario;
import utp.soa.avance.service.UserService;
import utp.soa.avance.service.impl.UserDetailsServiceImpl;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private TokenRepository tokenRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String viewHomePage(Model model) {

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model m) {
        return "index";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        return "/admin/dashboard";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        return "login";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("/forgotPassword")
    public String forgotPassordProcess(@ModelAttribute UserDTO userDTO) {
        String homeURL = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String output = "";
        Usuario user = userService.getUsuario(userDTO.getEmail()).get();
        if (user != null) {
            output = userDetailsService.sendEmail(user,homeURL);
        }
        if (output.equals("success")) {
            return "redirect:/forgotPassword?success";
        }
        return "redirect:/login?error";
    }

    @GetMapping("/resetPassword/{token}")
    public String resetPasswordForm(@PathVariable String token, Model model) {
        PasswordResetToken reset = tokenRepository.findByToken(token);
        if (reset != null && userDetailsService.hasExipred(reset.getExpiryDateTime())) {
            model.addAttribute("email", reset.getUser().getEmail());
            return "resetPassword";
        }
        return "redirect:/forgotPassword?error";
    }

    @PostMapping("/resetPassword")
    public String passwordResetProcess(@ModelAttribute UserDTO userDTO) {
        Usuario user = userService.getUsuario(userDTO.getEmail()).get();
        if(user != null) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userService.updateUser(user);
        }
        return "redirect:/login";
    }
}
