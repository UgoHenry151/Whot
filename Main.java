import java.util.Scanner;
import java.util.*;
import java.io.*;

// "static void main" must be defined in a public class.
public class Main {
    public static int numberOfPlayers = 6;
    public static int initialNumberOfCards = 7;
    public static class Card {
        public String shape;
        public int number;
        Card(String my_shape, Integer my_number)
        {
            number = my_number;
            shape = my_shape;
        }
        public void print(){
            System.out.println(shape + " of " + Integer.toString(number));
        }
    }
    public static class Player{
        public String name;
        public List<Card> deck;
        Player()
        {
            name = new String();
            deck = new ArrayList<>();
        }
        Player(String my_name)
        {
            name = my_name;
            deck = new ArrayList<>();
        }
        public void printDeck(){
            for (Card card : deck)
                card.print();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Player> players = new ArrayList<>();
        for (int i=0; i < numberOfPlayers; i++)
        {  
            String my_name =new String(); 
            if (i == 0)
               my_name = "WA";
            if (i==1)
                my_name = "ZO";
            if (i==2)
                my_name = "BIA";
            if(i==3)
                my_name = "COME";
            if(i==4)
                my_name = "ZEE";
            if(i==5)
                my_name = "UGO";
            // System.out.println(my_name);
            Player player = new Player();
            player.name = my_name;
            players.add(player);
            // System.out.println(player.name);
        }
        for (Player player : players)
        {
            System.out.println(player.name);
        }

        Map<String, Integer> shapes = new HashMap<>();
        shapes.put("Square", 14);
        shapes.put("Cross", 14);
        shapes.put("Circle", 14);
        shapes.put("Triangle", 14);
        shapes.put("Star", 8);
        
        Set<Integer> numbersToSkip = new HashSet<>();
        numbersToSkip.add(6);
        numbersToSkip.add(9);
        numbersToSkip.add(15);
        numbersToSkip.add(16);
        numbersToSkip.add(17);
        numbersToSkip.add(18);
        numbersToSkip.add(19);
        
        Set<Integer> numbersToAvoid = new HashSet<>();
        numbersToAvoid.add(4);
        numbersToAvoid.add(8);
        numbersToAvoid.add(12);
        
        Map<String, Set<Integer>> avoid = new HashMap<>();
        avoid.put("Square", numbersToAvoid); 
        avoid.put("Cross", numbersToAvoid);
        
        List<Card> deck = new ArrayList<>();
        for (String shape : shapes.keySet())
        {
            for( int i = 1; i < shapes.get(shape)+1; ++i )
            {
                if(numbersToSkip.contains(i) || (avoid.keySet().contains(shape) && numbersToAvoid.contains(i)))
                {
                    continue;
                }
                Card newCard = new Card(shape, i);
                deck.add(newCard);
                
                // newCard.print();
            }
        }
        for(int i = 0; i < 5; ++i)
        {
            Card newCard = new Card("Whot", 20);
            deck.add(newCard);
        }
        
        // List<Card> playerCard = new ArrayList<>();
        for(Player player : players)
        {
           for(int i = 0; i < initialNumberOfCards; i++)
           {
               Card temp = deck.get(0);
               player.deck.add(temp);
               deck.remove(0);
           } 
            System.out.println(player.name);
            player.printDeck();    
        }

        System.out.println("");

        List<Card> putDeck = new ArrayList<>();
        Card start = deck.get(0);
        putDeck.add(start);
        start.print();
        
        // Card play = players.deck.get();
        // play.print();
        for(Player player : players)
        {
            Card topCard = putDeck.get(putDeck.size() - 1);
            for(int i = 0; i < player.deck.size(); i++)
            {
                Card play = player.deck.get(i);
                if(play.shape == topCard.shape || play.number == topCard.number)
                {
                    putDeck.add(play);
                    play.print();
                    player.deck.remove(i);
                    break;
                }
                if(i == deck.size() - 1)
                {
                    //Draw from market
                    player.deck.add(deck.get(0));
                    deck.remove(0);
                }
            }
   
        }
    }
    


}