import controller.MenuItemController;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);

        MenuItemController menuItemController = new MenuItemController();

        get("/menu", menuItemController::getAllMenuItems);
        post("/menu", menuItemController::createMenuItem);
        put("/menu/:id", menuItemController::updateMenuItem);
        delete("/menu/:id", menuItemController::deleteMenuItem);
    }
}
