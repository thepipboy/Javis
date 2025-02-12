import static org.lwjgl.opengl.GL11.*;

public class Tetrahedron extends Block {
    private static final float SIZE = 1.0f;

    public Tetrahedron(float x, float y, float z, float r, float g, float b) {
        super(x, y, z, r, g, b);
    }

    @Override
    public void render() {
        beginRendering();

        // Base
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(SIZE / 2, 0.0f, SIZE * (float)Math.sqrt(3) / 2);

        // Side 1
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(SIZE / 2, 0.0f, SIZE * (float)Math.sqrt(3) / 2);
        glVertex3f(SIZE / 2, SIZE * (float)Math.sqrt(2.0/3.0), SIZE * (float)Math.sqrt(3) / 6);

        // Side 2
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(SIZE / 2, SIZE * (float)Math.sqrt(2.0/3.0), SIZE * (float)Math.sqrt(3) / 6);
        glVertex3f(SIZE / 2, 0.0f, SIZE * (float)Math.sqrt(3) / 2);

        // Side 3
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(SIZE / 2, SIZE * (float)Math.sqrt(2.0/3.0), SIZE * (float)Math.sqrt(3) / 6);
        glVertex3f(SIZE, 0.0f, 0.0f);

        endRendering();
    }
}

