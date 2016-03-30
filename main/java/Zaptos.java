import java.awt.Rectangle;

public class Zaptos extends ElectricType {

    /**
     * Constructor
     * @param x The X position of Zaptos
     * @param y The Y position of Zaptos
     * @param bounds The bounding Rectangle
     */
    public Zaptos(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage("../resources/zaptos.png");
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon other) {

        if (other instanceof Zaptos) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon other) {
        if (this.getChildren() < 2) {
            if (this.getLevel() >= 30) {
                if (this.getRand().nextInt(100) < 22) {
                    this.setChildren(this.getChildren() + 1);
                    other.setChildren(other.getChildren() + 1);
                    return new Zaptos(other.getXPos(),
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
            if (other instanceof Charizard) {
                if (this.getRand().nextInt(100) < 40) {
                    return true;
                }
            } else {
                if (this.getRand().nextInt(100) < 60) {
                    return true;
                }
            }
        } else if (other instanceof WaterType) {
            if (this.getRand().nextInt(100) < 70) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (this.getRand().nextInt(100) < 30) {
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
        if (this.getLevel() >= 120) {
            return true;
        }
        return false;
    }
}
