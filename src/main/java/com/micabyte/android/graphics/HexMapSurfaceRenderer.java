/*
 * Copyright 2013 MicaByte Systems
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.micabyte.android.graphics;

import android.content.Context;
import android.graphics.Point;

import com.micabyte.android.map.HexMap;

/**
 * HexMapSurfaceRenderer is a renderer that handles the rendering of a Tiled
 * (hexagonal) map to the screen. The game should subclass the renderer and
 * extend the drawing methods to add other game elements.
 */
public class HexMapSurfaceRenderer extends SurfaceRenderer {
    // The HexMap object
    private HexMap gameSurfaceTileMap;

    public HexMapSurfaceRenderer(Context con) {
        super(con);
    }

    private static int getRenderWidth() {
        return ((HexMap.getMapWidth()) * HexMap.getTileRect().width()) - (HexMap.getTileRect().width() / 2);
    }

    private static int getRenderHeight() {
        return ((HexMap.getMapHeight() - 2) * (HexMap.getTileRect().height() - HexMap.getTileSlope())) + (HexMap.getTileSlope());
    }

    /**
     * Set the TileMap
     */
    public void setTileMap(HexMap map) {
        gameSurfaceTileMap = map;
        backgroundSize.set(getRenderWidth(), getRenderHeight());
    }

    @Override
    public void drawBase() {
        gameSurfaceTileMap.drawBase(context, viewPort);
    }

    @Override
    protected void drawLayer() {
        gameSurfaceTileMap.drawLayer(context, viewPort);
    }

    @Override
    protected void drawFinal() {
        gameSurfaceTileMap.drawFinal(context, viewPort);
    }

    @Override
    public void setMapPosition(int x, int y) {
        Point p = gameSurfaceTileMap.getViewPortOrigin(x, y, viewPort);
        super.setMapPosition(p.x, p.y);
    }

    @Override
    public void start() {
        // NOOP
    }

    @Override
    public void stop() {
        // NOOP
    }

    @Override
    public void suspend() {
        // NOOP
    }

    @Override
    public void resume() {
        // NOOP
    }

}
