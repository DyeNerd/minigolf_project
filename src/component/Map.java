package component;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private List<Entity> objectContainer;

	public Map() {
		objectContainer = new ArrayList<Entity>();
	}

	public ArrayList<Entity> buildMap1() {
		Tree tree, tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, tree10, tree11, tree12;
		Rock rock, rock1, rock2, rock3, rock4, rock5, rock6, rock7;
		Water water;

		water = new Water(500, 80);

		tree = new Tree(200, 400);
		tree1 = new Tree(400, 400);
		tree2 = new Tree(200, 200);
		tree3 = new Tree(200, 240);
		tree4 = new Tree(640, 200);
		tree5 = new Tree(300, 200);
		tree6 = new Tree(300, 350);
		tree7 = new Tree(300, 40);
		tree8 = new Tree(300, 80);
		tree9 = new Tree(80, 340);
		tree10 = new Tree(40, 300);
		tree11 = new Tree(500, 300);
		tree12 = new Tree(600, 160);

		rock = new Rock(300, 300);
		rock1 = new Rock(10, 10);
		rock2 = new Rock(600, 200);
		rock3 = new Rock(400, 200);
		rock4 = new Rock(150, 100);
		rock5 = new Rock(100, 150);
		rock6 = new Rock(100, 420);
		rock7 = new Rock(250, 400);

		objectContainer.add(tree);
		objectContainer.add(tree1);
		objectContainer.add(tree2);
		objectContainer.add(tree3);
		objectContainer.add(tree4);
		objectContainer.add(tree5);
		objectContainer.add(tree6);
		objectContainer.add(tree7);
		objectContainer.add(tree8);
		objectContainer.add(tree9);
		objectContainer.add(tree10);
		objectContainer.add(tree11);
		objectContainer.add(tree12);

		objectContainer.add(rock);
		objectContainer.add(rock1);
		objectContainer.add(rock2);
		objectContainer.add(rock3);
		objectContainer.add(rock4);
		objectContainer.add(rock5);
		objectContainer.add(rock6);
		objectContainer.add(rock7);

		objectContainer.add(water);
		return (ArrayList<Entity>) objectContainer;
	}

	public ArrayList<Entity> buildMap2() {
		Tree tree, tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, tree10, tree11, tree12;
		Rock rock, rock1, rock2, rock3, rock4, rock5, rock6, rock7, rock8, rock9, rock10;
		Water water, water1, water2;

		water = new Water(650, 100);
		water1 = new Water(100, 500);
		water2 = new Water(660, 500);

		tree = new Tree(200, 400);
		tree1 = new Tree(400, 400);
		tree2 = new Tree(440, 160);
		tree3 = new Tree(300, 500);
		tree4 = new Tree(300, 100);
		tree5 = new Tree(230, 470);
		tree6 = new Tree(520, 60);
		tree7 = new Tree(60, 400);
		tree8 = new Tree(360, 360);
		tree9 = new Tree(600, 460);
		tree10 = new Tree(570, 490);
		tree11 = new Tree(580, 530);
		tree12 = new Tree(720, 460);

		rock = new Rock(300, 300);
		rock1 = new Rock(420, 300);
		rock2 = new Rock(430, 260);
		rock3 = new Rock(460, 230);
		rock4 = new Rock(500, 220);
		rock5 = new Rock(430, 340);
		rock6 = new Rock(460, 370);
		rock7 = new Rock(500, 380);
		rock8 = new Rock(540, 230);
		rock9 = new Rock(540, 360);
		rock10 = new Rock(360, 160);

		objectContainer.add(water);
		objectContainer.add(water1);
		objectContainer.add(water2);
		objectContainer.add(tree);
		objectContainer.add(tree1);
		objectContainer.add(tree2);
		objectContainer.add(tree3);
		objectContainer.add(tree4);
		objectContainer.add(tree5);
		objectContainer.add(tree6);
		objectContainer.add(tree7);
		objectContainer.add(tree8);
		objectContainer.add(tree9);
		objectContainer.add(tree10);
		objectContainer.add(tree11);
		objectContainer.add(tree12);
		objectContainer.add(rock);
		objectContainer.add(rock1);
		objectContainer.add(rock2);
		objectContainer.add(rock3);
		objectContainer.add(rock4);
		objectContainer.add(rock5);
		objectContainer.add(rock6);
		objectContainer.add(rock7);
		objectContainer.add(rock8);
		objectContainer.add(rock9);
		objectContainer.add(rock10);
		return (ArrayList<Entity>) objectContainer;
	}

	public ArrayList<Entity> buildMap3() {
		Wall w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14, w15;
		w1 = new Wall(0, 50, 355, 20);
		w2 = new Wall(445, 50, 375, 20);
		w3 = new Wall(0, 50, 20, 640);
		w4 = new Wall(780, 50, 20, 640);
		w5 = new Wall(0, 550, 800, 20);
		w6 = new Wall(120, 150, 540, 20);
		w7 = new Wall(120, 350, 540, 20);
		w8 = new Wall(0, 250, 355, 20);
		w9 = new Wall(335, 150, 20, 100);
		w10 = new Wall(660, 150, 20, 120);
		w11 = new Wall(497, 250, 20, 100);
		w12 = new Wall(120, 350, 20, 110);
		w13 = new Wall(640, 350, 20, 190);
		w14 = new Wall(335, 460, 20, 90);
		w15 = new Wall(335, 460, 162, 20);

		objectContainer.add(w1);
		objectContainer.add(w2);
		objectContainer.add(w3);
		objectContainer.add(w4);
		objectContainer.add(w5);
		objectContainer.add(w6);
		objectContainer.add(w7);
		objectContainer.add(w8);
		objectContainer.add(w9);
		objectContainer.add(w10);
		objectContainer.add(w11);
		objectContainer.add(w12);
		objectContainer.add(w13);
		objectContainer.add(w14);
		objectContainer.add(w15);
		return (ArrayList<Entity>) objectContainer;
	}
}
