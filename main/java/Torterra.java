import java.awt.Rectangle;

public class Torterra extends GrassType {

    /**
     * Constructor
     * @param x The X position of Torterra
     * @param y The Y position of Torterra
     * @param bounds The bounding Rectangle
     */
    public Torterra(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/torterra.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {

        if (other instanceof GrassType) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2) {
            if (this.getLevel() >= 30) {
                if (this.getRand().nextInt(100) < 20) {
                    this.setChildren(this.getChildren() + 1);
                    other.setChildren(other.getChildren() + 1);
                    return new Torterra(other.getXPos(),
                                        other.getYPos(),
                                        other.getBounds());
                }
            }
        }
        return null;
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof GrassType) {
            if (this.getRand().nextInt(100) < 40) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (this.getRand().nextInt(100) < 30) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (other instanceof Poliwhirl) {
                if (this.getRand().nextInt(100) < 70) {
                    return true;
                }
            } else {
                if (this.getRand().nextInt(100) < 50) {
                    return true;
                }
            }
        } else {
            if (this.getRand().nextInt(100) < 60) {
                return true;
            }
        }

        return false;
    }


    @Override
    public boolean isOld() {
        if (this.getLevel() >= 100) {
            return true;
        }
        return false;
    }
}
