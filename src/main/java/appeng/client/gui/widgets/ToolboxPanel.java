/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2021, TeamAppliedEnergistics, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.client.gui.widgets;

import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;

import appeng.client.Point;
import appeng.client.gui.GuiWidget;
import appeng.client.gui.Tooltip;
import appeng.client.gui.style.Blitter;
import appeng.client.gui.style.ScreenStyle;
import appeng.core.localization.GuiText;

/**
 * A 3x3 toolbox panel attached to the player inventory.
 */
public class ToolboxPanel extends Container {

    // Backdrop for the 3x3 toolbox offered by the network-tool
    private final Blitter background;

    private final Component toolbeltName;

    public ToolboxPanel(ScreenStyle style, Component toolbeltName) {
        this.background = style.getImage("toolbox");
        this.toolbeltName = toolbeltName;
    }

    @Override
    public void drawBackgroundLayer(GuiGraphics guiGraphics, Rect2i bounds, Point mouse) {
        background.dest(
                bounds.getX() + this.getLayoutBounds().getX(),
                bounds.getY() + this.getLayoutBounds().getY(),
                this.getLayoutBounds().getWidth(),
                this.getLayoutBounds().getHeight()).blit(guiGraphics);
    }

    @Nullable
    @Override
    public Tooltip getTooltip(int mouseX, int mouseY) {
        return new Tooltip(
                this.toolbeltName,
                GuiText.UpgradeToolbelt.text().plainCopy().withStyle(ChatFormatting.GRAY));
    }

}
