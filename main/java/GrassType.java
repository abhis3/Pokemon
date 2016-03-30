/**
 * A grass type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class GrassType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof GrassType) {
            if (this.getRand().nextInt(100) < 40) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (this.getRand().nextInt(100) < 20) {
                return true;
            }
        } else if (other instanceof WaterType) {
            if (this.getRand().nextInt(100) < 50) {
                return true;
            }
        } else {
            if (this.getRand().nextInt(100) < 60) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void move() {
        if ((((this.getXPos()) >= 0)
            && ((this.getXPos() <= (getBounds().getWidth() / 2))))
            && (((this.getYPos()) >= 0)
            && ((this.getYPos() <= (getBounds().getHeight() / 2))))) {
            this.setHealth(this.getHealth() + 5);
            super.move();
        } else {
            super.move();
        }
    }
}
