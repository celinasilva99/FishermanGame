/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author cs
 */
public class Treasure extends StaticBody {
    

    
     private static final PolygonShape shape = new PolygonShape(-1.34f,0.83f, 0.0f,1.49f, 1.37f,1.06f, 1.17f,-1.44f, -1.06f,-1.35f, -1.34f,0.8f);
        Fixture fixture = new SolidFixture(this, shape);
        private static final BodyImage image = 
        new BodyImage("data/treasure.png",2.0f);
       
        public Treasure(World w){
        super (w);
        addImage(image);
        }
}
    
    
    
    

