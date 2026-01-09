package ma.xproce.gestionclub.controllers;

import ma.xproce.gestionclub.dto.MembreDTO;
import ma.xproce.gestionclub.service.ClubService;
import ma.xproce.gestionclub.service.MembreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/membres")
public class MembreController {

    @Autowired
    private MembreService membreService;

    @Autowired
    private ClubService clubService;

    @GetMapping
    public String listMembres(Model model) {
        model.addAttribute("membres", membreService.getAllMembres());
        return "membres/list";
    }

    @GetMapping("/new")
    public String newMembreForm(Model model) {
        model.addAttribute("membre", new MembreDTO());
        model.addAttribute("clubs", clubService.getAllClubs());
        return "membres/form";
    }

    @GetMapping("/edit/{id}")
    public String editMembreForm(@PathVariable Long id, Model model) {
        model.addAttribute("membre", membreService.getMembreById(id));
        model.addAttribute("clubs", clubService.getAllClubs());
        return "membres/form";
    }

    @PostMapping("/save")
    public String saveMembre(@Valid @ModelAttribute("membre") MembreDTO membreDTO,
                             BindingResult result,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("clubs", clubService.getAllClubs());
            return "membres/form";
        }
        membreService.saveMembre(membreDTO);
        redirectAttributes.addFlashAttribute("message", "Membre enregistré avec succès!");
        return "redirect:/membres";
    }

    @GetMapping("/delete/{id}")
    public String deleteMembre(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        membreService.deleteMembre(id);
        redirectAttributes.addFlashAttribute("message", "Membre supprimé avec succès!");
        return "redirect:/membres";
    }
}