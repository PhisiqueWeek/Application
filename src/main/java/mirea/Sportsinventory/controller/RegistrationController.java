package mirea.Sportsinventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mirea.Sportsinventory.entity.Credential;
import mirea.Sportsinventory.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/queries")
@Tag(name = "Registration Controller")
public class RegistrationController {

    @Autowired
    private CredentialService credentialService;

    @GetMapping("/registration")
    @Operation(summary = "Открыть форму регистрации")
    public String registration(Model model) {
        model.addAttribute("credentialForm", new Credential());

        return "registration";
    }

    @PostMapping("/registration")
    @Operation(summary = "Добавить данные пользователя")
    public String addCredential(@ModelAttribute("credentialForm") @Valid Credential credentialForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!credentialForm.getPassword().equals(credentialForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!credentialService.saveCredential(credentialForm)) {
            model.addAttribute("credentialError", "Логин занят");
            return "registration";
        }

        return "redirect:/";
    }
}
