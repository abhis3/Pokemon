/**
 * A fire type pokemon
 *
 * @author Farhan Tejani
 */

import java.awt.Rectangle;

public abstract class FireType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Fire type
     * @param y The Y position of this Fire type
     * @param bounds The bounding Rectangle
     */
    public FireType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
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
    }

    @Override
    public void move() {
        if ((((this.getXPos()) >= (getBounds().getWidth() / 2)
            && ((this.getXPos() <= getBounds().getWidth()))))
            && (((this.getYPos()) >= 0)
            && ((this.getYPos() <= (getBounds().getHeight() / 2))))) {
            this.setSpeed(this.getSpeed() + 30);
            super.move();
            this.setSpeed(this.getSpeed() - 30);
        } else {
            super.move();
        }

    }
}
