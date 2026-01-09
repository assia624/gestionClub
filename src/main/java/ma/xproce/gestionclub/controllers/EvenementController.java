package ma.xproce.gestionclub.controllers;

import ma.xproce.gestionclub.dto.EvenementDTO;
import ma.xproce.gestionclub.service.ClubService;
import ma.xproce.gestionclub.service.EvenementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/evenements")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @Autowired
    private ClubService clubService;

    @GetMapping
    public String listEvenements(Model model) {
        model.addAttribute("evenements", evenementService.getAllEvenements());
        return "evenements/list";
    }

    @GetMapping("/new")
    public String newEvenementForm(Model model) {
        model.addAttribute("evenement", new EvenementDTO());
        model.addAttribute("clubs", clubService.getAllClubs());
        return "evenements/form";
    }

    @GetMapping("/edit/{id}")
    public String editEvenementForm(@PathVariable Long id, Model model) {
        model.addAttribute("evenement", evenementService.getEvenementById(id));
        model.addAttribute("clubs", clubService.getAllClubs());
        return "evenements/form";
    }

    @PostMapping("/save")
    public String saveEvenement(@Valid @ModelAttribute("evenement") EvenementDTO evenementDTO,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("clubs", clubService.getAllClubs());
            return "evenements/form";
        }
        evenementService.saveEvenement(evenementDTO);
        redirectAttributes.addFlashAttribute("message", "Événement enregistré avec succès!");
        return "redirect:/evenements";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvenement(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        evenementService.deleteEvenement(id);
        redirectAttributes.addFlashAttribute("message", "Événement supprimé avec succès!");
        return "redirect:/evenements";
    }
}