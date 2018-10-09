package game;

import city.cs.engine.*;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 */
public class Hook extends StaticBody {

    /**
     * a variable sharkSound of type SoundClip
     */
    private static SoundClip sharkSound;
    /**
     * a variable fairySound of type SoundClip
     */
    private static SoundClip fairySound;
    /**
     * a variable crabSound of type SoundClip
     */
    private static SoundClip crabSound;

    /**
     * Creates a new sharkSound of type SoundClip
     */
    static {
        try {
            sharkSound = new SoundClip("data/boom.mp3");
            System.out.println("Loading shark sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        /**
         * Creates a new fairySound of type SoundClip
         */
        try {
            fairySound = new SoundClip("data/fairy.mp3");
            System.out.println("Loading fairy sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        /**
         * Creates a new crabSound of type SoundClip
         */
        try {
            crabSound = new SoundClip("data/crab.mp3");
            System.out.println("Loading crab sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * a variable hookShape of type shape
     *
     */
    private static final Shape hookShape = new PolygonShape(0.35f, 1.45f, 0.86f, -0.15f, 0.14f, -1.38f, -0.67f, -1.25f, -0.83f, -0.12f);
    /**
     * a variable hookImage of type BodyImage
     */
    private static final BodyImage hookImage
            = new BodyImage("data/net.png", 10);//http://laoblogger.com/net-clipart-images.html#

    /**
     * Construct a Hook.
     */
    private int fishCount;
    private int treasureCount;
    private int score;
    private int liveCount;
    Background b;

    /*
      @param world the world in which this body exists.
     */
    public Hook(World world) {
        super(world, hookShape);
        /**
         * Add the image of the hook to the world
         */
        addImage(hookImage);
        /**
         * Initial fishCount
         */
        fishCount = 0;
        /**
         * Initial TreasureCount
         */
        treasureCount = 0;
        /**
         * The number of lives available
         */
        liveCount = 3;

    }

    /**
     * the current count of fishes collected
     */
    public int getFishCount() {
        return fishCount;
    }

    /**
     * Increases the number of fishes collected
     */
    public void incrementFishCount() {
        fishCount = fishCount + 1;
        System.out.println("Fish Collected = " + fishCount);

    }

    /**
     * the current count of treasures collected
     */
    public int getTreasureCount() {
        return treasureCount;
    }

    /**
     * Increases the number of treasure
     */
    public void incrementTreasureCount() {
        treasureCount = treasureCount + 1;
        System.out.println("Treasure Collected = " + treasureCount);
    }

    /**
     * the current count of lives left
     */

    public int getliveCount() {
        return liveCount;
    }

    /**
     * Decreases the number of lives left
     */
    public void decrementLiveCount() {
        liveCount = liveCount - 1;
        System.out.println("Oh no!  Lives Remaining = " + liveCount);

    }

    /**
     * The player gains a life.
     */
    public void gainLife() {
        liveCount = liveCount + 1;
        System.out.println("Woop woop!! Gained a life = " + liveCount);

    }

    @Override
    /**
     * Plays the SoundClip of sharkSound
     */
    public void destroy() {
        sharkSound.play();
        // super.destroy();
    }

    /**
     * Plays the SoundClip of fairySound
     */
    public void destroy1() {
        fairySound.play();
        // super.destroy();
    }

    /**
     * Plays the SoundClip of crabSound
     */
    public void destroy2() {
        crabSound.play();
        // super.destroy();
    }
//public void mute(){
//    sharkSound.stop();
//    fairySound.stop();
//    crabSound.stop();
//}
}
