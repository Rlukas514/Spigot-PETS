package tech.itexpress.pets.GUI;



import tech.itexpress.pets.PetManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreatePetGUI {

    private PetManager petManager;

    public CreatePetGUI(PetManager petManager) {
        this.petManager = petManager;
    }

    public void open(Player player) {
        Inventory createPetGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "Pet erstellen");

        ItemStack dogItem = new ItemStack(Material.BONE);
        ItemMeta dogMeta = dogItem.getItemMeta();
        dogMeta.setDisplayName(ChatColor.GREEN + "Hund");
        dogItem.setItemMeta(dogMeta);

        ItemStack catItem = new ItemStack(Material.STRING);
        ItemMeta catMeta = catItem.getItemMeta();
        catMeta.setDisplayName(ChatColor.GREEN + "Katze");
        catItem.setItemMeta(catMeta);

        ItemStack parrotItem = new ItemStack(Material.FEATHER);
        ItemMeta parrotMeta = parrotItem.getItemMeta();
        parrotMeta.setDisplayName(ChatColor.GREEN + "Papagei");
        parrotItem.setItemMeta(parrotMeta);

        createPetGUI.setItem(1, dogItem);
        createPetGUI.setItem(4, catItem);
        createPetGUI.setItem(7, parrotItem);

        player.openInventory(createPetGUI);
    }
}
