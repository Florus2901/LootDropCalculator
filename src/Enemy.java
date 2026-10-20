public class Enemy {
    protected String name = null;
    protected LootList lootList = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LootList getLootList() {
        return lootList;
    }

    public void setLootList(LootList lootList) {
        this.lootList = lootList;
    }
}
