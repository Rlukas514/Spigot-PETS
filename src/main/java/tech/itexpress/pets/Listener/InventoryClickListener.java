package tech.itexpress.pets.Listener;

import tech.itexpress.pets.Pet;
import tech.itexpress.pets.PetManager;
import tech.itexpress.pets.PetType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {
    private final PetManager petManager;

    public InventoryClickListener(PetManager petManager) {
        this.petManager = petManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        String inventoryTitle = event.getView().getTitle();

        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) {
            return;
        }

        String itemName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

        if (ChatColor.stripColor(inventoryTitle).equalsIgnoreCase("Pets")) {
            event.setCancelled(true);

            if (itemName.equalsIgnoreCase("Pet erstellen")) {
                petManager.openCreatePetGUI((Player) event.getWhoClicked());
            } else if (itemName.equalsIgnoreCase("Pet verstauen")) {
                petManager.openStowPetGUI((Player) event.getWhoClicked());
            }
        } else if (ChatColor.stripColor(inventoryTitle).equalsIgnoreCase("Pet erstellen")) {
            event.setCancelled(true);

            try {
                PetType petType = PetType.valueOf(itemName);
                petManager.createPet((Player) event.getWhoClicked(), petType);
            } catch (IllegalArgumentException e) {
                // Do nothing if the item name does not match a valid PetType
            }
        } else if (ChatColor.stripColor(inventoryTitle).equalsIgnoreCase("Pet verstauen")) {
            event.setCancelled(true);

            PetType petType = PetType.valueOf(itemName);
            Player player = (Player) event.getWhoClicked();
            Pet pet = petManager.getPet(player, petType);

            if (pet != null) {
                pet.getEntity().remove();
                petManager.removePet(player);
            }
        }
    }
}
