/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Fishes;

import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author cs
 */
public class RedFish extends Fish {
    public RedFish (World w){
        super(w);
    PolygonShape red = new PolygonShape(-1.35f,1.46f, 1.33f,1.46f, 1.34f,-1.44f, -1.32f,-1.42f, -1.35f,1.44f);
        SolidFixture fixture = new SolidFixture(this,red);
        this.addImage(new BodyImage("data/red.png",3.0f));//http://moziru.com/explore/Goldfish%20clipart%20red%20fish/#go_post_3025_seafood-clipart-cartoon-1.png
        fixture.setRestitution(1);
    }
}