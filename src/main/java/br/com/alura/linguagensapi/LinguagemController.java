package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
	
	
//	private List<Linguagem> linguagens = 
//			List.of(
//					new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
//					new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2),
//					new Linguagem("Phyton", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png", 3));
	
    @Autowired
    private LinguagemRepository repository;

	@GetMapping("/linguagem-preferida")
	public String precessaLinguagemPreferida () {
		return "Oi, Java!";
	}
	
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> language = repository.findAll();
        return language;
   }
    
    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
    	Linguagem linguagemSalva = repository.save(linguagem);
    	return linguagemSalva;
    }
    
}