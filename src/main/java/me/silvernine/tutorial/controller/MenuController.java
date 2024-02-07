package me.silvernine.tutorial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.entity.Menu;
import me.silvernine.tutorial.service.MenuService;
import me.silvernine.tutorial.service.UserService;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService _menuService) {
        this.menuService = _menuService;
    }


    @GetMapping("/")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<Menu>> getMenu() {
    	List<Menu> listMenu = menuService.findAll();
        return ResponseEntity.ok(listMenu);
    }
}