/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Fishes;

import game.Fishes.Fish;
import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import game.Game;

/**
 *
 * @author cs
 */
public class Shark extends Fish{
    public Shark(World w){
        super(w);
        
        PolygonShape shark = new PolygonShape(-1.34f,1.48f, 1.37f,1.48f, 1.37f,-1.42f, -1.34f,-1.41f, -1.34f,1.46f);
        SolidFixture fixture = new SolidFixture(this, shark);
        fixture.setRestitution(1);
        this.addImage(new BodyImage("data/shark.png",6.0f));//https://pugwizer.deviantart.com/art/Cartoon-Shark-426757317
       
       
}
}

//    public Shark(Game game) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

