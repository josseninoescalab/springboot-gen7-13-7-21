package com.escalab.mediapp.service;

import com.escalab.mediapp.entity.Menu;
import java.util.List;

public interface MenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
