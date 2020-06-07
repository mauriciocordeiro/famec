package br.org.mcord.famec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.org.mcord.famec.model.Usuario;
import br.org.mcord.famec.service.UsuarioService;

@Component
public class InitData {
	
	@Autowired
	UsuarioService usuarioService;

	@EventListener
    public void appReady(ApplicationReadyEvent event) {
		System.out.println("\t+ Application ready...");
		if(!usuarioService.hasUser()) {
			usuarioService.create(new Usuario(0, "Administrator", "admin", "admin", null, 1, null, "ADMIN"));
			System.out.println("\t+ Default user created");
		}
    }
	
}
