import static org.lwjgl.opengl.GL11.*;

public class Octahedron extends Block {
    private static final float SIZE = 0.5f;

    public Octahedron(float x, float y, float z, float r, float g, float b) {
        super(x, y, z, r, g, b);
    }

    @Override
    public void render() {
        beginRendering();

        // Top pyramid
        glVertex3f(0, SIZE, 0);
        glVertex3f(SIZE, 0, 0);
        glVertex3f(0, 0, SIZE);

        glVertex3f(0, SIZE, 0);
        glVertex3f(0, 0, SIZE);
        glVertex3f(-SIZE, 0, 0);

        glVertex3f(0, SIZE, 0);
        glVertex3f(-SIZE, 0, 0);
        glVertex3f(0, 0, -SIZE);

        glVertex3f(0, SIZE, 0);
        glVertex3f(0, 0, -SIZE);
        glVertex3f(SIZE, 0, 0);

        // Bottom pyramid
        glVertex3f(0, -SIZE, 0);
        glVertex3f(SIZE, 0, 0);
        glVertex3f(0, 0, SIZE);

        glVertex3f(0, -SIZE, 0);
        glVertex3f(0, 0, SIZE);
        glVertex3f(-SIZE, 0, 0);

        glVertex3f(0, -SIZE, 0);
        glVertex3f(-SIZE, 0, 0);
        glVertex3f(0, 0, -SIZE);

        glVertex3f(0, -SIZE, 0);
        glVertex3f(0, 0, -SIZE);
        glVertex3f(SIZE, 0, 0);

        endRendering();
    }
}

