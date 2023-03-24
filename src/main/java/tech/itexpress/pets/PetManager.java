package tech.itexpress.pets;

import tech.itexpress.pets.GUI.CreatePetGUI;
import tech.itexpress.pets.GUI.MainGUI;
import tech.itexpress.pets.GUI.StowPetGUI;

import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetManager {

    private Main plugin;
    private Map<Player, Pet> pets;
    private MainGUI mainGUI;
    private CreatePetGUI createPetGUI;
    private StowPetGUI stowPetGUI;

    public PetManager(Main plugin) {
        this.plugin = plugin;
        pets = new HashMap<>();
        mainGUI = new MainGUI(this);
        createPetGUI = new CreatePetGUI(this);
        stowPetGUI = new StowPetGUI(this);
    }

    public void openMainGUI(Player player) {
        mainGUI.open(player);
    }

    public void openCreatePetGUI(Player player) {
        createPetGUI.open(player);
    }

    public void openStowPetGUI(Player player) {
        stowPetGUI.open(player);
    }

    public void createPet(Player player, PetType type) {
        Tameable petEntity = type.spawnPet(player);
        Pet pet = new Pet(player, type, petEntity);
        pets.put(player, pet);
    }

    public void removeAllPets() {
        for (Pet pet : pets.values()) {
            pet.getEntity().remove();
        }
        pets.clear();
    }

    public List<Pet> getPetsForPlayer(Player player) {
        List<Pet> playerPets = new ArrayList<>();
        for (Pet pet : pets.values()) {
            if (pet.getPlayer().equals(player)) {
                playerPets.add(pet);
            }
        }
        return playerPets;
    }

    public Pet getPet(Player player, PetType petType) {
        Pet pet = pets.get(player);
        if (pet != null && pet.getPetType() == petType) {
            return pet;
        }
        return null;
    }

    public void removePet(Player player) {
        pets.remove(player);
    }
}
