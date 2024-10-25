package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;
	public static Image treeSprite;
	public static Image backgroundImage;
	public static Image backgroundImage2;
	public static Image golfBall;
	public static Image rockSprite;
	public static Image waterSprite;
	public static AudioClip hitSound;
	public static AudioClip clickSound;
	public static AudioClip treeHit;
	public static AudioClip rockHit;
	public static AudioClip puttSound;
	public static AudioClip failSound;
	public static AudioClip successSound;
	public static AudioClip waterBloopSound;
	public static Media backgroundMusic;
	public static int gameWidth = 800 ;
	public static int gameHeight = 640;
	public static int topGameHeight = 75 ;
	public static int golfCourseHeight = 565;
	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public void setEntities(List<IRenderable> entities) {
		this.entities = entities;
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		mapSprite = new Image(ClassLoader.getSystemResource("Grasses.png").toString());
		treeSprite = new Image(ClassLoader.getSystemResource("tree.png").toString());
		rockSprite = new Image(ClassLoader.getSystemResource("rock.png").toString());
		waterSprite = new Image(ClassLoader.getSystemResource("water.png").toString());
		golfBall = new Image(ClassLoader.getSystemResource("golfBall.png").toString());
		hitSound = new AudioClip(ClassLoader.getSystemResource("hitsound.mp3").toString());
		treeHit = new AudioClip(ClassLoader.getSystemResource("treehit.mp3").toString());
		puttSound = new AudioClip(ClassLoader.getSystemResource("puttsound.mp3").toString());
		rockHit = new AudioClip(ClassLoader.getSystemResource("rockhit.mp4").toString());
		backgroundImage = new Image(ClassLoader.getSystemResource("bgi2.jpg").toString());
		backgroundImage2 = new Image(ClassLoader.getSystemResource("bgi1.jpg").toString());
		clickSound = new AudioClip(ClassLoader.getSystemResource("clicksound.mp3").toString());
		failSound = new AudioClip(ClassLoader.getSystemResource("failsound.mp3").toString());
		successSound = new AudioClip(ClassLoader.getSystemResource("successsound.mp3").toString());
		waterBloopSound = new AudioClip(ClassLoader.getSystemResource("waterbloop.mp3").toString());
		backgroundMusic = new Media(ClassLoader.getSystemResource("backgroundMusic.mp3").toString());
	}

	public static void playBackgroundMusic() {
		MediaPlayer mediaPlayer = new MediaPlayer(backgroundMusic);
		mediaPlayer.setVolume(0.05);
		mediaPlayer.play();
		mediaPlayer.setOnEndOfMedia(() -> {
			playBackgroundMusic();
		});
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
