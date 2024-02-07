package me.silvernine.tutorial.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.entity.Authority;
import me.silvernine.tutorial.entity.Menu;
import me.silvernine.tutorial.entity.User;
import me.silvernine.tutorial.exception.DuplicateMemberException;
import me.silvernine.tutorial.exception.NotFoundMemberException;
import me.silvernine.tutorial.repository.MenuRepository;
import me.silvernine.tutorial.repository.UserRepository;
import me.silvernine.tutorial.util.SecurityUtil;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository _menuRepository) {
        this.menuRepository = _menuRepository;
    }

    @Transactional
    public List<Menu> findAll() {
        List<Menu> listMenu = menuRepository.findAll();
        return listMenu;
    }

}