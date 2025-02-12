import static org.lwjgl.opengl.GL11.*;

public class Dodecahedron extends Block {
    private static final float PHI = 1.618033988749895f;
    private static final float SIZE = 0.3f;

    public Dodecahedron(float x, float y, float z, float r, float g, float b) {
        super(x, y, z, r, g, b);
    }

    @Override
    public void render() {
        beginRendering();

        float[][] vertices = {
            {-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
            {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1},
            {0, -PHI, -1/PHI}, {0, -PHI, 1/PHI}, {0, PHI, -1/PHI}, {0, PHI, 1/PHI},
            {-1/PHI, 0, -PHI}, {-1/PHI, 0, PHI}, {1/PHI, 0, -PHI}, {1/PHI, 0, PHI},
            {-PHI, -1/PHI, 0}, {-PHI, 1/PHI, 0}, {PHI, -1/PHI, 0}, {PHI, 1/PHI, 0}
        };

        int[][] faces = {
            {0, 8, 9, 4, 16}, {0, 12, 13, 1, 8}, {0, 16, 17, 2, 12},
            {1, 9, 5, 15, 13}, {1, 13, 3, 17, 16}, {2, 14, 15, 3, 12},
            {2, 17, 11, 10, 14}, {3, 15, 7, 19, 11}, {3, 11, 17, 16, 1},
            {4, 14, 10, 6, 18}, {4, 18, 5, 9, 8}, {5, 7, 15, 14, 4},
            {5, 18, 19, 7, 15}, {6, 10, 11, 19, 18}, {7, 19, 18, 6, 10}
        };

        for (int[] face : faces) {
            for (int i = 1; i < face.length - 1; i++) {
                glVertex3f(vertices[face[0]][0] * SIZE, vertices[face[0]][1] * SIZE, vertices[face[0]][2] * SIZE);
                glVertex3f(vertices[face[i]][0] * SIZE, vertices[face[i]][1] * SIZE, vertices[face[i]][2] * SIZE);
                glVertex3f(vertices[face[i+1]][0] * SIZE, vertices[face[i+1]][1] * SIZE, vertices[face[i+1]][2] * SIZE);
            }
        }

        endRendering();
    }
}

