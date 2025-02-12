import static org.lwjgl.opengl.GL11.*;

public abstract class Block {
    protected float x, y, z;
    protected float r, g, b;

    public Block(float x, float y, float z, float r, float g, float b) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public abstract void render();

    protected void beginRendering() {
        glPushMatrix();
        glTranslatef(x, y, z);
        glColor3f(r, g, b);
        glBegin(GL_TRIANGLES);
    }

    protected void endRendering() {
        glEnd();
        glPopMatrix();
    }
}

