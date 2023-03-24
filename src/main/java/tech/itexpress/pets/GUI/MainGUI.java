package tech.itexpress.pets.GUI;



import tech.itexpress.pets.PetManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainGUI {

    private PetManager petManager;

    public MainGUI(PetManager petManager) {
        this.petManager = petManager;
    }

    public void open(Player player) {
        Inventory mainGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "Pet Menu");

        ItemStack createPet = new ItemStack(Material.DIAMOND);
        ItemMeta createPetMeta = createPet.getItemMeta();
        createPetMeta.setDisplayName(ChatColor.GREEN + "Pet erstellen");
        createPet.setItemMeta(createPetMeta);

        ItemStack storePet = new ItemStack(Material.CHEST);
        ItemMeta storePetMeta = storePet.getItemMeta();
        storePetMeta.setDisplayName(ChatColor.YELLOW + "Pet Verstauen");
        storePet.setItemMeta(storePetMeta);

        mainGUI.setItem(2, createPet);
        mainGUI.setItem(6, storePet);

        player.openInventory(mainGUI);
    }
}
