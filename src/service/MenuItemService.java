package service;

import model.MenuItem;
import repository.MenuItemRepository;

import java.util.List;

public class MenuItemService {
    private final MenuItemRepository repository;

    public MenuItemService() {
        this.repository = new MenuItemRepository();
    }

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }

    public boolean createMenuItem(MenuItem menuItem) {
        return repository.insert(menuItem);
    }

    public boolean updateMenuItem(int id, MenuItem menuItem) {
        return repository.update(id, menuItem);
    }

    public boolean deleteMenuItem(int id) {
        return repository.delete(id);
    }
}
