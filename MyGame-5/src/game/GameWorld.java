///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package game;
//
//import city.cs.engine.Body;
//import city.cs.engine.BoxShape;
//import city.cs.engine.Shape;
//import city.cs.engine.StaticBody;
//import city.cs.engine.World;
//import game.Fishes.Dolphin;
//import game.Fishes.Fish;
//import game.Fishes.MainFish;
//import game.Fishes.Octopus;
//import game.Fishes.RedFish;
//import game.Fishes.Shark;
////import game.MouseMover;
//import static java.awt.Color.blue;
//import org.jbox2d.common.Vec2;
//
///**
// *
// * @author cs
// */
//public class GameWorld extends World {
//
//    private Fish fish;
//    private Shark s;
//    private Hook hook;
//    private Hook MainFish;
//    private Hook Hook;
//    private MainFish m;
//
//    public GameWorld() {
//        super();
////         // make the ground
//        Shape shape = new BoxShape(20f, 0.1f);
//        Body ground = new StaticBody(this, shape);
//        ground.setPosition(new Vec2(0, -20f));
//        ground.setFillColor(blue);
//
//        // make a platform
//        Shape wallShape = new BoxShape(0.1f, 20f);
//        Body leftWall = new StaticBody(this, wallShape);
//        leftWall.setPosition(new Vec2(20, 0f));
//        Body rightWall = new StaticBody(this, wallShape);
//        rightWall.setPosition(new Vec2(-20f, 0f));
//
//        Shape shape1 = new BoxShape(20f, 0.1f);
//        Body ceiling = new StaticBody(this, shape);
//        ceiling.setPosition(new Vec2(0, 20f));
//        ceiling.setFillColor(blue);
//
//        int max = 20;
//        int min = -20;
//        int range = (max - min) + min;
//
//       for(int i = 0; i<5;i++){
//            
//            int c = (int)(Math.random()* ((max-min))+min);
//            int g = (int)(Math.random()* ((max-min))+min);
//            int a = (int)(Math.random()* ((max-min))+min);
//            int b = (int)(Math.random()* ((max-min))+min);
//            int x = (int)(Math.random()* ((max-min))+min);
//                Dolphin d = new Dolphin(this);
//                d.setPosition(new Vec2(x,c));
//                d.setLinearVelocity(new Vec2(-2,0));
//                d.setGravityScale(0);
//      
//                RedFish r = new RedFish(this);
//                r.setPosition(new Vec2(c,g));
//                r.setLinearVelocity(new Vec2(8,-7));
//                r.setGravityScale(0);
//      
//                Octopus o = new Octopus(this);
//                o.setPosition(new Vec2(g,x));
//                o.setLinearVelocity(new Vec2(2,7));
//                o.setGravityScale(0);
//
//                Treasure t = new Treasure(this);
//                t.setPosition(new Vec2(a,c));
//               // t.setAngularVelocity(5);
//                //t.setGravityScale(0);
//                t.addCollisionListener(new Pickup(hook, this));
//       }
//       
//
//            int a = (int) (Math.random() * ((max - min)) + min);
//            int b = (int) (Math.random() * ((max - min)) + min);
//            s = new Shark(this);
//            s.setPosition(new Vec2(a, b));
//            s.setLinearVelocity(new Vec2(2, 0));
//            s.setAngularVelocity(5);
//            s.setGravityScale(0);
//            // s.addCollisionListener(new Pickup(hook,this));
//
//
//        for (int i = 0; i < 4; i++) {
//            int e = (int) (Math.random() * ((max - min)) + min);
//            int f = (int) (Math.random() * ((max - min)) + min);
//            m = new MainFish(this, s);
//            m.setPosition(new Vec2(e, f));
//            m.addCollisionListener(new Pickup(hook, this));
//            m.addCollisionListener(new SharkCollision(s, this, m));
//            m.setLinearVelocity(new Vec2(3, 2));
//            m.setGravityScale(0);
//        }
//
//    }
//
//    public Hook getPlayer() {
//        return hook;
//    }
//}
//// add more bodies here
//
