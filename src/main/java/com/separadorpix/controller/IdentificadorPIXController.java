package com.separadorpix.controller;

import com.separadorpix.service.IdentificadorPIXService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("pix")
@AllArgsConstructor
public class IdentificadorPIXController {

    private IdentificadorPIXService identificadorPIXService;

    @GetMapping("/format")
    public String identificarPIXForm(Model model) {
        model.addAttribute("input", "");
        model.addAttribute("identificador", model.getAttribute("identificador"));
        return "index";
    }

    @PostMapping("/save")
    public String identificarPIX(@ModelAttribute("input") String input, Model model, RedirectAttributes redirectAttributes) {
        String identificadorPIX = identificadorPIXService.extrairIdentificadorPIX(input);
        model.addAttribute("identificador", identificadorPIX);
        redirectAttributes.addFlashAttribute("identificador", identificadorPIX);
        return "redirect:/pix/format";
    }


}
