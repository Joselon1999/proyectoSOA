package utp.soa.avance.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.UseUserRequest;
import utp.soa.avance.model.Usuario;
import utp.soa.avance.service.RolService;
import utp.soa.avance.service.UserService;

@Controller
@RequestMapping("/admin/gestion-usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolService rolService;


    @GetMapping()
    public String gestionUsuarios(@RequestParam(defaultValue = "1") int pagina,
                                  @RequestParam(defaultValue = "5") int tamanio,
                                  Model model) {
        Page<Usuario> userList = userService.listUsuario(pagina, tamanio);
        model.addAttribute("usuarios", userList.getContent());
        model.addAttribute("paginaActual", pagina);
        model.addAttribute("totalPaginas", userList.getTotalPages());
        return "mainUsuarios";
    }
    @GetMapping("/usuario/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.listarRoles());
        return "createUsuario";
    }

    @PostMapping("/usuario/nuevo")
    public String saveEstudio(@Valid @ModelAttribute("alimento") Usuario usuario,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "createUsuario";
        }
        userService.createUser(usuario);
        return "redirect:/admin/gestion-usuarios";
    }

    @GetMapping("/{id}/actualizar")
    public String usarUsuario(@PathVariable String id,Model model) {
        UseUserRequest request = new UseUserRequest();
        request.setEmail(id);

        model.addAttribute("usuario", userService.getUsuario(id));
        model.addAttribute("request", request);
        return "updateUsuario";
    }

    @PostMapping("/actualizar")
    public String registrarUsoUsuario(@ModelAttribute("request") UseUserRequest request,
                                       Model model) {
        Usuario usuario = userService.getUsuario(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (request.getPassword().isEmpty()) {
            model.addAttribute("usuario", userService.getUsuario(request.getEmail()));
            model.addAttribute("request", request);
            return "updateUsuario";
        }
        userService.updateUser(request);
        return "redirect:/admin/gestion-usuarios";
    }
}
