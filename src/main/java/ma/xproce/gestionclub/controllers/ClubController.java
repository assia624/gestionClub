package ma.xproce.gestionclub.controllers;


import ma.xproce.gestionclub.dto.ClubDTO;
import ma.xproce.gestionclub.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public String listClubs(Model model) {
        model.addAttribute("clubs", clubService.getAllClubs());
        return "clubs/list";
    }

    @GetMapping("/new")
    public String newClubForm(Model model) {
        model.addAttribute("club", new ClubDTO());
        return "clubs/form";
    }

    @GetMapping("/edit/{id}")
    public String editClubForm(@PathVariable Long id, Model model) {
        model.addAttribute("club", clubService.getClubById(id));
        return "clubs/form";
    }

    @PostMapping("/save")
    public String saveClub(@Valid @ModelAttribute("club") ClubDTO clubDTO,
                           BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "clubs/form";
        }
        clubService.saveClub(clubDTO);
        redirectAttributes.addFlashAttribute("message", "Club enregistré avec succès!");
        return "redirect:/clubs";
    }

    @GetMapping("/delete/{id}")
    public String deleteClub(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        clubService.deleteClub(id);
        redirectAttributes.addFlashAttribute("message", "Club supprimé avec succès!");
        return "redirect:/clubs";
    }

    @GetMapping("/details/{id}")
    public String clubDetails(@PathVariable Long id, Model model) {
        model.addAttribute("club", clubService.getClubById(id));
        return "clubs/details";
    }
}