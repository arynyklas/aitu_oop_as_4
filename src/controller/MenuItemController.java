package controller;

import com.google.gson.Gson;
import model.MenuItem;
import service.MenuItemService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class MenuItemController {
    private final MenuItemService menuItemService;
    private final Gson gson;

    public MenuItemController() {
        this.menuItemService = new MenuItemService();
        this.gson = new Gson();
    }

    public String getAllMenuItems(Request req, Response res) {
        res.type("application/json");

        return gson.toJson(menuItemService.getAllMenuItems());
    }

    public String createMenuItem(Request req, Response res) {
        MenuItem menuItem = gson.fromJson(req.body(), MenuItem.class);
        boolean created = menuItemService.createMenuItem(menuItem);

        Map<String, String> response = new HashMap<>();

        if (created) {
            res.status(201);
            response.put("message", "Menu item created successfully.");
        } else {
            res.status(400);
            response.put("message", "Failed to create menu item.");
        }

        return gson.toJson(response);
    }

    public String updateMenuItem(Request req, Response res) {
        int id = Integer.parseInt(req.params("id"));
        MenuItem menuItem = gson.fromJson(req.body(), MenuItem.class);
        boolean updated = menuItemService.updateMenuItem(id, menuItem);

        Map<String, String> response = new HashMap<>();

        if (updated) {
            res.status(200);
            response.put("message", "Menu item updated successfully.");
        } else {
            res.status(400);
            response.put("message", "Failed to update menu item.");
        }

        return gson.toJson(response);
    }

    public String deleteMenuItem(Request req, Response res) {
        int id = Integer.parseInt(req.params("id"));
        boolean deleted = menuItemService.deleteMenuItem(id);

        Map<String, String> response = new HashMap<>();

        if (deleted) {
            res.status(200);
            response.put("message", "Menu item deleted successfully.");
        } else {
            res.status(400);
            response.put("message", "Failed to delete menu item.");
        }

        return gson.toJson(response);
    }
}
