package io.github.skyblockcore.gui.elements;

import io.github.skyblockcore.gui.TexturedGui;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ButtonElement extends GuiElement implements Interactable {

    final int offsetX, offsetY, normalX, normalY, hoverX, hoverY, clickX, clickY, sizeX, sizeY;
    final Identifier texture;

    public ButtonElement(int normalX, int normalY, int hoverX, int hoverY, int clickX, int clickY, int offsetX, int offsetY, int sizeX, int sizeY, Identifier texture) {
        this.normalX = normalX;
        this.normalY = normalY;
        this.hoverX = hoverX;
        this.hoverY = hoverY;
        this.clickX = clickX;
        this.clickY = clickY;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.texture = texture;
    }

    @Override
    public void render(MatrixStack matrices, int defaultX, int defaultY, int textureWidth, int textureHeight, int mouseX, int mouseY, boolean isMouseDown) {
        int actualX = defaultX + offsetX;
        int actualY = defaultY + offsetY;

        int textureX, textureY;
        if (mouseX < actualX+sizeX && mouseX > actualX
                && mouseY < actualY+sizeY && mouseY > actualY) {
            if (isMouseDown) {
                textureX = clickX;
                textureY = clickY;
            } else {
                textureX = hoverX;
                textureY = hoverY;
            }
        } else {
            textureX = normalX;
            textureY = normalY;
        }
        drawImage(matrices, actualX, actualY, textureX, textureY, sizeX, sizeY, sizeX, sizeY, textureWidth, textureHeight, texture);
    }

    @Override
    public int getScreenX(TexturedGui gui) {
        return gui.defaultX + offsetX;
    }

    @Override
    public int getScreenY(TexturedGui gui) {
        return gui.defaultY + offsetY;
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public void interact() {
        // do stuff
    }
}
