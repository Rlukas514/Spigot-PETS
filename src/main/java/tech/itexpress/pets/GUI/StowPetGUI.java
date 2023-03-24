package tech.itexpress.pets.GUI;


import tech.itexpress.pets.Pet;
import tech.itexpress.pets.PetManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class StowPetGUI {
    private final PetManager petManager;

    public StowPetGUI(PetManager petManager) {
        this.petManager = petManager;
    }

    public void open(Player player) {
        List<Pet> pets = petManager.getPetsForPlayer(player);
        int inventorySize = 9 * (int) Math.ceil(pets.size() / 9.0);

        Inventory inventory = Bukkit.createInventory(null, inventorySize, ChatColor.DARK_GREEN + "Pet verstauen");

        for (Pet pet : pets) {
            ItemStack itemStack = new ItemStack(Material.NAME_TAG);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.GREEN + pet.getPetType().name());
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Klicken, um dieses Haustier zu verstauen");
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            inventory.addItem(itemStack);
        }

        player.openInventory(inventory);
    }
}
