/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Fishes;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author cs
 */
public class Octopus extends Fish{
     public Octopus (World w){
        super(w);
       PolygonShape octopus = new PolygonShape(-1.34f,1.48f, 1.34f,1.49f, 1.32f,-1.45f, -1.35f,-1.46f, -1.35f,1.45f);
        SolidFixture fixture = new SolidFixture(this, octopus);
        this.addImage(new BodyImage("data/octopus.png",3.0f));// http://www.pngmart.com/image/40893
        fixture.setRestitution(1);
}
}
