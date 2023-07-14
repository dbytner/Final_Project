package pl.coderslab.production;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.contractors.ContractorsDao;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/production")
public class ProductionController {

    private final ProductionDao productionDao;
    private final ContractorsDao contractorsDao;

    public ProductionController(ProductionDao productionDao, ContractorsDao contractorsDao) {
        this.productionDao = productionDao;
        this.contractorsDao = contractorsDao;
    }

    @GetMapping("/add")
    public String test(Model model) {
        model.addAttribute("productions", new Production());
        model.addAttribute("contractors", contractorsDao.findAllContractors());
        return "production/productionsAdd";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable long id, Model model) {
        model.addAttribute("productions", new Production());
        model.addAttribute("contractors", contractorsDao.find(id));
        return "production/productionsAddContractor";
    }

    @PostMapping("/add")
    public String save(Production production) {
        production.setCreated(production.getCreated());
        productionDao.save(production);
        return "redirect:/production/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("productions", productionDao.findAllProductions());
        return "production/productionsList";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("productions", productionDao.find(id));
        model.addAttribute("contractors", productionDao.findAllProductions());
        return "production/productionsEdit";
    }

    @PostMapping("/edit")
    public String updateProduction(Production production) {
        production.setUpdated(production.getUpdated());
        productionDao.update(production);
        return "redirect:/production/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("productions", productionDao.find(id));
        return "production/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Production production = productionDao.find(id);
        productionDao.delete(production);
        return "redirect:/production/list";
    }

    @GetMapping("/details/{id}")
    public String ordersDetails(@PathVariable long id, Model model) {
        model.addAttribute("productions", productionDao.find(id));
        return "production/productionsDetails";
    }

    @ModelAttribute("productionsType")
    public List<String> productionsType() {
        return Arrays.asList("Wizytówki", "Banery", "Ulotki", "Plakaty", "Rollup");
    }

    @ModelAttribute("productionsStatus")
    public List<String> productionsStatus() {
        return Arrays.asList("Rozpoczęte", "W trakcie realizacji", "Montaż", "U klienta", "Czeka na płatność", "Zakończone");
    }
}
