package tads.eaj.ufrn.medicamentoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tads.eaj.ufrn.medicamentoapp.model.Medicamento;
import tads.eaj.ufrn.medicamentoapp.service.FileStorageService;
import tads.eaj.ufrn.medicamentoapp.service.MedicamentoService;

import javax.validation.Valid;


@Controller
public class MedicamentoController {


    MedicamentoService service;
    FileStorageService fileStorageService;

    @Autowired
    public void setFileStorageService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }


    @Autowired
    public void setService(MedicamentoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model){

        var listaMedicamento = service.findAll();
        model.addAttribute("listaMedicamento", listaMedicamento );
        return "index";
    }

    @RequestMapping("/cadastro")
    public String getFormCadastro(Model model){
        Medicamento medicamento = new Medicamento();
        model.addAttribute("medicamento", medicamento);
        return "cadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute @Valid Medicamento medicamento, Errors errors, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttibutes){
        if (errors.hasErrors()){
            return "cadastro";
        }else {
            medicamento.setImagemUri(file.getOriginalFilename());
            service.save(medicamento);
            fileStorageService.save(file);
            redirectAttibutes.addAttribute("msg", "cadastro realizado com sucesso");
            return "redirect:/";
        }
    }
    @RequestMapping("/deletar/{id}")
    public String doDelete(@PathVariable(name="id") Long id){
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getFormEdicao(@PathVariable(name="id") Long id){
        ModelAndView modelAndView = new ModelAndView("edicao");
        Medicamento medicamento = service.findById(id);
        modelAndView = modelAndView.addObject("medicamento", medicamento);
        return modelAndView;
    }

}
