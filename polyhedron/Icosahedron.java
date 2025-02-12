import static org.lwjgl.opengl.GL11.*;

public class Icosahedron extends Block {
    private static final float PHI = 1.618033988749895f;
    private static final float SIZE = 0.3f;

    public Icosahedron(float x, float y, float z, float r, float g, float b) {
        super(x, y, z, r, g, b);
    }

    @Override
    public void render() {
        beginRendering();

        float[][] vertices = {
            {0, -1, PHI}, {0, 1, PHI}, {0, -1, -PHI}, {0, 1, -PHI},
            {PHI, 0, -1}, {PHI, 0, 1}, {-PHI, 0, -1}, {-PHI, 0, 1},
            {-1, PHI, 0}, {1, PHI, 0}, {-1, -PHI, 0}, {1, -PHI, 0}
        };

        int[][] faces = {
            {0, 1, 5}, {0, 5, 11}, {0, 11, 10}, {0, 10, 7}, {0, 7, 1},
            {1, 7, 8}, {1, 8, 9}, {1, 9, 5},
            {2, 3, 4}, {2, 4, 11}, {2, 11, 10}, {2, 10, 6}, {2, 6, 3},
            {3, 6, 8}, {3, 8, 9}, {3, 9, 4},
            {4, 9, 5}, {4, 5, 11},
            {6, 10, 7}, {6, 7, 8}
        };

        for (int[] face : faces) {
            glVertex3f(vertices[face[0]][0] * SIZE, vertices[face[0]][1] * SIZE, vertices[face[0]][2] * SIZE);
            glVertex3f(vertices[face[1]][0] * SIZE, vertices[face[1]][1] * SIZE, vertices[face[1]][2] * SIZE);
            glVertex3f(vertices[face[2]][0] * SIZE, vertices[face[2]][1] * SIZE, vertices[face[2]][2] * SIZE);
        }

        endRendering();
    }
}

