package com.example.tp4.web;

import com.example.tp4.entities.Medecin;
import com.example.tp4.entities.Patient;
import com.example.tp4.repositories.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
//Pour faire l'injection de dépendance utiliser l'annotation de Lombok ==> AllArgsContructors
@AllArgsConstructor
public class MedecinController {
    private MedecinRepository medecinRepository;

    //Faire de la pagination en utilisant default nbr pages=0 and size=5(combient d'elt à afficher)
    @GetMapping(path="/user/indexMed")
    public String medecins(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "5") int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword){
        //Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page,size));
        Page<Medecin> pageMedecin = medecinRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listMedecins",pageMedecin.getContent());
        model.addAttribute("pages", new int[pageMedecin.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "medecins";
    }

    @GetMapping("/admin/deleteMed")
    public String delete(Long id, String keyword, int page){
        medecinRepository.deleteById(id);
        return "redirect:/user/indexMed?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/formMedecins")
    public String formMedecin(Model model){
        model.addAttribute("medecin", new Medecin());
        return "formMedecins";
    }

    @PostMapping("/admin/saveMed")
    public String save(Model model,
                       @Valid Medecin medecin,
                       BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page) {
        if(bindingResult.hasErrors()) return "formMedecins";
        medecinRepository.save(medecin);
        return "redirect:/user/indexMed?page="+page+"&$keyword="+keyword;
    }

    @GetMapping("/admin/editMedecins")
    public String editPatient(Model model, Long id, String keyword, int page){
        Medecin medecin = medecinRepository.findById(id).orElse(null);
        if(medecin==null) throw new RuntimeException("Medecin Introuvable");
        model.addAttribute("medecin", medecin);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editMedecins";
    }

}
