package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    private Background b;
    private UserView view;
    private int level;
    private SoundClip music;
    private JFrame frame;
    private JFrame frame2;

    /**
     * Initialise a new Game.
     */
    public Game() {
        
        /**
         * level 1 in the game
         */
        level = 1;
        world = new LevelOne();
        /**
         * Populate the world with {@link LevelOne}
         */
        world.populate(this);
        /**
         * BackGround music for level 1
         */
        try {
            music = new SoundClip("data/DST-Glory.mp3");   // Open an audio input stream
            music.loop();  // Set it to continous playback (looping)

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        
       // JFrame debugView = new DebugViewer(world, 500, 500);
      
        
        /**
         * Display the {@link Background}
         */
view = new Background(world, world.getPlayer(), 800, 800,new ImageIcon("data/background.jpg").getImage());
        

    
        /**
         * A graphical display of the world (a specialised JPanel).
         */
          
           frame2();
           frame();
        
       
      
        /**
         * Move the mouse to move the player {@link HookMover}
         */
        view.addMouseMotionListener(new Hookmover(view, world.getPlayer()));
        
        
       
    }

    /**
     *
     * @return the player
     */
    public Hook getPlayer() {
        return world.getPlayer();
    }

    /**
     * Stop the game
     */
    public void pause() {
        world.stop();
    }

    /**
     * Restart the game
     */
    public void restart() {
        world.start();

    }

    /**
     * Stop the game
     */
    public void stop() {
        world.stop();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JFrame getFrame2() {
        return frame2;
    }

    /**
     * Stop the music
     */
    public void mute() {
        music.stop();
    }

    /**
     * Play the music
     */
    public void play() {
        music.play();
    }

    /**
     *
     * @return level completed.
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     *
     * @return Treasure count.
     */
    public boolean isTreasureCollected() {
        return world.treasureCount();

    }
       
        
        public void frame2(){
                /**
         * A graphical display of the world (a specialised JPanel).
         */
         frame2 = new JFrame("Basic world");

        Container buttons = new ControlPanel(this);
        // quit the application when the game window is closed
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(buttons, BorderLayout.WEST);
        frame2.setLocationByPlatform(true);
        // display the world in the window
        
        frame2.add(view);
        // don't let the game window be resized
        frame2.setResizable(false);

        // size the game window to fit the world view
        frame2.pack();
        // make the window visible
        frame2.setVisible(false);
        
        }
        public void frame(){
        frame = new JFrame("menu");
        MenuPanel menuPanel = new MenuPanel(world, this);
        frame.add(menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
      
        }
    
        

    /**
     * Go to the next level
     */
    public void goNextLevel() {
        world.stop();
        if (level == 5) {
            System.exit(0);
        } else {
            level++;

            if (level == 2) {
                world = new LevelTwo();
//                frame2.remove(view);
//                view = new Background(world,world.getPlayer(),400,400,new ImageIcon("data/Unknown.jpeg").getImage());
//                frame2.add(view);
                
                SwingUtilities.updateComponentTreeUI(frame2);
                
                /**
                 * Background music for level 2
                 */

                try {
                    music = new SoundClip("data/level2.mp3");   // Open an audio input stream
                    music.loop();  // Set it to continous playback (looping)

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }

            }
            if (level == 3) {
                world = new LevelThree();
                /**
                 * Background music for level 3
                 */
                try {
                    music = new SoundClip("data/level3.mp3");   // Open an audio input stream
                    music.loop();  // Set it to continous playback (looping)

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }

            }
            if (level == 4) {
                world = new LevelFour();
                /**
                 * Background music for level 4
                 */
                try {
                    music = new SoundClip("data/level4.mp3");   // Open an audio input stream
                    music.loop();  // Set it to continous playback (looping)

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }
            }
            if (level == 5) {
                world = new LevelFive();

                /**
                 * Background music for level 5
                 */
                try {
                    music = new SoundClip("data/level5.mp3");   // Open an audio input stream
                    music.loop();  // Set it to continous playback (looping)

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }

            }

            world.populate(this);

            view.setWorld(world);

            view.addMouseMotionListener(new Hookmover(view, world.getPlayer()));

            ((Background) view).setPlayer(world.getPlayer());

            world.start();
        }
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }

    void setVisible(boolean b) {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
