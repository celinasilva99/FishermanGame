/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Fishes;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author cs
 */
public class Dolphin extends Fish {
    
         public Dolphin(World w){
        super(w);
        PolygonShape shape = new PolygonShape(-1.34f,1.17f, 1.32f,1.16f, 1.32f,-1.43f, -1.34f,-1.39f, -1.34f,1.15f);
         this.addImage(new BodyImage("data/dolphin.png",3.0f));// Image taken http://www.stickpng.com/img/animals/sea-animals/cartoon-dolphin
        SolidFixture fixture = new SolidFixture(this, shape);
      fixture.setRestitution(1);
       
}
}
