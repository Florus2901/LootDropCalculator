public class Main
{
    public static void main(String[] args) {
        FirstEnemy enemy = new FirstEnemy();

        for(int i = 0; i < 100; i++){
            Item item = enemy.lootList.rollLoot(enemy);
            String itemName = "Null";
            if(item != null){
                itemName = item.getName();
            }
            System.out.println("Roll " + i + " Gives: " + itemName);

        }
    }
}
