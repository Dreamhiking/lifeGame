package org.yjy.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.yjy.LifeGame;

public class T1_life {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		LifeGame game=new LifeGame();
		
		/*  NO:UnitTest1*/
		//game.init();
		//game.showAll();
		
		game.init();
		for(int i=0;i<3;i++){
			System.out .println("This is NO:"+i);			
			game.calucalteNext();
			game.showAll();
			System.out .println("\n\n");	
		}
	}
}
