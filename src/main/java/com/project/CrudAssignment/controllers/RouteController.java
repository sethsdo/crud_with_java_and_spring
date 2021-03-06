package com.project.CrudAssignment.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.CrudAssignment.models.Language;
import com.project.CrudAssignment.services.LanguageService;

@Controller
public class RouteController {
    private int index;

    private final LanguageService languageService;
    public RouteController(LanguageService languageService) {
        this.languageService = languageService;
    }

    //SHOW ALL
    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("language") Language language){
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        System.out.println(languages);
        return "index";
    }

    //SHOW ONE

    @RequestMapping("/language/{index}")
    public String findLanguageByIndex(@PathVariable("index") Long index, Model model) {
        model.addAttribute("language", languageService.findLanguageById(index));
        return "showLanguage";
    }

    // @RequestMapping("language/{index}")
    // public String fndLanguageIndex(Model model, @PathVariable("index") int index) {
    //     System.out.println("find");
    //     System.out.println(index);
    //     Language language = languageService.findLanguageByIndex(index);
    //     model.addAttribute("language", language);
    //     model.addAttribute("index", index);
    //     return "showLanguage";
    // }

    //CREATE
    @PostMapping("/language/new")
    public String createBook(@Valid @ModelAttribute("language") Language language, BindingResult result, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version, @RequestParam(value = "id") Long id) {
        if (result.hasErrors()) {
            return "form";
        } else {
            Language newlang = new Language(name, creator, version, id);
            System.out.println(newlang);
            languageService.addLanguage(newlang);
            return "redirect:/";
        }
    }
    
    
    //EDIT
    @RequestMapping("/language/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguageById(id);
        if (language != null) {
            model.addAttribute("language", language);
            return "editLanguage";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result,
            @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "editLanguage.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/";
        }
    }

    // @RequestMapping("/language/edit/{id}")
    // public String editLanguage(@PathVariable("id") int id, Model model) {
    //     System.out.println(id);
    //     Language language = languageService.findLanguageByIndex(id);
    //     if (language != null) {
    //         model.addAttribute("language", language);
    //         model.addAttribute("id", id);
    //         return "editLanguage";
    //     } else {
    //         return "redirect:/";
    //     }
    // }

    // @PostMapping("/languages/edit/{id}")
    // public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language,
    //         BindingResult result, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
    //     if (result.hasErrors()) {
    //         return "editLanguage.jsp";
    //     } else {
    //         Language newlang = new Language(name, creator, version);
    //         languageService.updateLanguage(id, newlang);
    //         return "redirect:/";
    //     }
    // }

    //DELETE
    @RequestMapping(value = "/language/delete/{id}")
    public String destroyLanguage(@PathVariable("id") Long id) {
        languageService.destroyLanguage(id);
        return "redirect:/";
    }

    // @RequestMapping(value = "/language/delete/{id}")
    // public String destroyBook(@PathVariable("id") int id) {
    //     languageService.destroyLanguage(id);
    //     return "redirect:/";
    // }

}