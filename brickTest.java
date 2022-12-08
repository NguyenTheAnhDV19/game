import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class brickTest {

    private brick underTest;
    private ball Ball;

    @BeforeEach
    void setUp(){
        underTest = new brick(Ball);
    }


    @Test
    void coordinates() {

    }

    @Disabled
    void draw() {
    }

    @Disabled
    void collide() {
    }

    @Disabled
    void remove() {
    }

    @Disabled
    void update() {
    }
}