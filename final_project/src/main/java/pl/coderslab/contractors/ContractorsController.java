package pl.coderslab.contractors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.customers.Customer;

@Controller
@RequestMapping("/contractors")
public class ContractorsController {

    private final ContractorsDao contractorsDao;

    public ContractorsController(ContractorsDao contractorsDao) {
        this.contractorsDao = contractorsDao;
    }


    @GetMapping("/add")
    public String test(Model model) {
        model.addAttribute("contractors", new Contractors());
        return "contractors/contractorsAdd";
    }

    @PostMapping("/add")
    public String save(Contractors contractors) {
        contractorsDao.save(contractors);
        return "redirect:/contractors/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contractors", contractorsDao.findAllContractors());
        return "contractors/contractorsList";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("contractors", contractorsDao.find(id));
        return "contractors/contractorsEdit";
    }

    @PostMapping("/edit")
    public String updateContractors(Contractors contractors) {
        contractorsDao.update(contractors);
        return "redirect:/contractors/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("contractors", contractorsDao.find(id));
        return "contractors/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Contractors contractors = contractorsDao.find(id);
        contractorsDao.delete(contractors);
        return "redirect:/contractors/list";
    }
    @GetMapping("/details/{id}")
    public String contractorsDetails(@PathVariable long id, Model model) {
        model.addAttribute("contractors", contractorsDao.find(id));
        return "contractors/contractorsDetails";
    }
}
