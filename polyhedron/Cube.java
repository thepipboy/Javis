import static org.lwjgl.opengl.GL11.*;

public class Cube extends Block {
    private static final float SIZE = 1.0f;

    public Cube(float x, float y, float z, float r, float g, float b) {
        super(x, y, z, r, g, b);
    }

    @Override
    public void render() {
        beginRendering();

        // Front face
        glVertex3f(0.0f, 0.0f, SIZE);
        glVertex3f(SIZE, 0.0f, SIZE);
        glVertex3f(SIZE, SIZE, SIZE);
        glVertex3f(0.0f, 0.0f, SIZE);
        glVertex3f(SIZE, SIZE, SIZE);
        glVertex3f(0.0f, SIZE, SIZE);

        // Back face
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, SIZE, 0.0f);
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(0.0f, SIZE, 0.0f);
        glVertex3f(SIZE, SIZE, 0.0f);

        // Top face
        glVertex3f(0.0f, SIZE, 0.0f);
        glVertex3f(0.0f, SIZE, SIZE);
        glVertex3f(SIZE, SIZE, SIZE);
        glVertex3f(0.0f, SIZE, 0.0f);
        glVertex3f(SIZE, SIZE, SIZE);
        glVertex3f(SIZE, SIZE, 0.0f);

        // Bottom face
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(SIZE, 0.0f, SIZE);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(SIZE, 0.0f, SIZE);
        glVertex3f(0.0f, 0.0f, SIZE);

        // Right face
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(SIZE, SIZE, 0.0f);
        glVertex3f(SIZE, SIZE, SIZE);
        glVertex3f(SIZE, 0.0f, 0.0f);
        glVertex3f(SIZE, SIZE, SIZE);
        glVertex3f(SIZE, 0.0f, SIZE);

        // Left face
        glVertex3f(0.0f, 0.0f, SIZE);
        glVertex3f(0.0f, SIZE, SIZE);
        glVertex3f(0.0f, SIZE, 0.0f);
        glVertex3f(0.0f, 0.0f, SIZE);
        glVertex3f(0.0f, SIZE, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);

        endRendering();
    }
}

