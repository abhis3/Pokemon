import java.awt.Rectangle;

public class Blaziken extends FireType {

    /**
     * Constructor
     * @param x The X position of Blaziken
     * @param y The Y position of Blaziken
     * @param bounds The bounding Rectangle
     */
    public Blaziken(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/blaziken.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {

        if (other instanceof Blaziken) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2) {
            if (this.getLevel() >= 30) {
                if (this.getRand().nextInt(100) < 25) {
                    this.setChildren(this.getChildren() + 1);
                    other.setChildren(other.getChildren() + 1);
                    return new Blaziken(other.getXPos(),
                                        other.getYPos(),
                                        other.getBounds());
                }
            }
        }
        return null;
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof FireType) {
            if (this.getLevel() > other.getLevel()) {
                if (this.getRand().nextInt(100) < 90) {
                    return true;
                }
            } else {
                if (this.getRand().nextInt(100) < 12) {
                    return true;
                }
            }

        } else if (other instanceof WaterType) {
            if (this.getRand().nextInt(100) < 20) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (this.getRand().nextInt(100) < 50) {
                return true;
            }
        } else {
            if (this.getRand().nextInt(100) < 40) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isOld() {
        if (this.getLevel() >= 150) {
            return true;
        }
        return false;
    }
}
