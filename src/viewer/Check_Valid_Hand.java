package viewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Player.Player;
import trading_resources.Marketplace;
import decks.Resource_Deck;
import cards.Resource;

public class Check_Valid_Hand extends Get_Input{

	public Check_Valid_Hand(Player p, Resource_Deck availableCards)
	{
		super(p);
		
		int totalSize = availableCards.size();
		int countGold = 0;
		int countCutlass = 0;
		int countWood = 0;
		int countMolasses = 0;
		int countGoat = 0;
		String gd = "Gold";
		String gt = "Goat";
		String m = "Molasses";
		String c = "Cutlass";
		String w = "Wood";
		boolean validity;
		
		
		countGold = availableCards.toString().split(gd, -1).length-1;
		countGoat = availableCards.toString().split(gt, -1).length-1;
		countCutlass = availableCards.toString().split(c, -1).length-1;
		countMolasses = availableCards.toString().split(m, -1).length-1;
		countWood = availableCards.toString().split(w, -1).length-1;
		
		
		if (countGold >= 2)
			super.add_option(String.format("%s", gd));
		
		if (countGoat >= 2)
			super.add_option(String.format("%s", gt));
		
		if (countMolasses >= 2)
			super.add_option(String.format("%s", m));
		
		if (countCutlass >= 2)
			super.add_option(String.format("%s", c));
			
		if (countWood >= 2)
			super.add_option(String.format("%s", w));
			
		
		if (countGold >= 2	|| countCutlass >= 2 || countWood >= 2 || countMolasses >= 2 || countGoat >= 2)
		{
			this.set_prompt(this.player_name()+" which two cards would you like to give up to trade?\n");
			validity = true;
		}
		
		else
		{
			super.add_option(String.format("exit"));
			this.set_prompt(this.player_name()+" you do not have enough cards to trade with the Stockpile.\nPlease enter: exit\n as your option.");
			validity = false;
		}
	}

}
