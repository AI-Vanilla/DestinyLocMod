
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
public class GhostlocationGuiWindow extends ContainerScreen<GhostlocationGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GhostlocationGui.guistate;
	public GhostlocationGuiWindow(GhostlocationGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 195;
	}
	private static final ResourceLocation texture = new ResourceLocation("destiny_loc:textures/ghostlocation.png");
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
		this.blit(ms, this.guiLeft + 194, this.guiTop + 137, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 25, this.guiTop + 153, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 27, this.guiTop + 107, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 350, this.guiTop + 75, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/posion_bad.png"));
		this.blit(ms, this.guiLeft + 26, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/posion_bad.png"));
		this.blit(ms, this.guiLeft + 329, this.guiTop + 142, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/primequest.png"));
		this.blit(ms, this.guiLeft + 93, this.guiTop + 24, 0, 0, 43, 44, 43, 44);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/golden_pickaxe.png"));
		this.blit(ms, this.guiLeft + 261, this.guiTop + 54, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Location", 180, 8, -12829636);
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
		this.addButton(new Button(this.guiLeft + 163, this.guiTop + 154, 75, 20, new StringTextComponent("OVER WORLD"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(0, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 10, this.guiTop + 169, 45, 20, new StringTextComponent("MARS"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(1, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 124, 55, 20, new StringTextComponent("EUROPA"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(2, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 322, this.guiTop + 92, 70, 20, new StringTextComponent("DEEP LAND"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(3, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 31, this.guiTop + 3, 50, 20, new StringTextComponent("Quest"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(4, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 112, this.guiTop + 3, 40, 20, new StringTextComponent("Map"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(5, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 245, this.guiTop + 3, 55, 20, new StringTextComponent("Season"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(6, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 19, this.guiTop + 49, 30, 20, new StringTextComponent("?"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(7, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 322, this.guiTop + 158, 30, 20, new StringTextComponent("?"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(8, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 79, this.guiTop + 62, 70, 20, new StringTextComponent("Legendary"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(9, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 246, this.guiTop + 70, 45, 20, new StringTextComponent("Moon"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(10, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 91, 70, 20, new StringTextComponent("THE TOWER"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostlocationGui.ButtonPressedMessage(11, x, y, z));
				GhostlocationGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
	}
}
