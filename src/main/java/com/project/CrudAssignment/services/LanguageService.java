package com.project.CrudAssignment.services;
import com.project.CrudAssignment.models.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller 
public class LanguageService {

    private List<Language> languages = new ArrayList(Arrays.asList(
        new Language("Python", "Guido van Rossum", "3.6.1"),
        new Language("Python", "Guido van Rossum", "3.6.1"),
        new Language("Python", "Guido van Rossum", "3.6.1"),
        new Language("Python", "Guido van Rossum", "3.6.1"),
        new Language("Python", "Guido van Rossum", "3.6.1"),
        new Language("Python", "Guido van Rossum", "3.6.1"),
        new Language("Python", "Guido van Rossum", "3.6.1")
    ));

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public List<Language> allLangauges() {
        return languages;
    }

    public Language findLanguageByIndex(int index) {
        if (index < languages.size()) {
            return languages.get(index);
        } else {
            return null;
        }
    }

    public void updateLanguage(int id, Language language) {
        if (id < languages.size()) {
            languages.set(id, language);
        }
    }

    public void destroyLanguage(int id) {
        if (id < languages.size()) {
            languages.remove(id);
        }
    }
    
}