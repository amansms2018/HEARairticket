package edu.mum.cs425.HEARairticket.controller;

import edu.mum.cs425.HEARairticket.model.Schuedule;
import edu.mum.cs425.HEARairticket.repository.AirportRepository;
import edu.mum.cs425.HEARairticket.service.SchueduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SchueduleController {

    @Autowired
    AirportRepository airportRepository;
    @Autowired
    SchueduleService schueduleService;
    @GetMapping(value="/newSchuedule")
    public String recordingSchuedule(ModelMap model) {
        Schuedule schuedule = new Schuedule();
        model.addAttribute("schuedule",schuedule);
        return "admin/addSchuedulingPage";
    }
    @PostMapping(value="/saveSchuedule")
    public String saveRegistration(@Valid Schuedule schuedule, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        schueduleService.SaveSchuedule(schuedule);
        return "redirect:/admin/schueduleList";
    }
    @GetMapping(value = "/admin/schueduleList")
    public ModelAndView getAll() {
        List<Schuedule> schuedules = schueduleService.searchAllSchuedule();
        return new ModelAndView("admin/schueduleList", "schuedules", schuedules);
    }

    @RequestMapping(value="/editschuedule/{id}")
    public String edit (@PathVariable Long id,ModelMap model) {
        Schuedule schuedule=schueduleService.searchById(id);
        model.addAttribute("schuedule",schuedule);
        return "admin/editschuedule";
    }

    @PostMapping(value = "/editsave")
    public String editsave(@ModelAttribute("schuedule") Schuedule p) {
        Schuedule schuedule = schueduleService.searchById(p.getId());

        schuedule.setDepartureAirport(p.getDepartureAirport());
        schuedule.setDepartureDate(p.getDepartureDate());
        schuedule.setDepartureTime(p.getDepartureTime());
        schuedule.setArriavaleAirport(p.getArriavaleAirport());
        schuedule.setArrivaleTime(p.getArrivaleTime());
        schuedule.setArrivaleaDate(p.getArrivaleaDate());
        schuedule.setPrice(p.getPrice());

        schueduleService.SaveSchuedule(schuedule);
        return "redirect:/schuedule/list";
    }

    @RequestMapping(value="/deleteschuedule/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        schueduleService.deleteSchueduleById(id);
        return "redirect:/admin/schueduleList";
    }


    @ModelAttribute("airports")
    public List<Airport> initializeCountries() {

        List<Airport> airports =airportRepository.findAll();
        return airports;
    }

}
