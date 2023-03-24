package tech.itexpress.pets;


import org.bukkit.plugin.java.JavaPlugin;
import tech.itexpress.pets.Listener.InventoryClickListener;

public class Main extends JavaPlugin {

    private PetManager petManager;

    @Override
    public void onEnable() {
        petManager = new PetManager(this);
        getCommand("pet").setExecutor(new PetCommand(petManager));
        getServer().getPluginManager().registerEvents(new InventoryClickListener(petManager), this);

    }

    @Override
    public void onDisable() {
        petManager.removeAllPets();
    }
}
