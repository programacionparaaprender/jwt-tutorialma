package me.silvernine.tutorial.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.silvernine.tutorial.entity.Authority;
import me.silvernine.tutorial.entity.Menu;
import me.silvernine.tutorial.entity.TarjetaCredito;
import me.silvernine.tutorial.entity.TipoCambio;
import me.silvernine.tutorial.entity.User;
import me.silvernine.tutorial.repository.AuthorityRepository;
import me.silvernine.tutorial.repository.MenuRepository;
import me.silvernine.tutorial.repository.TarjetaRepository;
import me.silvernine.tutorial.repository.TipoCambioRepository;
import me.silvernine.tutorial.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final TipoCambioRepository tipoCambioRepository;
    private final MenuRepository menuRepository;
    private final TarjetaRepository tarjetaRepository;
    
    public DataInitializer(UserRepository userRepository, AuthorityRepository authorityRepository,
    		TipoCambioRepository tipoCambioRepository,
    		MenuRepository menuRepository,
    		TarjetaRepository tarjetaRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.tipoCambioRepository = tipoCambioRepository;
        this.menuRepository = menuRepository;
        this.tarjetaRepository = tarjetaRepository;
    }

    @Override
    public void run(String... args) {
    	
    	
    	Authority userRole = new Authority();
    	userRole.setAuthorityName("ROLE_USER");
    	
    	Authority adminRole = new Authority();
    	adminRole.setAuthorityName("ROLE_ADMIN");
    	
    	
    	User user1 = new User();
    	user1.setUsername("admin"); 
    	user1.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
    	user1.setActivated(true);
    	user1.setEmail("admin@ejemplo.com");
    	user1.setAuthorities(Set.of(userRole, adminRole));
    	
    	User user2 = new User();
    	user2.setUsername("user"); 
    	user2.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
    	user2.setActivated(true);
    	user2.setEmail("user@ejemplo.com");
    	user2.setAuthorities(Set.of(userRole));
    	
    	TipoCambio tipo1 = new TipoCambio();
    	tipo1.setMonedaorigen("PE");
    	tipo1.setMonedadestino("US");
    	tipo1.setCambio(0.271);
    	
    	TipoCambio tipo2 = new TipoCambio();
    	tipo2.setMonedaorigen("US");
    	tipo2.setMonedadestino("PE");
    	tipo2.setCambio(3.69);
    	
    	
    	//insert into menu(id, nombre, url, hijo) values(1, 'inicio', '/', 0);
    	//insert into menu(id, nombre, url, hijo) values(2, 'usuarios', '/usuarios', 1);
    	//insert into menu(id, nombre, url, hijo) values(3, 'tarjeta', '/tarjeta', 1);
    	
    	Menu menu1 = new Menu();
    	menu1.setNombre("inicio");
    	menu1.setUrl("/");
    	menu1.setHijo(0);
    	
    	Menu menu2 = new Menu();
    	menu2.setNombre("usuarios");
    	menu2.setUrl("/usuarios");
    	menu2.setHijo(1);
    	
    	
    	Menu menu3 = new Menu();
    	menu3.setNombre("tarjeta");
    	menu3.setUrl("/tarjeta");
    	menu3.setHijo(1);
    	
    	//insert into tarjetacredito(id, titular, numerotarjeta, fecha_expiracion, cvv) values(1, 'Pedro Gonzales', '1234567812345678', '02/26', '337');
    	//insert into tarjetacredito(id, titular, numerotarjeta, fecha_expiracion, cvv) values(2, 'Maria Marcano', '9234567812345678', '02/28', '338');
    	//insert into tarjetacredito(id, titular, numerotarjeta, fecha_expiracion, cvv) values(3, 'Talia Rodriguez', '8234567812345678', '02/26', '339');
    	
    	TarjetaCredito tarjeta1 = new TarjetaCredito();
    	tarjeta1.setTitular("Pedro Gonzales");
    	tarjeta1.setNumerotarjeta("1234567812345678");
    	tarjeta1.setFechaExpiracion("02/26");
    	tarjeta1.setCvv("337");
    	
    	
    	TarjetaCredito tarjeta2 = new TarjetaCredito();
    	tarjeta2.setTitular("Maria Marcano");
    	tarjeta2.setNumerotarjeta("9234567812345678");
    	tarjeta2.setFechaExpiracion("02/28");
    	tarjeta2.setCvv("338");
    	
    	
    	TarjetaCredito tarjeta3 = new TarjetaCredito();
    	tarjeta3.setTitular("Talia Rodriguez");
    	tarjeta3.setNumerotarjeta("8234567812345678");
    	tarjeta3.setFechaExpiracion("02/26");
    	tarjeta3.setCvv("339");
    	
    	if(!authorityRepository.existsByAuthorityName(userRole.getAuthorityName())) {
    		authorityRepository.save(userRole);
    	}
    	if(!authorityRepository.existsByAuthorityName(userRole.getAuthorityName())) {
    		authorityRepository.save(adminRole);
    	}
    	
    	if(!userRepository.existsByUsername(user1.getUsername())) {
    		userRepository.save(user1);
    	}
    	if(!userRepository.existsByUsername(user2.getUsername())) {
    		userRepository.save(user2);
    	}

        
        tipoCambioRepository.save(tipo1);
        tipoCambioRepository.save(tipo2);
        
        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);
        

        if(!tarjetaRepository.existsByNumerotarjeta(tarjeta1.getNumerotarjeta())) {
        	this.tarjetaRepository.save(tarjeta1);
    	}
        if(!tarjetaRepository.existsByNumerotarjeta(tarjeta2.getNumerotarjeta())) {
        	this.tarjetaRepository.save(tarjeta2);
    	}
        if(!tarjetaRepository.existsByNumerotarjeta(tarjeta3.getNumerotarjeta())) {
        	this.tarjetaRepository.save(tarjeta3);
    	}
        
    }
}
