package tech.itexpress.pets;



import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

public enum PetType {
    DOG(EntityType.WOLF),
    CAT(EntityType.CAT),
    PARROT(EntityType.PARROT);

    private final EntityType entityType;

    PetType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Tameable spawnPet(Player player) {
        Tameable pet = (Tameable) player.getWorld().spawnEntity(player.getLocation(), entityType);
        pet.setTamed(true);
        pet.setOwner(player);
        return pet;
    }
}
