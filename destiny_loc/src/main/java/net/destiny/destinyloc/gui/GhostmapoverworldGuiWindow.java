
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
public class GhostmapoverworldGuiWindow extends ContainerScreen<GhostmapoverworldGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GhostmapoverworldGui.guistate;

	public GhostmapoverworldGuiWindow(GhostmapoverworldGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 195;
	}

	private static final ResourceLocation texture = new ResourceLocation("destiny_loc:textures/ghostmapoverworld.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/apple.png"));
		this.blit(ms, this.guiLeft + 189, this.guiTop + 70, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 189, this.guiTop + 150, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 331, this.guiTop + 83, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/publicevent.png"));
		this.blit(ms, this.guiLeft + 211, this.guiTop + 33, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/publicevent.png"));
		this.blit(ms, this.guiLeft + 363, this.guiTop + 52, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/strike.png"));
		this.blit(ms, this.guiLeft + 54, this.guiTop + 47, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/strike.png"));
		this.blit(ms, this.guiLeft + 225, this.guiTop + 124, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/raid.png"));
		this.blit(ms, this.guiLeft + 347, this.guiTop + 97, 0, 0, 48, 48, 48, 48);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 17, this.guiTop + 20, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Map", 191, 10, -12829636);
		this.font.drawString(ms, "OVER WORLD", 174, 21, -12829636);
		this.font.drawString(ms, "MINING STOP", 201, 64, -12829636);
		this.font.drawString(ms, "POLLUTION", 350, 83, -12829636);
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
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + 3, 50, 20, new StringTextComponent("Quest"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(0, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 305, this.guiTop + 3, 55, 20, new StringTextComponent("Season"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(1, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 225, this.guiTop + 3, 65, 20, new StringTextComponent("Location"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(2, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 154, this.guiTop + 86, 85, 20, new StringTextComponent("INITIAL BASE"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(3, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 35, this.guiTop + 76, 65, 20, new StringTextComponent("PLANNING"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(4, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 224, this.guiTop + 156, 75, 20, new StringTextComponent("BATTLESHIP"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(5, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 330, this.guiTop + 145, 65, 20, new StringTextComponent("VALHALLA"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(6, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 0, this.guiTop + 36, 50, 20, new StringTextComponent("CLIFF"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(7, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 148, this.guiTop + 165, 75, 20, new StringTextComponent("BATTLESHIP"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(8, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 268, this.guiTop + 63, 95, 20, new StringTextComponent("DARK PERIPHERY"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostmapoverworldGui.ButtonPressedMessage(9, x, y, z));
				GhostmapoverworldGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
	}
}
