public class FirstEnemy extends Enemy{

    public FirstEnemy() {
        this.name = "FirstEnemy";
        this.lootList = new LootList();
        for(int e = 0; e <= 10; e++){
            this.lootList.addLegendaryItem(new Item("Epic_"+e));
        }
        for(int e = 0; e <= 10; e++){
            this.lootList.addEpicItem(new Item("Epic_"+e));
        }
        for(int e = 0; e < 10; e++){
            this.lootList.addRareItem(new Item("Rare_"+e));
        }
        for(int e = 0; e < 10; e++){
            this.lootList.addUnCommonItem(new Item("Uncommon_"+e));
        }
        for(int e = 0; e < 10; e++){
            this.lootList.addCommonItem(new Item("Common_"+e));
        }
        for(int e = 0; e < 10; e++){
            this.lootList.addTrashItem(new Item("Trash_"+e));
        }
    }
}
