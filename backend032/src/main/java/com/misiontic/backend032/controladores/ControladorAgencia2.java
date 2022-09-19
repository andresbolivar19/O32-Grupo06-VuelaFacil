package com.misiontic.backend032.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.misiontic.backend032.modelos.Agencias;

@Controller
public class ControladorAgencia2 {

  @GetMapping("/agencias2")
  public String agenciasForm(Model model) {
    model.addAttribute("agencias", new Agencias());
    return "agencias";
  }

  @PostMapping("/agencias2")
  public String agenciasSubmit(@ModelAttribute Agencias agencias, Model model) {
    model.addAttribute("agencias", agencias);
    return "result";
  }

}