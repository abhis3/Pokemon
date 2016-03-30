/**
 * A water type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class WaterType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Water Type Pokemon
     * @param y The Y position of this Water Type Pokemon
     * @param bounds The bounding Rectangle
     */
    public WaterType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public boolean canHarmPokemon(Pokemon other) {
        if (other instanceof WaterType) {
            if (this.getRand().nextInt(100) < 40) {
                return true;
            }
        } else if (other instanceof GrassType) {
            if (this.getRand().nextInt(100) < 20) {
                return true;
            }
        } else if (other instanceof FireType) {
            if (this.getRand().nextInt(100) < 50) {
                return true;
            }
        } else {
            if (this.getRand().nextInt(100) < 30) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void move() {
        if ((((this.getXPos()) >= 0)
            && ((this.getXPos() <= (getBounds().getWidth() / 2))))
            && (((this.getYPos()) >= (getBounds().getHeight() / 2))
            && ((this.getYPos() <= (getBounds().getHeight()))))) {
            this.setLevel(this.getLevel() + 2);
            super.move();
        } else {
            super.move();
        }
    }

}
