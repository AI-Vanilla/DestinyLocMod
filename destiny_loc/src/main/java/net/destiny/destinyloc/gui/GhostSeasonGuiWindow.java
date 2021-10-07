
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
public class GhostSeasonGuiWindow extends ContainerScreen<GhostSeasonGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GhostSeasonGui.guistate;
	public GhostSeasonGuiWindow(GhostSeasonGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 195;
	}
	private static final ResourceLocation texture = new ResourceLocation("destiny_loc:textures/ghost_season.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("destiny_loc:textures/season1.png"));
		this.blit(ms, this.guiLeft + -138, this.guiTop + -63, 0, 0, 664, 352, 664, 352);
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
		this.font.drawString(ms, "SEASON OF ENVOY", 155, 131, -12829636);
		this.font.drawString(ms, "Season", 181, 8, -12829636);
		this.font.drawString(ms, "7/31 - 11/30", 162, 143, -12829636);
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
		this.addButton(new Button(this.guiLeft + 22, this.guiTop + 3, 50, 20, new StringTextComponent("Quest"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostSeasonGui.ButtonPressedMessage(0, x, y, z));
				GhostSeasonGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 263, this.guiTop + 3, 65, 20, new StringTextComponent("Location"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostSeasonGui.ButtonPressedMessage(1, x, y, z));
				GhostSeasonGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 106, this.guiTop + 3, 40, 20, new StringTextComponent("Map"), e -> {
			if (true) {
				DestinyLocMod.PACKET_HANDLER.sendToServer(new GhostSeasonGui.ButtonPressedMessage(2, x, y, z));
				GhostSeasonGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
