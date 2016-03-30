import java.awt.Rectangle;

public class Charizard extends FireType {

    /**
     * Constructor
     * @param x The X position of Charizard
     * @param y The Y position of Charizard
     * @param bounds The bounding Rectangle
     */
    public Charizard(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/charizard.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {

        if (other instanceof Charizard) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2) {
            if (this.getLevel() >= 30) {
                if (this.getRand().nextInt(100) < 24) {
                    this.setChildren(this.getChildren() + 1);
                    other.setChildren(other.getChildren() + 1);
                    return new Charizard(other.getXPos(),
                                         other.getYPos(),
                                         other.getBounds());
                }
            }
        }
        return null;
    }

    /*@Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof FireType) {
            if (this.getRand().nextInt(100) < 40) {
                return true;
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
    }*/

    @Override
    public boolean isOld() {
        if (this.getLevel() >= 130) {
            return true;
        }
        return false;
    }
}
