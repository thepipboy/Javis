import static org.lwjgl.opengl.GL11.*;

public class World {
    private static final int WORLD_SIZE = 16;
    private static final int BLOCK_SIZE = 1;

    public void render() {
        glPushMatrix();
        for (int x = 0; x < WORLD_SIZE; x++) {
            for (int y = 0; y < WORLD_SIZE; y++) {
                for (int z = 0; z < WORLD_SIZE; z++) {
                    if (y == 0) {
                        renderCube(x * BLOCK_SIZE, y * BLOCK_SIZE, z * BLOCK_SIZE, 0.5f, 0.35f, 0.05f); // Brown for ground
                    } else if (Math.random() < 0.05) {
                        renderCube(x * BLOCK_SIZE, y * BLOCK_SIZE, z * BLOCK_SIZE, 0.0f, 0.8f, 0.0f); // Green for trees
                    }
                }
            }
        }
        glPopMatrix();
    }

    private void renderCube(float x, float y, float z, float r, float g, float b) {
        glPushMatrix();
        glTranslatef(x, y, z);
        glColor3f(r, g, b);
        glBegin(GL_QUADS);
        
        // Front face
        glVertex3f(0.0f, 0.0f, BLOCK_SIZE);
        glVertex3f(BLOCK_SIZE, 0.0f, BLOCK_SIZE);
        glVertex3f(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        glVertex3f(0.0f, BLOCK_SIZE, BLOCK_SIZE);

        // Back face
        glVertex3f(BLOCK_SIZE, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, BLOCK_SIZE, 0.0f);
        glVertex3f(BLOCK_SIZE, BLOCK_SIZE, 0.0f);

        // Top face
        glVertex3f(0.0f, BLOCK_SIZE, 0.0f);
        glVertex3f(0.0f, BLOCK_SIZE, BLOCK_SIZE);
        glVertex3f(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        glVertex3f(BLOCK_SIZE, BLOCK_SIZE, 0.0f);

        // Bottom face
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(BLOCK_SIZE, 0.0f, 0.0f);
        glVertex3f(BLOCK_SIZE, 0.0f, BLOCK_SIZE);
        glVertex3f(0.0f, 0.0f, BLOCK_SIZE);

        // Right face
        glVertex3f(BLOCK_SIZE, 0.0f, 0.0f);
        glVertex3f(BLOCK_SIZE, BLOCK_SIZE, 0.0f);
        glVertex3f(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        glVertex3f(BLOCK_SIZE, 0.0f, BLOCK_SIZE);

        // Left face
        glVertex3f(0.0f, 0.0f, BLOCK_SIZE);
        glVertex3f(0.0f, BLOCK_SIZE, BLOCK_SIZE);
        glVertex3f(0.0f, BLOCK_SIZE, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);

        glEnd();
        glPopMatrix();
    }
}