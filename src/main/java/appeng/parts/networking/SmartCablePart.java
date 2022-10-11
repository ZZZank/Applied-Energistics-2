/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
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

package appeng.parts.networking;

import appeng.api.networking.IGridNodeListener;
import appeng.items.parts.ColoredPartItem;
import appeng.parts.networking.cableshapes.CoveredCableShape;
import appeng.parts.networking.cableshapes.ICableShape;

public class SmartCablePart extends CablePart implements IUsedChannelProvider {
    public SmartCablePart(ColoredPartItem<?> partItem) {
        super(partItem);
    }

    /**
     * Send info about changed channels/power to client to update the on-cable display of channels/power.
     */
    @Override
    protected void onMainNodeStateChanged(IGridNodeListener.State reason) {
        if (reason != IGridNodeListener.State.GRID_BOOT) {
            this.getHost().markForUpdate();
        }
    }

    @Override
    public ICableShape getCableShape() {
        return CoveredCableShape.SMART;
    }

}
