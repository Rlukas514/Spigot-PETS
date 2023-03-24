package tech.itexpress.pets;


import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

public class Pet {
    private Player player;
    private PetType petType;
    private Tameable entity;

    public Pet(Player player, PetType petType, Tameable entity) {
        this.player = player;
        this.petType = petType;
        this.entity = entity;
    }

    public Player getPlayer() {
        return player;
    }

    public PetType getPetType() {
        return petType;
    }

    public Tameable getEntity() {
        return entity;
    }
}
