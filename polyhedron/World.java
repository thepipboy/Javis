import static org.lwjgl.opengl.GL11.*;
import java.util.Random;

public class World {
    private static final int WORLD_SIZE = 16;
    private static final float BLOCK_SIZE = 1.0f;
    private Block[][][] blocks;
    private Random random;

    public World() {
        blocks = new Block[WORLD_SIZE][WORLD_SIZE][WORLD_SIZE];
        random = new Random();
        generateWorld();
    }

    private void generateWorld() {
        for (int x = 0; x < WORLD_SIZE; x++) {
            for (int y = 0; y < WORLD_SIZE; y++) {
                for (int z = 0; z < WORLD_SIZE; z++) {
                    if (y == 0) {
                        blocks[x][y][z] = new Cube(x * BLOCK_SIZE, y * BLOCK_SIZE, z * BLOCK_SIZE, 0.5f, 0.35f, 0.05f); // Brown for ground
                    } else if (random.nextFloat() < 0.05) {
                        blocks[x][y][z] = getRandomBlock(x * BLOCK_SIZE, y * BLOCK_SIZE, z * BLOCK_SIZE);
                    }
                }
            }
        }
    }

    private Block getRandomBlock(float x, float y, float z) {
        switch (random.nextInt(5)) {
            case 0: return new Cube(x, y, z, 0.0f, 0.8f, 0.0f);
            case 1: return new Tetrahedron(x, y, z, 0.8f, 0.0f, 0.0f);
            case 2: return new Octahedron(x, y, z, 0.0f, 0.0f, 0.8f);
            case 3: return new Dodecahedron(x, y, z, 0.8f, 0.8f, 0.0f);
            case 4: return new Icosahedron(x, y, z, 0.8f, 0.0f, 0.8f);
            default: return new Cube(x, y, z, 0.0f, 0.8f, 0.0f);
        }
    }

    public void render() {
        for (int x = 0; x < WORLD_SIZE; x++) {
            for (int y = 0; y < WORLD_SIZE; y++) {
                for (int z = 0; z < WORLD_SIZE; z++) {
                    if (blocks[x][y][z] != null) {
                        blocks[x][y][z].render();
                    }
                }
            }
        }
    }
}

