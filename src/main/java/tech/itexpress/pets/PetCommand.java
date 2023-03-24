package tech.itexpress.pets;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.itexpress.pets.GUI.MainGUI;
import tech.itexpress.pets.*;

public class PetCommand implements CommandExecutor {

    private PetManager petManager;

    public PetCommand(PetManager petManager) {
        this.petManager = petManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            petManager.openMainGUI(player);
        }
        return true;
    }
}
