package com.example.spring.controller;

import com.example.spring.entity.Hero;
import com.example.spring.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/heros")
public class HeroController {

    @Autowired
    HeroService heroService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Hero> list = heroService.heroList();
        model.addAttribute("heros", list);
        return "hero/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("hero", new Hero());
        return "hero/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Hero hero, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hero", hero);
            return "hero/form";
        }
        heroService.create(hero);
        return "redirect:/heros";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String details(@PathVariable int id, Model model) {
        Hero hero = heroService.getById(id);
        if (hero == null) {
            return null;
        }
        model.addAttribute("heros", hero);
        return "hero/details";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Hero hero = heroService.getById(id);
        if (hero == null) {
            return "error/404";
        }
        model.addAttribute("hero", hero);
        return "hero/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, Hero updateHero) {
        Hero hero = heroService.getById(id);
        if (hero == null) {
            return "error/404";
        }
        hero.setName(updateHero.getName());
        hero.setDescription(updateHero.getDescription());
        heroService.update(hero);
        return "redirect:/heros";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        Hero hero = heroService.getById(id);
        if (hero == null) {
            return "error/404";
        }
        heroService.delete(id);
        return "redirect:/heros";
    }

}
