
package net.destiny.destinyloc.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.destiny.destinyloc.DestinyLocMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GhostGuiWindow extends ContainerScreen<GhostGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GhostGui.guistate;

	public GhostGuiWindow(GhostGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 136;
		this.ySize = 176;
	}

	private static final ResourceLocation texture = new ResourceLocation("destiny_loc:textures/ghost.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Welcome Light our Craft", 9, 20, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 35, this.guiTop + 76, 65, 20, new StringTextComponent("Location"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostGui.ButtonPressedMessage(0, x, y, z));
				GhostGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 98, 40, 20, new StringTextComponent("Map"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostGui.ButtonPressedMessage(1, x, y, z));
				GhostGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 54, 50, 20, new StringTextComponent("Quest"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostGui.ButtonPressedMessage(2, x, y, z));
				GhostGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 39, this.guiTop + 120, 55, 20, new StringTextComponent("Season"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostGui.ButtonPressedMessage(3, x, y, z));
				GhostGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
